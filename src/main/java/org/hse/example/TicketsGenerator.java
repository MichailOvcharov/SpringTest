package org.hse.example;

import org.hse.example.builders.MealTicketBuilder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Генерирует все возможные билеты, реализует {@link java.util.Iterator}
 */
@Service("ticketsGenerator")
// @Primary
@Scope("prototype")
public class TicketsGenerator implements Iterator<MealTicket> , ApplicationContextAware {
    //todo реализовать генератор для билетов из 4-х цифр
    private long current = 0;
    private ApplicationContext applicationContext;

    /**
     * @return true, если остались билеты в текущей последовательности
     */
    @Override
    public boolean hasNext() {
        return current < 1E6;
    }

    /**
     * @return следующий билет
     */
    @Override
    public MealTicket next() {

        MealTicketBuilder ticketBilder = applicationContext.getBean("ticketBuilder", MealTicketBuilder.class);
        //  MealTicket nextTicket = new Ticket(current); // todo
        MealTicket nextTicket = ticketBilder.ticket(current).build(); // todo
        current++;
        return nextTicket;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
