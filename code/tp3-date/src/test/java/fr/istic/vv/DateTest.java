package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testIsValidDate() {
        assertTrue(Date.isValidDate(1, 1, 2022));
        assertFalse(Date.isValidDate(0, 1, 2022));
        assertFalse(Date.isValidDate(1, 0, 2022));
        assertFalse(Date.isValidDate(32, 1, 2022));
        assertFalse(Date.isValidDate(1, 13, 2022));
        assertFalse(Date.isValidDate(29, 2, 2021));
        assertTrue(Date.isValidDate(29, 2, 2024));
    }

    @Test
    void testIsLeapYear() {
        assertFalse(Date.isLeapYear(2021));
        assertTrue(Date.isLeapYear(2024));
        assertFalse(Date.isLeapYear(1900));
        assertTrue(Date.isLeapYear(2000));
    }

    @Test
    void testNextDate() {
        Date date = new Date(31, 12, 2021);
        Date nextDate = date.nextDate();
        assertEquals(1, nextDate.day);
        assertEquals(1, nextDate.month);
        assertEquals(2022, nextDate.year);
    }

    @Test
    void testPreviousDate() {
        Date date = new Date(1, 1, 2022);
        Date previousDate = date.previousDate();
        assertEquals(31, previousDate.day);
        assertEquals(12, previousDate.month);
        assertEquals(2021, previousDate.year);
    }

    @Test
    void testCompareTo() {
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(1, 1, 2023);
        Date date3 = new Date(1, 2, 2022);

        assertTrue(date1.compareTo(date2) < 0);
        assertTrue(date2.compareTo(date1) > 0);
        assertTrue(date1.compareTo(date3) < 0);
        assertTrue(date3.compareTo(date1) > 0);
        assertEquals(0, date1.compareTo(date1));
    }
}

    