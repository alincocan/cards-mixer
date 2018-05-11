package com.shuffle.core;

import com.shuffle.core.MixerImpl;
import com.shuffle.core.SimpleMixerImpl;
import com.shuffle.deck.Deck;
import com.shuffle.deck.DeckBuilderImpl;
import com.shuffle.exceptions.EmptyDeckException;
import com.shuffle.exceptions.OutOfDeckException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What kind of shuffle do you want to use ? ");

        System.out.println("1. An algorithm which tries to simulate a real life cards mixing");
        System.out.println("2. A simple algorithm which generate new position for each element");

        int input ;
        Deck deck = null;

        try {
            input = sc.nextInt();
            if (input == 1) {
                deck = new Deck(new DeckBuilderImpl(), new MixerImpl());
            } else if (input == 2) {
                deck = new Deck(new DeckBuilderImpl(), new SimpleMixerImpl());
            } else {
                return;
            }

            System.out.println("Your cards: ");

            deck.print();

            while (true) {
                System.out.println("Do you want to shuffle the deck ? ");
                System.out.println("1. Yes");
                System.out.println("2. No");

                input = sc.nextInt();
                if (input != 1) {
                    break;
                }
                deck.shuffle();

                System.out.println("Your cards: ");

                deck.print();
            }

        }
        catch (OutOfDeckException odEx) {
            System.out.println(odEx.getMessage());
        }
        catch (EmptyDeckException edEx) {
            System.out.println(edEx.getMessage());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
