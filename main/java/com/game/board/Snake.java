package com.game.board;

public class Snake {
    private final int head;
    private final int tail;

    public Snake(int head, int tail) {
        if (tail >= head) throw new IllegalArgumentException("Tail must be below head");
        this.head = head;
        this.tail = tail;
    }

    public int getHead() { return head; }
    public int getTail() { return tail; }
}
