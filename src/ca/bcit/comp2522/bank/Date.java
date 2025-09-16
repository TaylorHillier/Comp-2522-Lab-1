package ca.bcit.comp2522.bank;

/**
 * Represents a calendar date with validation
 * and day of the week calculations.
 *
 * @author Taylor Hillier
 * @author Calvin Nguyen
 * @version 1.0
 */
public class Date {

    /** The year of the date. */
    private final int year;

    /** The month of the date. */
    private final int month;

    /** The day of the date. */
    private final int day;

    /** Minimum valid day value. */
    private static final int MIN_DAY = 1;

    /** Minimum valid month value. */
    private static final int MIN_MONTH = 1;

    /** Maximum valid month value. */
    private static final int MAX_MONTH = 12;

    /** Number of months in a year. */
    private static final int MONTHS_IN_YEAR = 12;

    /** Number of days in a week. */
    private static final int DAYS_IN_WEEK = 7;

    /** The current year. */
    private static final int CURRENT_YEAR = 2025;

    /** Minimum valid year value. */
    private static final int MIN_YEAR = 1800;

    /** Year constant for the 1900s. */
    private static final int DATE_CALC_CONSTANT = 1900;

    /** Year constant for the 2000s. */
    private static final int YEAR_TWO_THOUSAND = 2000;

    /** Day of the week constant for Saturday.*/
    private static final int SATURDAY = 0;

    /** Day of the week constant for Sunday.*/
    private static final int SUNDAY = 1;

    /** Day of the week constant for Monday.*/
    private static final int MONDAY = 2;

    /** Day of the week constant for Tuesday.*/
    private static final int TUESDAY = 3;

    /** Day of the week constant for Wednesday.*/
    private static final int WEDNESDAY = 4;

    /** Day of the week constant for Thursday.*/
    private static final int THURSDAY = 5;

    /** Day of the week constant for Friday.*/
    private static final int FRIDAY = 6;

    /** Month codes used in algorithm from Jan-Dec. */
    private static final String MONTH_CODES = "144025036146";

    /** Adjustment added for dates in for 2000s. */
    private static final int ADJUSTMENT_2000S = 6;

    /** Adjustment added for dates in for 1800s. */
    private static final int ADJUSTMENT_1800S = 2;

    /** Adjustment applied for leap years. */
    private static final int ADJUSTMENT_LEAP_YEAR = 2;

    /** Number of days in January. */
    static final int JAN_DAYS = 31;

    /** Number of days in February (non-leap year). */
    static final int FEB_DAYS = 28;

    /** Number of days in March. */
    static final int MAR_DAYS = 31;

    /** Number of days in April. */
    static final int APR_DAYS = 30;

    /** Number of days in May. */
    static final int MAY_DAYS = 31;

    /** Number of days in June. */
    static final int JUN_DAYS = 30;

    /** Number of days in July. */
    static final int JUL_DAYS = 31;

    /** Number of days in August. */
    static final int AUG_DAYS = 31;

    /** Number of days in September. */
    static final int SEP_DAYS = 30;

    /** Number of days in October. */
    static final int OCT_DAYS = 31;

    /** Number of days in November. */
    static final int NOV_DAYS = 30;

    /** Number of days in December. */
    static final int DEC_DAYS = 31;

    /** Number of days in February during leap year. */
    static final int FEB_DAYS_LEAPYEAR = 29;

    /** Offset for return index in getDaysInMonth function. */
    static final int DAYS_IN_MONTH_OFFSET = 1;

    /** Offset for return index in getMonthName function. */
    private static final int GET_MONTH_NAME_OFFSET = 1;

    /** Initial value for day-of-week calculation. */
    private static final int INITIAL_DAY_OF_WEEK_RESULT = 0;

    /** Divisor for detecting leap years. */
    private static final int LEAP_YEAR_DIVISOR = 4;

    /** Divisor for detecting century years. */
    private static final int CENTURY_DIVISOR = 100;

    /** Divisor for detecting 400-year leap years. */
    private static final int FOUR_CENTURY_DIVISOR = 400;

    /** Divisor used in the remainder step in getDayOfTheWeek function  */
    private static final int DAY_OF_WEEK_FOUR_DIVISOR = 4;

    /** Remainder value which indicates an even division. */
    private static final int NO_REMAINDER = 0;

    /** Index position for February in month array. */
    private static final int FEBRUARY_INDEX = 1;


    /**
     * Constructs a new Date object.
     *
     * @param day the day of the month
     * @param month the month
     * @param year the year
     * @throws IllegalArgumentException if the date is invalid
     */
    public Date(final int day, final int month, final int year) {
        validateDate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the day of the month.
     *
     * @return the day of the month
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the month as an integer.
     *
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the month name.
     *
     * @param month for the month as an integer
     * @return month name as a string
     */
    public String getMonthName(int month) {
        final String[] monthNames = {
                "January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December"
        };

        return monthNames[month - GET_MONTH_NAME_OFFSET];
    }

    /**
     * Returns the date in the format "YYYY-MM-DD".
     *
     * @return the formatted date string
     */
    public String getYYYYMMDD() {
        return (year + "-" + month + "-" + day);
    }

    /**
     * Returns the day of the week for this date.
     *
     * @return day of the week as a String
     */
    public String getDayOfTheWeek(){

        int result;

        result = INITIAL_DAY_OF_WEEK_RESULT;

        if (year >= YEAR_TWO_THOUSAND)
        {
            result = ADJUSTMENT_2000S;

        } else if(year >= MIN_YEAR && year <= DATE_CALC_CONSTANT)
        {
            result = ADJUSTMENT_1800S;
        }

        // Leap year adjustment for January and February
        if ((year % LEAP_YEAR_DIVISOR == NO_REMAINDER && year % CENTURY_DIVISOR != NO_REMAINDER)
                || (year % FOUR_CENTURY_DIVISOR == NO_REMAINDER)) {
            result = ADJUSTMENT_LEAP_YEAR;
        }

        final int lastTwoDigitsOfYear;
        final int numberOfTwelves;
        final int remainder;
        final int numberOfFours;
        final int sum;
        final int sumTwo;
        final int finalResult;

        lastTwoDigitsOfYear = year % CENTURY_DIVISOR;
        numberOfTwelves = lastTwoDigitsOfYear / MONTHS_IN_YEAR;
        remainder = lastTwoDigitsOfYear - numberOfTwelves * MONTHS_IN_YEAR;
        numberOfFours = remainder / DAY_OF_WEEK_FOUR_DIVISOR;
        sum = result + day + numberOfFours + remainder + numberOfTwelves;
        sumTwo = sum + Character.getNumericValue(MONTH_CODES.charAt(month - DAYS_IN_MONTH_OFFSET));
        finalResult = sumTwo % DAYS_IN_WEEK;

        if (finalResult == SATURDAY) {
            return "Saturday";
        } else if (finalResult == SUNDAY) {
            return "Sunday";
        } else if (finalResult == MONDAY) {
            return "Monday";
        } else if (finalResult == TUESDAY) {
            return "Tuesday";
        } else if (finalResult == WEDNESDAY) {
            return "Wednesday";
        } else if (finalResult == THURSDAY) {
            return "Thursday";
        } else if (finalResult == FRIDAY) {
            return "Friday";
        } else {
            return "Error";
        }


    }

    /**
     * Returns the number of days in a given month and year.
     *
     * @param year the year
     * @param month the month
     * @return the number of days in a month
     */
    private static int getDaysInMonth(final int year, final int month) {
        int[] daysInMonth = {
                JAN_DAYS,
                FEB_DAYS,
                MAR_DAYS,
                APR_DAYS,
                MAY_DAYS,
                JUN_DAYS,
                JUL_DAYS,
                AUG_DAYS,
                SEP_DAYS,
                OCT_DAYS,
                NOV_DAYS,
                DEC_DAYS
        };

        // Adjust February for leap years
        if ((year % LEAP_YEAR_DIVISOR == NO_REMAINDER && year % CENTURY_DIVISOR != NO_REMAINDER)
                || (year % FOUR_CENTURY_DIVISOR == NO_REMAINDER)) {
            daysInMonth[FEBRUARY_INDEX] = FEB_DAYS_LEAPYEAR;
        }


        return daysInMonth[month - DAYS_IN_MONTH_OFFSET];
    }

    /**
     * Validates a date within the valid date ranges.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     * @throws IllegalArgumentException if the year, month or day is invalid
     */
    private static void validateDate(final int year, final int month, final int day){
        if(year < MIN_YEAR || year > CURRENT_YEAR){
            throw new IllegalArgumentException("Invalid Year");
        }

        if(month < MIN_MONTH || month > MAX_MONTH){
            throw new IllegalArgumentException("Invalid Month");
        }

        if(day < MIN_DAY || day > getDaysInMonth(year, month)){
            throw new IllegalArgumentException("Invalid Day");
        }
    }


    /**
     * Returns a string representation of this date.
     *
     * @return formatted date string
     */
    public String toString(){
        final StringBuilder builder = new StringBuilder();
        builder.append(getDayOfTheWeek().toLowerCase())
                .append(", ")
                .append(getMonthName(getMonth()))
                .append(" ")
                .append(getDay())
                .append(", ")
                .append(getYear());
        return builder.toString();
    }

}
