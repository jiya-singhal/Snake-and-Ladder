package com.game.dice;

import java.util.Random;

public class StandardDice implements Dice {
    private final int sides;
    private final Random random;

    public StandardDice(int sides) {
        this.sides = sides;
        this.random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
