package org.hse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Сервис, выполняющий подсчет счастливых билетов
**/
// @Service("mealTicketCounter")
// @Primary
public class MealTicketCounter implements Supplier<Long> {

    private final Iterator<MealTicket> ticketIterator;

    // @Autowired
    public MealTicketCounter(
            // @Qualifier(value = "ticketsGenerator")
            final Iterator<MealTicket> ticketIterator) {
        this.ticketIterator = ticketIterator;
    }

    @Override
    public Long get() {
       Iterable<MealTicket> tickets = () -> ticketIterator;
       return  StreamSupport
                .stream(tickets.spliterator(), false)
                .filter(MealTicket::isMealTicket)
                //.peek(System.out::println)
                .count();
    }
}
