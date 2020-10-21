package org.hse.example;

/**
 * Предоставляет методя для работы со счастливыми билетами
 */
public interface MealTicket {
    /**
     * @return true, если билет счастливый
     */
    boolean isMealTicket();

    boolean isEven();

    boolean isNotEven();

    boolean isDevideByThree();
}
