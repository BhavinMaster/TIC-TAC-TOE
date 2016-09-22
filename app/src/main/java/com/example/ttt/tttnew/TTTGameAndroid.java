package com.example.ttt.tttnew;

/**
 * Created by BhavinM on 08-03-2016.
 */
public class TTTGameAndroid extends TTTGame {
    private MainActivity ma;
    TTTGameAndroid(Object obj) {
        ma = (MainActivity)obj;
    }

    public void showBoard(){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char ch = getCell(row, col);
                if (ch == ' ')
                    ma.pics[row][col].setImageResource(R.drawable.blank40);
                if (ch == 'X')
                    ma.pics[row][col].setImageResource(R.drawable.cross40);
                if (ch == '0')
                    ma.pics[row][col].setImageResource(R.drawable.zero40);

            }
        }
    }
}

