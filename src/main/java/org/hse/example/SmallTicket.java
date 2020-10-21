package org.hse.example;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Билет из 4-я цифр
 */

public class SmallTicket implements MealTicket {
    private int[] ticket;
    /**
     * @param ticket номер билета в виде целого числа
     */
    public SmallTicket(long ticket) {
        if (ticket < 0)  {
            throw  new IllegalArgumentException("Попытка создать билет с отрицательным номером!");
        }
        if (ticket >= 10000) {
            throw  new IllegalArgumentException("Номер билета состоит более, чем из 4 цифр!");
        }

        this.ticket = new int[]{0, 0, 0, 0};
        int j = 3;
        while (ticket > 0 && j >= 0) {
            this.ticket[j] = (int) ticket % 10;
            ticket = ticket / 10;
            j--;
        }
    }

    @Override
    public boolean isMealTicket() {
        int firstSum = ticket[0] + ticket[1];
        int lastSum = ticket[2] + ticket[3];
        return firstSum == lastSum;
    }

    @Override
    public boolean isEven() {
        return (ticket[3]%2 == 0);
    }

    @Override
    public boolean isNotEven() {
        return (ticket[3]%2 != 0);
    }
    @Override
    public boolean isDevideByThree() {
        return ((ticket[0]*1000 + ticket[1]*100 + ticket[2] *10+ ticket[3]) % 3 == 0);
    }
    @Override
    public String toString() {
        return "SmallTicket{" + Arrays.toString(ticket) + "}";
    }
}
