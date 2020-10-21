package org.hse.example.builders;


import org.hse.example.MealTicket;

public interface MealTicketBuilder {

    MealTicket build();

    MealTicketBuilder ticket(long ticket);

}
