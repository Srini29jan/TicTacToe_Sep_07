package com.tdd.kata;

import static com.tdd.kata.Player.PLAYER_O;
import static com.tdd.kata.Player.PLAYER_X;

public class Game {

    private static final int POSITION_ZERO = 0;
    private static final int POSITION_ONE = 1;
    private static final int POSITION_TWO = 2;
    private static final char CHARACTER_NULL = '\0';
    private char previousPlayer;
    private final Board board;

    public Game() {
        board = new Board();
    }

    public void playAt(int row, int column) {
        char currentPlayer = getCurrentPlayer();
        board.playAt(row, column, currentPlayer);
        setPreviousPlayer(currentPlayer);
    }

    private void setPreviousPlayer(char currentPlayer) {
        previousPlayer = currentPlayer;
    }

    private char getCurrentPlayer() {
        return previousPlayer == PLAYER_X.value ? PLAYER_O.value : PLAYER_X.value;
    }

    public char getPlayerAt(int row, int column) {
        return board.getPlayerAt(row, column);
    }

    public char getWinner() {
        if (isFirstRowFilledByPlayerX()) {
            return PLAYER_X.value;
        }

        if (isFirstRowFilledByPlayerO()) {
            return PLAYER_O.value;
        }

        return CHARACTER_NULL;
    }

    private boolean isFirstRowFilledByPlayerX() {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == PLAYER_X.value
                && getPlayerAt(POSITION_ZERO, POSITION_ONE) == PLAYER_X.value
                && getPlayerAt(POSITION_ZERO, POSITION_TWO) == PLAYER_X.value;
    }

    private boolean isFirstRowFilledByPlayerO() {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == PLAYER_O.value
                && getPlayerAt(POSITION_ZERO, POSITION_ONE) == PLAYER_O.value
                && getPlayerAt(POSITION_ZERO, POSITION_TWO) == PLAYER_O.value;
    }
}
