package org.hse.example.builders;

import org.hse.example.MealTicket;
import org.hse.example.Ticket;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("ticketBuilder")
@Scope("prototype")
public class TicketBuilder implements MealTicketBuilder {

    private Long ticket;
    //  private boolean used = false;
    public boolean used = false;
    @PostConstruct
    void init() {
        used = false;
    }

    @Override
    public MealTicket build() {
        if(used) {
            throw new IllegalArgumentException("Данный строитель использовался ранее!");
        }
        used = true;
        return new Ticket(ticket);
    }

    @Override
    public MealTicketBuilder ticket(long ticket) {
        this.ticket = ticket;
        return this;
    }
}
