package com.example.ttt.tttnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView        tvMessage;
    public ImageView        iv00, iv01, iv02,
            iv10, iv11, iv12,
            iv20, iv21, iv22;
    public ImageView        pics[][];
    private Button          btReset;
    private TTTGameAndroid  game;
    private int row,col;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMessage = (TextView)findViewById(R.id.tv_message);
        pics = new ImageView[3][3];
        pics[0][0] = iv00 = (ImageView)findViewById(R.id.iv_00);
        pics[0][1] = iv01 = (ImageView)findViewById(R.id.iv_01);
        pics[0][2] = iv02 = (ImageView)findViewById(R.id.iv_02);
        pics[1][0] = iv10 = (ImageView)findViewById(R.id.iv_10);
        pics[1][1] = iv11 = (ImageView)findViewById(R.id.iv_11);
        pics[1][2] = iv12 = (ImageView)findViewById(R.id.iv_12);
        pics[2][0] = iv20 = (ImageView)findViewById(R.id.iv_20);
        pics[2][1] = iv21 = (ImageView)findViewById(R.id.iv_21);
        pics[2][2] = iv22 = (ImageView)findViewById(R.id.iv_22);

        btReset = (Button)findViewById(R.id.bt_reset);
        iv00.setOnClickListener(this);
        iv01.setOnClickListener(this);
        iv02.setOnClickListener(this);
        iv10.setOnClickListener(this);
        iv11.setOnClickListener(this);
        iv12.setOnClickListener(this);
        iv20.setOnClickListener(this);
        iv21.setOnClickListener(this);
        iv22.setOnClickListener(this);
        btReset.setOnClickListener(this);

        game = new TTTGameAndroid(this);
        game.showBoard();
    }

    @Override
    public void onClick(View v) {

        if (v == btReset)
        {
            game.reset();
            game.showBoard();
            tvMessage.setText("Play Game");
            return;
        }
        if(game.boardFull())return;

        if(game.playerWon(1) || game.playerWon(2)) return;

        for(int r = 0 ; r <= 2 ; r++)
            for(int c = 0 ;c <=2 ; c++)
                if(pics[r][c] == v)
                {
                    row = r;
                    col = c;
                }
        game.makeTurn(row, col);
        game.showBoard();
        if(game.playerWon(1)) {
            tvMessage.setText("First Player won");

            Toast.makeText(MainActivity.this, "First PlayerWon", Toast.LENGTH_LONG).show();
        }
        if(game.playerWon(2)) {
            tvMessage.setText("Second Player won");
            Toast.makeText(MainActivity.this, "Second PlayerWon", Toast.LENGTH_LONG).show();
        }
            if(game.boardFull()) {
                tvMessage.setText("It's a Draw");
                Toast.makeText(MainActivity.this, "Draw", Toast.LENGTH_LONG).show();
            }


            }
}
