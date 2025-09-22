package com.game;

import com.game.board.Board;
import com.game.dice.StandardDice;
import com.game.engine.Game;
import com.game.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = readInt(scanner, "Enter board size n (board is n x n): ", 2, 100);
        int numPlayers = readInt(scanner, "Enter number of players (>= 2): ", 2, 50);

        List<Player> players = new ArrayList<>();
        scanner.nextLine(); // consume newline
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                name = "Player" + i;
            }
            players.add(new Player(name));
        }

        Board board = new Board(n, n, n);

        StandardDice dice = new StandardDice(6);
        Game game = new Game(board, players, dice);
        game.play();
    }

    private static int readInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                int v = Integer.parseInt(line.trim());
                if (v < min || v > max) {
                    System.out.printf("Please enter a number between %d and %d%n", min, max);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }
}
