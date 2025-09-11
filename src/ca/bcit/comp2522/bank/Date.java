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

    /** Minimum valid month value. */
    private static final int MIN_MONTH = 1;

    /** Maximum valid month value. */
    private static final int MAX_MONTH = 12;

    /** The current year (hardcoded for this lab). */
    private static int CURRENT_YEAR = 2025;

    /** Minimum valid year value. */
    private static final int MIN_YEAR = 1800;

    /** Year constant for the 1900s. */
    private final int DATE_CALC_CONSTANT = 1900;

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

    /**
     * Constructs a new Date object.
     *
     * @param day
     * @param month
     * @param year
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
     * Returns the year
     *
     * @return the
     */
    public int getYear() {
        return year;
    }

    public String getMonthName(int month) {
        final String[] monthNames = {
                "January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December"
        };

        return monthNames[month - 1];
    }

    /**
     * Returns the date in the format "YYYY-MM-DD".
     *
     * @return the formatted date string
     */
    public String getYYYYMMDD() {
        return (year + "-" + month + "-" + day);
    }

    public String getDayOfTheWeek(){

        int result = 0;

        if(year >= YEAR_TWO_THOUSAND)
        {
            result = 6;
        } else if(year >= MIN_YEAR && year <= DATE_CALC_CONSTANT)
        {
            result = 2;
        }

        if(((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) && month > 2){
            result = 2;
        }

        String monthCode = "144025036146";

        final int lastTwoDigitsOfYear = year % 100;
        final int numberOfTwelves = lastTwoDigitsOfYear / 12;
        final int remainder = lastTwoDigitsOfYear - numberOfTwelves * 12;
        final int numberOfFours = remainder / 4;
        final int sum = result + day + numberOfFours + remainder + numberOfTwelves;
        final int sumTwo = sum + Character.getNumericValue(monthCode.charAt(month - 1));
        final int finalResult = sumTwo % 7;

        switch (finalResult) {
            case SATURDAY:
                return "Saturday";

            case SUNDAY:
                return "Sunday";

            case MONDAY:
                return "Monday";

            case TUESDAY:
                return "Tuesday";

            case WEDNESDAY:
                return "Wednesday";

            case THURSDAY:
                return "Thursday";

            case FRIDAY:
                return "Friday";

            default:
                return "Error";

        }

    }

    private static int getDaysInMonth(int year, int month) {
        int[] daysInMonth = {
                31, // Jan
                28, // Feb
                31, // Mar
                30, // Apr
                31, // May
                30, // Jun
                31, // Jul
                31, // Aug
                30, // Sep
                31, // Oct
                30, // Nov
                31  // Dec
        };

        // Adjust February for leap years
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysInMonth[1] = 29;
        }

        return daysInMonth[month - 1];
    }

    private static void validateDate(final int year, final int month, final int day){
        if(year < MIN_YEAR || year > CURRENT_YEAR){
            throw new IllegalArgumentException("Invalid Year");
        }

        if(month < MIN_MONTH || month > MAX_MONTH){
            throw new IllegalArgumentException("Invalid Month");
        }

        if(day < 1 || day > getDaysInMonth(year, month)){
            throw new IllegalArgumentException("Invalid Day");
        }
    }



    public String toString(){
        return this.getDayOfTheWeek().toLowerCase() + ", " +  this.getMonthName(this.getMonth()) + " " + this.getDay() + ", " + this.getYear();
    }

}
