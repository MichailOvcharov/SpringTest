package org.hse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import java.util.Iterator;
import java.util.function.Supplier;

/**
 * Класс конфигурации
 */

@Configuration
@ComponentScan("org.hse.example")
public class AppConfig {

    /**
     * Длина билета
     */
    @Bean("ticketLength")
    public Integer getTicketLength() {
        return 4;
    }

    @Bean("mealTicketCounter")
    //@Primary
    @Scope("prototype")
    @Autowired
    // ticketsGenerator
    public Supplier<Long> getTicketCounter(@Qualifier(value = "ticketsGenerator")
                                               final Iterator<MealTicket> ticketIterator) {
        return new MealTicketCounter(ticketIterator);
    }

//    @Bean("mealEvenTicketCounter")
//    @Autowired
//    // ticketsGenerator
//    public Supplier<Long> getEvenTicketCounter(@Qualifier(value = "ticketsGenerator")
//                                           final Iterator<MealTicket> ticketIterator) {
//        return new MealEvenTicketCounter(ticketIterator);
//    }

//    @Bean("ticketBuilder")


}
