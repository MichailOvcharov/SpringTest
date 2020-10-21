package org.hse.example.builders;

import org.hse.example.MealTicket;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmallTicketBuilderTest {
    /**
     * Проверяет, что build() работает как конструктор
     */
//    @Test
//    public void buildWorksSameAsConstructor () {
//        Long ticketNumber = 100500L;
//        MealTicketBuilder builder = new TicketBuilder();
//        MealTicketBuilder builderTicket = builder.ticket(ticketNumber);
//        assertEquals(new Ticket(100500L), builderTicket.build());
//    }
    /**
     * Проверяет, что строитель использовался ранее
     */
    @Test
    public void builderNotUsesTwice () {
        MealTicketBuilder builder = new SmallTicketBuilder();
        MealTicket ticket = builder.ticket(1005).build();
        Exception exception = null;
        try {
            builder.build();
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals(IllegalArgumentException.class, exception.getClass());
        assertEquals("Данный строитель использовался ранее!", exception.getMessage());
    }

    /**
     *  Проверяет, что метод ticket возвращает MealTicketBuilder не null
     */
    @Test
    public void smallTicketNormalWork() {
        // given
        long ticketNumber = 10;
        // when
        MealTicketBuilder builder = new SmallTicketBuilder();
        MealTicketBuilder builderTicket = builder.ticket(ticketNumber);
        // then
        assertNotNull(builderTicket);
    }

    /**
     *  Проверяет, что метод build возвращает билет при корректных данных
     */
    @Test
    public void smallTicketBuildNormalWork() {
        // given
        long ticketNumber = 10;
        // when
        MealTicketBuilder builder = new SmallTicketBuilder();
        MealTicket ticket = builder.ticket(ticketNumber).build();
        // then
        assertNotNull(ticket);
    }
    /**
     *  Проверяет, как будет отрабатывать build с отрицательным числом в ticket
     */
    @Test
    public void smallTicketBuilderWithNegativeTicket() {
        // given
        long ticketNumber = -10;
        // when
        Exception exception = null;
        try {
            MealTicketBuilder builder = new SmallTicketBuilder();
            MealTicket ticket = builder.ticket(ticketNumber).build();
        } catch (Exception e)  {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals(IllegalArgumentException.class, exception.getClass());
        assertEquals("Попытка создать билет с отрицательным номером!", exception.getMessage());
    }
    /**
     * Проверяет, как будет отрабатывать build, если подали на вход более чем четырехзначное число
     */
    @Test
    public void smallTicketBuilderWithMoreThenFourDigit() {
        // given
        long ticketNumber = 10000;
        // when
        Exception exception = null;
        try {
            MealTicketBuilder builder = new SmallTicketBuilder();
            MealTicket ticket = builder.ticket(ticketNumber).build();
        } catch (Exception e)  {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals(IllegalArgumentException.class, exception.getClass());
        assertEquals("Номер билета состоит более, чем из 4 цифр!", exception.getMessage());
    }
    /**
     * Проверяет, что билет с минимальном номером создается build без сбоев (в данном случае 0)
     */
    @Test
    public void smallTicketBuilderWithMinTicketNumber() {
        // given
        long ticketNumber = 0;
        // when
        MealTicketBuilder builder = new SmallTicketBuilder();
        MealTicket ticket = builder.ticket(ticketNumber).build();
        // then
        assertNotNull(ticket);
    }
    /**
     * Проверяет, что билет с максимальным номером создается build без сбоев (в данном случае 9999)
     */
    @Test
    public void buildWithMaxTicketNumber() {
        // given
        long ticketNumber = 9999;
        // when
        MealTicketBuilder builder = new SmallTicketBuilder();
        MealTicket ticket = builder.ticket(ticketNumber).build();
        // then
        assertNotNull(ticket);
    }
}