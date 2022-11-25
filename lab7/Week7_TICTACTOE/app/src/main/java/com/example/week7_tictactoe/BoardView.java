package com.example.week7_tictactoe;

public interface BoardView {
    char PLAYER_1_SYMBOL = 'X';
    char PLAYER_2_SYMBOL = 'O';

    byte DRAW = 0;
    byte PLAYER_1_WINNER = 1;
    byte PLAYER_2_WINNER = 0;

    void newGame();

    void putSymbol(char symbol, byte row, byte col);

    void gameEnded(byte winner);

    void invalidPlay(byte row, byte col);

}