package org.hse.example;

import java.util.Arrays;

/**
 * Класс для моделирования билета
 */
public class Ticket implements MealTicket {
    //todo реализовать класс для билета из 4-х цифр. Лучше интерфейс
    private int[] ticket;

    /**
     * @param ticket номер билета в виде целого числа
     */
    public Ticket(long ticket) {
        if (ticket < 0)  {
            throw  new IllegalArgumentException("Попытка создать билет с отрицательным номером!");
        }
        if (ticket >= 1000000) {
            throw  new IllegalArgumentException("Номер билета состоит более, чем из 6 цифр!");
        }

        this.ticket = new int[]{0, 0, 0, 0, 0, 0};
        int j = 5;
        while (ticket > 0 && j >= 0) {
            this.ticket[j] = (int) ticket % 10;
            ticket = ticket / 10;
            j--;
        }
    }

    /**
     * @return true, если билет счастливый
     */
    @Override
    public boolean isMealTicket() {
        int firstSum = ticket[0] + ticket[1] + ticket[2];
        int lastSum = ticket[3] + ticket[4] + ticket[5];

        return firstSum == lastSum;
    }

    @Override
    public boolean isEven() {
        return (ticket[5]%2 == 0);
    }

    @Override
    public boolean isNotEven() {
        return (ticket[5]%2 != 0);
    }

    @Override
    public boolean isDevideByThree() {
        return ((ticket[0]*100000 + ticket[1]*10000 + ticket[2] *1000+ ticket[3]*100 + ticket[4]*10 + ticket[5]) %3 == 0);
    }

    @Override
    public String toString() {
        return "Ticket{" + Arrays.toString(ticket) + "}";
    }
}
