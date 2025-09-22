package com.game.engine;

import com.game.board.Board;
import com.game.dice.Dice;
import com.game.player.Player;

import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;

    public Game(Board board, List<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
    }

    public void play() {
        boolean finished = false;
        while (!finished) {
            for (Player player : players) {
                if (player.hasWon()) continue;

                int roll = dice.roll();
                int nextPosition = player.getPosition() + roll;

                if (nextPosition <= board.getSize()) {
                    player.setPosition(nextPosition);
                    player.setPosition(board.getNextPosition(player.getPosition()));
                }

                System.out.println(player.getName() + " rolled " + roll + " and moved to " + player.getPosition());

                if (player.getPosition() == board.getSize()) {
                    player.setWon(true);
                    System.out.println(player.getName() + " has won the game!");
                }
            }

            long activePlayers = players.stream().filter(p -> !p.hasWon()).count();
            if (activePlayers < 2) {
                finished = true;
            }
        }
    }
}
