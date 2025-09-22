package com.game.player;

public class Player {
    private final String name;
    private int position;
    private boolean hasWon;

    public Player(String name) {
        this.name = name;
        this.position = 0;
        this.hasWon = false;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean hasWon() {
        return hasWon;
    }

    public void setWon(boolean won) {
        this.hasWon = won;
    }
}
