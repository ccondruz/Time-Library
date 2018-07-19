package com.deloittedigital.erdc.time.util;

import java.time.LocalDate;

/**
 * An utility class that provides helper methods for interacting with time periods.
 */
public class TimeUtil {

    private TimeUtil() {
        throw new RuntimeException("This is an utility class, it should not be instantiated!");
    }

    /**
     * Computes the number of weeks between an interval of two dates, with possibly an extra 1-6 days for an incomplete
     * week.
     *
     * @param startDate indicating the beginning date of the time interval. Not {@code null}
     * @param endDate   a later date, indicating the end of the interval. Not {@code null}, equal or after {@code startDate}
     *
     * @return an object which indicates how many weeks (and possibly extra days) are between the two dates
     *
     * @see WeeksInfo
     */
    public static WeeksInfo weeksBetween(LocalDate startDate, LocalDate endDate) {
        // TODO Implement me
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * Immutable class that holds data about number of weeks (and possibly up-to 6 extra days) between a time interval defined
     * by two dates.
     *
     * @see TimeUtil#weeksBetween(LocalDate, LocalDate)
     */
    public static final class WeeksInfo {

        private final int weeks;
        private final int extraDays;
        private final int totalDays;
        private final LocalDate startDate;
        private final LocalDate endDate;

        /**
         * Creates an immutable instance of this object using given parameters.
         * In addition, caches the total number of days, for given no. of weeks and extra days.
         *
         * @param startDate indicates the beginning date of the time interval
         * @param endDate   a later date, indicating the end of the time interval
         * @param weeks     indicates the number of weeks
         * @param extraDays a number between 0-6 accounting for leftover days in an incomplete week
         */
        public WeeksInfo(LocalDate startDate, LocalDate endDate, int weeks, int extraDays) {
            this.weeks = weeks;
            this.extraDays = extraDays;
            this.totalDays = (weeks * 7) + extraDays;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        /**
         * Returns number of weeks between a time interval.
         *
         * @return the number of weeks, >= 0
         */
        public int getWeeks() {

            return weeks;
        }

        /**
         * Returns the number of leftover days of (possibly) an incomplete week.
         *
         * @return the number of leftover days; between 0 and 6.
         */
        public int getExtraDays() {

            return extraDays;
        }

        /**
         * Returns the beginning date, used for calculation.
         *
         * @return the beginning date, not {@code null}.
         */
        public LocalDate getStartDate() {

            return startDate;
        }

        /**
         * Returning the ending date, of the calculation.
         *
         * @return the local finish date, not {@code null}.
         */
        public LocalDate getEndDate() {
            return endDate;
        }

        /**
         * Returns the number of weeks, and any leftover days, between two input dates <em>as total days</em>.
         *
         * @return the total number of days between two dates.
         */
        public int asDays() {

            return totalDays;
        }

        /**
         * Returns a textual representation of this instance.
         *
         * @return the textual representation
         */
        @Override
        public String toString() {

            return "Between " + startDate + " and " + endDate + " are " + weeks + " weeks and " + extraDays + " extra days.";
        }
    }
}