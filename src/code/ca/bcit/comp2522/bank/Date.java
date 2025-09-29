package ca.bcit.comp2522.bank;

/**
 * Represents a calendar date with validation
 * and day of the week calculations.
 *
 * @author Taylor Hillier
 * @author Calvin Nguyen
 * @version 1.0
 */
public class Date
{
    // constants and operands for getDayOfTheWeek function
    private static final int MIN_DAY = 1;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MONTHS_IN_YEAR = 12;
    private static final int DAYS_IN_WEEK = 7;
    private static final int CURRENT_YEAR = 2025;
    private static final int MIN_YEAR = 1800;
    private static final int DATE_CALC_CONSTANT = 1900;
    private static final int YEAR_TWO_THOUSAND = 2000;
    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;
    private static final String MONTH_CODES = "144025036146";
    private static final int ADJUSTMENT_2000S = 6;
    private static final int ADJUSTMENT_1800S = 2;
    private static final int ADJUSTMENT_LEAP_YEAR = 2;

    // number of days in each month
    static final int JAN_DAYS = 31;
    static final int FEB_DAYS = 28;
    static final int MAR_DAYS = 31;
    static final int APR_DAYS = 30;
    static final int MAY_DAYS = 31;
    static final int JUN_DAYS = 30;
    static final int JUL_DAYS = 31;
    static final int AUG_DAYS = 31;
    static final int SEP_DAYS = 30;
    static final int OCT_DAYS = 31;
    static final int NOV_DAYS = 30;
    static final int DEC_DAYS = 31;
    static final int FEB_DAYS_LEAPYEAR = 29;

    // corresponding month numbers
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;


    //constants for mathematical operations
    static final int DAYS_IN_MONTH_OFFSET = 1;
    private static final int GET_MONTH_NAME_OFFSET = 1;
    private static final int INITIAL_DAY_OF_WEEK_RESULT = 0;
    private static final int LEAP_YEAR_DIVISOR = 4;
    private static final int CENTURY_DIVISOR = 100;
    private static final int FOUR_CENTURY_DIVISOR = 400;
    private static final int DAY_OF_WEEK_FOUR_DIVISOR = 4;
    private static final int NO_REMAINDER = 0;
    private static final int FEBRUARY_INDEX = 1;

    // instance variables for date constructor
    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructs a new Date object.
     *
     * @param day   the day of the month
     * @param month the month
     * @param year  the year
     * @throws IllegalArgumentException if the date is invalid
     */
    public Date(final int day,
                final int month,
                final int year)
    {
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
    public int getDay()
    {
        return day;
    }

    /**
     * Returns the month as an integer.
     *
     * @return the month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Returns the year.
     *
     * @return the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the month name.
     *
     * @param month for the month as an integer (1–12)
     * @return month name as a string
     */
    public String getMonthName(int month)
    {
        if (month == JANUARY)
        {
            return "January";
        }
        else if (month == FEBRUARY)
        {
            return "February";
        }
        else if (month == MARCH)
        {
            return "March";
        }
        else if (month == APRIL)
        {
            return "April";
        }
        else if (month == MAY)
        {
            return "May";
        }
        else if (month == JUNE)
        {
            return "June";
        }
        else if (month == JULY)
        {
            return "July";
        }
        else if (month == AUGUST)
        {
            return "August";
        }
        else if (month == SEPTEMBER)
        {
            return "September";
        }
        else if (month == OCTOBER)
        {
            return "October";
        }
        else if (month == NOVEMBER)
        {
            return "November";
        }
        else if (month == DECEMBER)
        {
            return "December";
        }
        else
        {
            throw new IllegalArgumentException("Month not valid.");
        }
    }


    /**
     * Returns the date in the format "YYYY-MM-DD".
     *
     * @return the formatted date string
     */
    public String getYYYYMMDD()
    {
        return (year + "-" + month + "-" + day);
    }

    /**
     * Returns the day of the week for this date.
     * Process:
     * step 1: calculate the number of twelves in last two digits of year
     * step 2: calculate the remainder from step 1 using number of twelves
     * step 3: calculate the number of fours in step 2 by dividing by 4
     * step 4: add the day of the month to each step above
     * step 5: add the month code (for jfmamjjasond: 144025036146)
     * step 6: add the previous five numbers
     * step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6
     * <p>
     * Example Process:
     * step 0: add 6 for dates in the 2000s: NUMBER IS 6
     * step 1: there is 1 twelve in 21; NUMBER IS 1
     * step 2: 21/12 = 1 remainder 9; NUMBER IS 9
     * step 3: there are 2 fours in 9: NUMBER IS 2
     * step 4: NUMBER IS 15
     * step 5: month code for march is 4: NUMBER IS 4
     * step 6: Add all numbers 6+1+9+2+15+4 = 37 NUMBER is 2: 37 mod 7 is 2
     * step 7: 37%7 = 2; 2 means monday
     * </p>
     *
     * @return day of the week as a String
     */
    public String getDayOfTheWeek()
    {
        int initialCount;

        final int lastTwoDigitsOfYear;
        final int numberOfTwelves;
        final int remainder;
        final int numberOfFours;
        final int sum;
        final int sumTwo;
        final int finalResult;

        initialCount = INITIAL_DAY_OF_WEEK_RESULT;

        //if year is greater than 2000 add 6
        //else if year is in 1800's add 2
        if (year >= YEAR_TWO_THOUSAND)
        {
            initialCount = ADJUSTMENT_2000S;

        }
        else if (year >= MIN_YEAR && year <= DATE_CALC_CONSTANT)
        {
            initialCount = ADJUSTMENT_1800S;
        }

        // Leap year adjustment for January and February
        if ((year % LEAP_YEAR_DIVISOR == NO_REMAINDER && year % CENTURY_DIVISOR != NO_REMAINDER)
            || (year % FOUR_CENTURY_DIVISOR == NO_REMAINDER))
        {
            initialCount = ADJUSTMENT_LEAP_YEAR;
        }

        //step 0
        lastTwoDigitsOfYear = year % CENTURY_DIVISOR;

        //step 1
        numberOfTwelves = lastTwoDigitsOfYear / MONTHS_IN_YEAR;

        //step 2
        remainder = lastTwoDigitsOfYear - numberOfTwelves * MONTHS_IN_YEAR;

        //step 3
        numberOfFours = remainder / DAY_OF_WEEK_FOUR_DIVISOR;

        //step 4
        sum = initialCount + day + numberOfFours + remainder + numberOfTwelves;

        //step 5
        sumTwo = sum + Character.getNumericValue(MONTH_CODES.charAt(month - DAYS_IN_MONTH_OFFSET));

        //step 6
        finalResult = sumTwo % DAYS_IN_WEEK;

        //step 7
        if (finalResult == SATURDAY)
        {
            return "Saturday";
        }
        else if (finalResult == SUNDAY)
        {
            return "Sunday";
        }
        else if (finalResult == MONDAY)
        {
            return "Monday";
        }
        else if (finalResult == TUESDAY)
        {
            return "Tuesday";
        }
        else if (finalResult == WEDNESDAY)
        {
            return "Wednesday";
        }
        else if (finalResult == THURSDAY)
        {
            return "Thursday";
        }
        else if (finalResult == FRIDAY)
        {
            return "Friday";
        }
        else
        {
            throw new IllegalArgumentException("Month not valid.");
        }
    }

    /**
     * Returns the number of days in a given month and year.
     *
     * @param year  the year
     * @param month the month (1-12)
     * @return the number of days in the given month
     */
    private static int getDaysInMonth(final int year,
                                      final int month)
    {
        if (month == JANUARY)
        {
            return JAN_DAYS;
        }
        else if (month == FEBRUARY)
        {
            if ((year % LEAP_YEAR_DIVISOR == NO_REMAINDER && year % CENTURY_DIVISOR != NO_REMAINDER)
                || (year % FOUR_CENTURY_DIVISOR == NO_REMAINDER))
            {
                return FEB_DAYS_LEAPYEAR;
            }
            else
            {
                return FEB_DAYS;
            }
        }
        else if (month == MARCH)
        {
            return MAR_DAYS;
        }
        else if (month == APRIL)
        {
            return APR_DAYS;
        }
        else if (month == MAY)
        {
            return MAY_DAYS;
        }
        else if (month == JUNE)
        {
            return JUN_DAYS;
        }
        else if (month == JULY)
        {
            return JUL_DAYS;
        }
        else if (month == AUGUST)
        {
            return AUG_DAYS;
        }
        else if (month == SEPTEMBER)
        {
            return SEP_DAYS;
        }
        else if (month == OCTOBER)
        {
            return OCT_DAYS;
        }
        else if (month == NOVEMBER)
        {
            return NOV_DAYS;
        }
        else if (month == DECEMBER)
        {
            return DEC_DAYS;
        }
        else
        {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }


    /**
     * Validates a date within the valid date ranges.
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     */
    private static void validateDate(final int year,
                                     final int month,
                                     final int day)
    {
        if (year < MIN_YEAR || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid Year");
        }

        if (month < MIN_MONTH || month > MAX_MONTH)
        {
            throw new IllegalArgumentException("Invalid Month");
        }

        if (day < MIN_DAY || day > getDaysInMonth(year, month))
        {
            throw new IllegalArgumentException("Invalid Day");
        }
    }


    /**
     * Returns a string representation of this date.
     *
     * @return formatted date string
     */
    public String toString()
    {
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
