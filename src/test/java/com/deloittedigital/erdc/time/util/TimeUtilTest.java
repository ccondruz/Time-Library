package com.deloittedigital.erdc.time.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeUtilTest {


    @Test
    @DisplayName("Sanity check: NPE thrown when 1st parameter is null.")
    void shouldPassWhenExceptionOnNullFirstParameter() {
        // Given:
        final LocalDate start = null;
        final LocalDate end = LocalDate.of(2018, 7, 13);

        // Then:
        assertThrows(NullPointerException.class,
                // When:
                () -> TimeUtil.weeksBetween(start, end)
        );
    }

    @Test
    @DisplayName("Sanity check: NPE thrown when 2nd parameter is null.")
    void shouldPassWhenExceptionOnNullSecondParameter() {
        // Given:
        final LocalDate start = LocalDate.of(2018, 7, 10);
        final LocalDate end = null;


        // Then:
        assertThrows(NullPointerException.class,
                // When:
                () -> TimeUtil.weeksBetween(start, end)
        );
    }

    @Test
    @DisplayName("Sanity check: NPE thrown when both parameters are null.")
    void shouldPassWhenExceptionOnNullBothParameters() {
        // Given:
        // Start and End Dates as null.

        // Then:
        assertThrows(NullPointerException.class,
                // When:
                () -> TimeUtil.weeksBetween(null, null)
        );
    }


    @Test
    @DisplayName("Sanity check: IAE thrown when startDate is AFTER endDate.")
    void shouldPassWhenExceptionOnStartDateAfterEnd() {
        // Given:
        final LocalDate start = LocalDate.of(2018, 7, 13);;
        final LocalDate end = LocalDate.of(2018, 7, 10);;

        // Then:
        final String expectedMessage = "Start Date cannot be after End Date!";
        assertThrows(IllegalArgumentException.class,
                // When:
                () -> TimeUtil.weeksBetween(start, end),
                expectedMessage
        );
    }

    @Test
    @DisplayName("Correctly determined: 0 week(s) with 4 leftover days, within same week.")
    void shouldPassWhenOnlyLeftoverDaysDuringSameWeek() {
        // Given:
        final LocalDate start = LocalDate.of(2018, 7, 9);
        final LocalDate end = LocalDate.of(2018, 7, 13);

        // When:
        final TimeUtil.WeeksInfo weeks = TimeUtil.weeksBetween(start, end);

        // Then:
        long expectedWeeks = 0;
        long actualWeeks = weeks.getWeeks();
        assertEquals(expectedWeeks, actualWeeks);

        long expectedDays = 4;
        long actualDays = weeks.getExtraDays();
        assertEquals(expectedDays, actualDays);
    }

    @Test
    @DisplayName("Correctly determined: 0 week(s) with 4 leftover days, over consecutive weeks.")
    void shouldPassWhenOnlyLeftoverDaysDuringConsecutiveWeeks() {
        // Given:
        final LocalDate start = LocalDate.of(2018, 7, 14);
        final LocalDate end = LocalDate.of(2018, 7, 18);

        // When:
        final TimeUtil.WeeksInfo weeks = TimeUtil.weeksBetween(start, end);

        // Then:
        long expectedWeeks = 0;
        long actualWeeks = weeks.getWeeks();
        assertEquals(expectedWeeks, actualWeeks);

        long expectedDays = 4;
        long actualDays = weeks.getExtraDays();
        assertEquals(expectedDays, actualDays);
    }

    @Test
    @DisplayName("Correctly determined: 1 week with 0 leftover days, within same week.")
    void shouldPassWhenOneTotalWeekNonconsecutiveWeeksAndZeroLeftoverDays() {
        // Given:
        final LocalDate start = LocalDate.of(2018, 7, 9);
        final LocalDate end = LocalDate.of(2018, 7, 16);

        // When:
        final TimeUtil.WeeksInfo weeks = TimeUtil.weeksBetween(start, end);

        // Then:
        long expectedWeeks = 1;
        long actualWeeks = weeks.getWeeks();
        assertEquals(expectedWeeks, actualWeeks);

        long expectedDays = 0;
        long actualDays = weeks.getExtraDays();
        assertEquals(expectedDays, actualDays);
    }

    @Test
    @DisplayName("Correctly determined: 1 week with 0 leftover days, over 2 consecutive weeks.")
    void shouldPassWhenOneTotalWeekConsecutiveWeeksAndZeroLeftoverDays() {
        // Given:
        final LocalDate start = LocalDate.of(2018, 7, 10);
        final LocalDate end = LocalDate.of(2018, 7, 17);

        // When:
        final TimeUtil.WeeksInfo weeks = TimeUtil.weeksBetween(start, end);

        // Then:
        long expectedWeeks = 1;
        long actualWeeks = weeks.getWeeks();
        assertEquals(expectedWeeks, actualWeeks);

        long expectedDays = 0;
        long actualDays = weeks.getExtraDays();
        assertEquals(expectedDays, actualDays);
    }

    @Test
    @DisplayName("Correctly determined: 1 week with 3 leftover days, over 2 consecutive weeks.")
    void shouldPassWhenOneTotalWeekConsecutiveWeeksAndLeftoverDays() {
        // Given:
        final LocalDate start = LocalDate.of(2018, 7, 11);
        final LocalDate end = LocalDate.of(2018, 7, 20);

        // When:
        final TimeUtil.WeeksInfo weeks = TimeUtil.weeksBetween(start, end);

        // Then:
        long expectedWeeks = 1;
        long actualWeeks = weeks.getWeeks();
        assertEquals(expectedWeeks, actualWeeks);

        long expectedDays = 2;
        long actualDays = weeks.getExtraDays();
        assertEquals(expectedDays, actualDays);
    }

    @Test
    @DisplayName("Correctly determined: 14 week(s) with 6 leftover days.")
    void shouldPassWhenMultiweekAndLeftoverDays() {
        // Given:
        final LocalDate start = LocalDate.of(2018, 4, 7);
        final LocalDate end = LocalDate.of(2018, 7, 20);

        // When:
        final TimeUtil.WeeksInfo weeks = TimeUtil.weeksBetween(start, end);

        // Then:
        long expectedWeeks = 14;
        long actualWeeks = weeks.getWeeks();
        assertEquals(expectedWeeks, actualWeeks);

        long expectedDays = 6;
        long actualDays = weeks.getExtraDays();
        assertEquals(expectedDays, actualDays);
    }

    @Test
    @DisplayName("Correctly determined: 14 week(s) with 0 leftover days.")
    void shouldPassWhenMultiweekAndZeroLeftoverDays() {
        // Given:
        final LocalDate start = LocalDate.of(2018, 4, 7);
        final LocalDate end = LocalDate.of(2018, 7, 14);

        // When:
        final TimeUtil.WeeksInfo weeks = TimeUtil.weeksBetween(start, end);

        // Then:
        long expectedWeeks = 14;
        long actualWeeks = weeks.getWeeks();
        assertEquals(expectedWeeks, actualWeeks);

        long expectedDays = 0;
        long actualDays = weeks.getExtraDays();
        assertEquals(expectedDays, actualDays);
    }

    // TODO Tests:
    // TODO .asDays() only days (incomplete week).
    // TODO .asDays() over single week and 0 leftover days.
    // TODO .asDays() Single week and leftover days.
    // TODO .asDays() Multi-week and leftover days.

    // TODO startDate equals endDate.
    // TODO Multi-year test(s?).
}
