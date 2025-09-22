package com.game.board;

public class Ladder {
    private final int start;
    private final int end;

    public Ladder(int start, int end) {
        if (end <= start) throw new IllegalArgumentException("End must be above start");
        this.start = start;
        this.end = end;
    }

    public int getStart() { return start; }
    public int getEnd() { return end; }
}
