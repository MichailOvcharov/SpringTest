package org.hse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

@Service("mealNotEvenTicketCounter")
//@Scope("prototype")
public class MealNotEventTicketCounter implements Supplier<Long>  {

    private final Iterator<MealTicket> ticketIterator;

    @Autowired
    public MealNotEventTicketCounter(
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
                .filter(MealTicket::isNotEven)
                //.peek(System.out::println)
                .count();
    }

}
