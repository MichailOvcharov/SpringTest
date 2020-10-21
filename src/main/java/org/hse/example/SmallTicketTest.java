package org.hse.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallTicketTest {
    /**
     *  Проверяет, что конструктор генерирует билет для корректных данных (номер билета)
     */
    @Test
    public void ticketConstructorNormalWork() {
        // when
        MealTicket ticket = new SmallTicket(10);
        // then
        assertNotNull(ticket);
    }
    /**
     *  Проверяет, что будет, если на вход конструктору поступило отрицательное число
     */
    @Test// (expected = IllegalArgumentException.class)
    public void negativeTicket() {
        // when
        Exception exception = null;
        try {
            MealTicket ticket = new SmallTicket(-10);
        } catch (Exception e)  {
            exception = e;
        }
        // then
//        assertThrows(IllegalArgumentException.class, () -> new Ticket(-10));
//        assertThrows("Попытка создать билет с отрицательным номером!",
//                IllegalArgumentException.class,
//                () -> new Ticket(-10));
        assertNotNull(exception);
        assertEquals(IllegalArgumentException.class, exception.getClass());
        assertEquals("Попытка создать билет с отрицательным номером!", exception.getMessage());
    }
    /**
     * Проверяет, что будет если подали на вход более чем четырехзначное число
     */
    @Test
    public void moreThenSixDigit() {
        // when
        Exception exception = null;
        try {
            new SmallTicket(10000);
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals(IllegalArgumentException.class, exception.getClass());
        assertEquals("Номер билета состоит более, чем из 4 цифр!", exception.getMessage());
    }
    /**
     * Проверяет, что билет с минимальном номером создается без сбоев(в данном случае 0)
     */
    @Test
    public void minTicketNumber() {
        // when
        MealTicket ticket = new SmallTicket(0);
        // then
        assertNotNull(ticket);
    }
    /**
     * Проверяет, что билет с максимальным номером создается без сбоев(в данном случае 999999)
     */
    @Test
    public void maxTicketNumber() {
        // when
        MealTicket ticket = new SmallTicket(9999);
        // then
        assertNotNull(ticket);
    }
    /**
     * Проверяет, что билет счастливый проверяется правильно
     */
    @Test
    public void ticketIsLucky() {
        // when
        MealTicket luckyTicket = new SmallTicket(3250);
        // then
        assertTrue(luckyTicket.isMealTicket());
    }
    /**
     * Проверяет, что билет несчастливый проверяется правильно
     */
    @Test
    public void ticketIsNotLucky() {
        // when
        MealTicket ticket = new SmallTicket(3251);
        // then
        assertFalse(ticket.isMealTicket());
    }
    /**
     * Проверяет, что билет четный и счастливый проверяется правильно
     */
    @Test
    public void ticketIsLuckyAndIsEven() {
        // when
        MealTicket luckyEvenTicket = new SmallTicket(3252);
        // then
        assertTrue(luckyEvenTicket.isMealTicket() && luckyEvenTicket.isEven());
    }
    /**
     * Проверяет, что билет нечетный и счастливый проверяется правильно
     */
    @Test
    public void ticketIsLuckyAndIsNotEven() {
        // when
        MealTicket luckyNotEvenTicket = new SmallTicket(3351);
        // then
        assertFalse(luckyNotEvenTicket.isMealTicket() && luckyNotEvenTicket.isEven());
    }
}