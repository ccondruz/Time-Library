package com.deloittedigital.erdc.time.util;

import java.time.LocalDate;

/**
 * This is an utility class that provides method for calculating how many weeks are between two dates.
 */
public class TimeUtil {

    private TimeUtil() {
        throw new RuntimeException("This is an utility class, it should not be instantiated!");
    }

    /**
     * This method is used to return an object of type
     *
     * @param startDate indicates the beginning date of the time interval
     * @param endDate   represent a later date and indicates the end of the time interval.
     * @return a WeeksInfo that indicates how many weeks and extra days are between two dates.
     * @see WeeksInfo
     */
    public static WeeksInfo weeksBetween(LocalDate startDate, LocalDate endDate) {
        // TODO Implement me
        throw new UnsupportedOperationException();
    }

    /**
     * Immutable class that holds data about number of weeks and extra days between a time interval defined
     * by two dates.
     */
    public static final class WeeksInfo {
        private final int weeks;
        private final int extraDays;
        private final int totalDays;
        private final LocalDate startDate;
        private final LocalDate endDate;

        /**
         * Creates an instance of this object using given parameters.
         * In addition, stores in cache the total number of days, for weeks and extra days data.
         *
         * @param startDate indicates the beginning date of the time interval.
         * @param endDate   represent a later date and indicates the end of the time interval.
         * @param weeks     indicates the number of weeks.
         * @param extraDays This is the second field.
         */
        public WeeksInfo(LocalDate startDate, LocalDate endDate, int weeks, int extraDays) {
            this.weeks = weeks;
            this.extraDays = extraDays;
            this.totalDays = (weeks * 7) + extraDays;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        /**
         * This method returns number of weeks between a time interval.
         *
         * @return the number of weeks, >= 0
         */
        public int getWeeks() {
            return weeks;

        }

        /**
         * This method returns the number of extra days of an incomplete week.
         *
         * @return the number of extra days, between 0 and 6.
         */
        public int getExtraDays() {
            return extraDays;

        }

        /**
         * Method for returning the beginning date for calculation.
         *
         * @return the local beginning date, not null.
         */
        public LocalDate getStartDate() {
            return startDate;
        }

        /**
         * Method for returning the finish date of the calculation.
         *
         * @return the local finish date, not null.
         */
        public LocalDate getEndDate() {
            return endDate;
        }

        /**
         * This method returns the total number of days between two input date parameters.
         *
         * @return the total number of days between two dates.
         */
        public int asDays() {

            return totalDays;
        }

        /**
         * Method that returns a textual representation of a WeekInfo object.
         * @return the textual representation of a WeekInfo object.
         */
        @Override
        public String toString() {
            return "Between " + startDate + " and " + endDate + " are " + weeks + " weeks and " + extraDays + " extra days.";
        }
    }

    public static void main(String[] args) {

    }
}