package com.shuffle.core;

import com.shuffle.cards.Card;
import com.shuffle.exceptions.EmptyDeckException;
import com.shuffle.exceptions.OutOfDeckException;

import java.util.List;

public interface Mixer {

    List<Card> mix(List<Card> card) throws OutOfDeckException, EmptyDeckException;

}
