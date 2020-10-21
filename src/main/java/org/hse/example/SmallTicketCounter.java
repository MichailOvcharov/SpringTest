package org.hse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

@Service("smallTicketCounter")
public class SmallTicketCounter implements Supplier<Long> {

    private final Iterator<MealTicket> ticketIterator;

    @Autowired
    public SmallTicketCounter(
            @Qualifier(value = "smallTicketsGenerator")
            final Iterator<MealTicket> ticketIterator) {
        this.ticketIterator = ticketIterator;
    }

    @Override
    public Long get() {
        Iterable<MealTicket> tickets = () -> ticketIterator;
        return  StreamSupport
                .stream(tickets.spliterator(), false)
                .filter(MealTicket::isMealTicket)
                .peek(System.out::println)
                .count();
    }
}
