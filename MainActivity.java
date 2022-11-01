package com.example.newtic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
@SuppressLint("MissingInflatedId")
public class MainActivity extends AppCompatActivity {
    int Xwins=0;
    int Owins=0;
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean activeGame = true;
    String TUR;

    public void taptap(View view) {
        if (!activeGame) {
            resetGame(view);
        }
        ImageView img = (ImageView) view;
        int tappedImg = Integer.parseInt(img.getTag().toString());
        if (gameState[tappedImg] == 2) {
            gameState[tappedImg] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.xi);
                activePlayer = 1;
                TUR = "O's turn";
            } else {
                img.setImageResource(R.drawable.oi);
                activePlayer = 0;
                TUR = "X's turn";

            }
            TextView textView = findViewById(R.id.status);
            textView.setText(TUR);
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //wiiner condtion is matched
        for (int[] winnerposition : winningPositions) {
            if (gameState[winnerposition[0]] == gameState[winnerposition[1]] && gameState[winnerposition[1]] == gameState[winnerposition[2]]
                    && gameState[winnerposition[0]] != 2) {
                activeGame = false;
                String winner;
                if (gameState[winnerposition[0]] == 1) {
                    //x wins

                    winner = "O'won";
                    Owins++;
                    TextView textView1 = findViewById(R.id.owins);
                    textView1.setText("Owins"+Owins);
                } else {
                    //o wins
                    winner = "X'won";
                    Xwins++;
                    TextView textView1 = findViewById(R.id.xwins);
                    textView1.setText("Xwins:"+Xwins);

                }
                TextView textView = findViewById(R.id.status);
                textView.setText(winner);




            }


        }
    }

    public void resetGame (View view){
        activeGame = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }




}
