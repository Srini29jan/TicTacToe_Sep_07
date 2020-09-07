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
        char winner = CHARACTER_NULL;

        if (isFirstRowFilledByPlayer(PLAYER_X.value)
                || isSecondRowFilledByPlayer(PLAYER_X.value)
                || isThirdRowFilledByPlayer(PLAYER_X.value)) {
            winner = PLAYER_X.value;
        }

        if (isFirstRowFilledByPlayer(PLAYER_O.value)
                || isSecondRowFilledByPlayer(PLAYER_O.value)
                || isThirdRowFilledByPlayer(PLAYER_O.value)){
            winner = PLAYER_O.value;
        }

        return winner;
    }

    private boolean isThirdRowFilledByPlayer(char player) {
        return getPlayerAt(POSITION_TWO, POSITION_ZERO) == player
                && getPlayerAt(POSITION_TWO, POSITION_ONE) == player
                && getPlayerAt(POSITION_TWO, POSITION_TWO) == player;
    }

    private boolean isSecondRowFilledByPlayer(char player) {
        return getPlayerAt(POSITION_ONE, POSITION_ZERO) == player
                && getPlayerAt(POSITION_ONE, POSITION_ONE) == player
                && getPlayerAt(POSITION_ONE, POSITION_TWO) == player;
    }

    private boolean isFirstRowFilledByPlayer(char player) {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == player
                && getPlayerAt(POSITION_ZERO, POSITION_ONE) == player
                && getPlayerAt(POSITION_ZERO, POSITION_TWO) == player;
    }

}
