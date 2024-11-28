package com.ss.cardsystem.models;

import java.util.Objects;

public class Card {
    private final Integer id;
    private int balance;

    public Card(Integer id, int initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public int balance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Integer id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
