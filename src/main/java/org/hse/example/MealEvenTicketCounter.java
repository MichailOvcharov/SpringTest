package org.hse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

@Service("mealEvenTicketCounter")
@Primary
//@Scope("prototype")
public class MealEvenTicketCounter implements Supplier<Long> {
    private final Iterator<MealTicket> ticketIterator;

    @Autowired
    public MealEvenTicketCounter(
            @Qualifier(value = "ticketsGenerator")
            final Iterator<MealTicket> ticketIterator) {
        this.ticketIterator = ticketIterator;
    }

    @Override
    public Long get() {
        Iterable<MealTicket> tickets = () -> ticketIterator;
        return  StreamSupport
                .stream(tickets.spliterator(), false)
                .filter(MealTicket::isMealTicket)
                .filter(MealTicket::isEven)
                //.peek(System.out::println)
                .count();
    }
}
