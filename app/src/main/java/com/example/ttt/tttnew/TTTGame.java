package com.example.ttt.tttnew;

/**
 * Created by BhavinM on 08-03-2016.
 */
public abstract class TTTGame {
    private char board[][] =
            {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};
    public char getCell(int r, int c) {return board[r][c];}

    private int numOfTurns;
    public int howManyTurns() {return numOfTurns;}
    public boolean boardFull() {return (numOfTurns == 9);}
    public boolean playerWon(int plNum) {
        int rw, cl;
        switch (plNum) {
            case 1:
                for (rw = 0; rw <= 2; rw++)
                    if (isRowFilledWithChar(rw, 'X')) return true;
                for (cl = 0; cl <= 2; cl++)
                    if (isColFilledWithChar(cl, 'X')) return true;
                if (isDiagsFilledWithChar('X')) return true;
                return false;
            case 2:
                for (rw = 0; rw <= 2; rw++)
                    if (isRowFilledWithChar(rw, '0')) return true;
                for (cl = 0; cl <= 2; cl++)
                    if (isColFilledWithChar(cl, '0')) return true;
                if (isDiagsFilledWithChar('0')) return true;
                return false;
        }
        return false;
    }

    private boolean isRowFilledWithChar(int r, char ch) {
        if(board[r][0] == ch && board[r][1] == ch && board[r][2] == ch) {
            return true;
        }
        return false;
    }
    private boolean isColFilledWithChar(int c, char ch) {
        if(board[0][c] == ch && board[1][c] == ch && board[2][c] == ch) {
            return true;
        }
        return false;
    }
    private boolean isDiagsFilledWithChar(char ch) {
        if(board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) {
            return true;
        }
        if(board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) {
            return true;
        }
        return false;
    }
    public boolean makeTurn(int rowNum, int colNum) {
        if (rowNum < 0 || rowNum > 2 || colNum < 0 || colNum > 2)
            return false;
        if (board[rowNum][colNum] != ' ')
            return false;
        if (numOfTurns % 2 == 0) {
            board[rowNum][colNum] = 'X';
            numOfTurns++;
            return true;
        }
        if (numOfTurns % 2 != 0) {
            board[rowNum][colNum] = '0';
            numOfTurns++;
            return true;
        }
        return true;
    }
    public void reset(){
        for (int r = 0; r <= 2; r++)
            for (int c = 0; c <= 2; c++)
                board[r][c] = ' ';
        numOfTurns = 0;
    }
    public abstract void showBoard();
}
