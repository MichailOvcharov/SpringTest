package org.hse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

public class mealEvenDevideByThreeTicketCounter { //implements Supplier<Long> {
//    private final Iterator<MealTicket> ticketIterator;
//
//    @Autowired
//    public MealEvenTicketCounter(
//            @Qualifier(value = "ticketsGenerator")
//            final Iterator<MealTicket> ticketIterator) {
//        this.ticketIterator = ticketIterator;
//    }
//
//    @Override
//    public Long get() {
//        Iterable<MealTicket> tickets = () -> ticketIterator;
//        return  StreamSupport
//                .stream(tickets.spliterator(), false)
//                .filter(MealTicket::isMealTicket)
//                .filter(MealTicket::isEven)
//                //.peek(System.out::println)
//                .count();
//    }
}
