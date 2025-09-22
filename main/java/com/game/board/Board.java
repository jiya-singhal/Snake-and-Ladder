package com.game.board;

import java.util.*;

public class Board {
    private int size;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board(int size, int numSnakes, int numLadders) {
        this.size = size * size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        generateSnakes(numSnakes);
        generateLadders(numLadders);
    }

    private void generateSnakes(int count) {
        Random rand = new Random();
        while (snakes.size() < count) {
            int head = rand.nextInt(size - 1) + 2;
            int tail = rand.nextInt(head - 1) + 1;
            if (!snakes.containsKey(head) && !ladders.containsKey(head) && head != size) {
                snakes.put(head, tail);
            }
        }
    }

    private void generateLadders(int count) {
        Random rand = new Random();
        while (ladders.size() < count) {
            int start = rand.nextInt(size - 1) + 1;
            int end = start + rand.nextInt(size - start) + 1;
            if (end <= size && !ladders.containsKey(start) && !snakes.containsKey(start) && start != 1) {
                ladders.put(start, end);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getNextPosition(int position) {
        if (snakes.containsKey(position)) {
            return snakes.get(position);
        }
        if (ladders.containsKey(position)) {
            return ladders.get(position);
        }
        return position;
    }
}
