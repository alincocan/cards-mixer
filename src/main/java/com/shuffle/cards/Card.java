package com.shuffle.cards;

import java.util.Objects;

public class Card {

    private final Face face;
    private final Type type;

    public Card(final Type type, final Face face) {
        this.face = face;
        this.type = type;
    }

    public Face getFace() {
        return face;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getFace() == card.getFace() &&
                getType() == card.getType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFace(), getType());
    }

    @Override
    public String toString() {
        return "[" +
                 type +
                ", " + face +
                "]";
    }
}
