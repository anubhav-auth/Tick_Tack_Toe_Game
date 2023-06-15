package com.example.tick_tack_toegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean isdraw;
    String winner;
    Boolean gameactive = true;
    // o = 1
    //x = 2
    int activeplayer = 1;
//    game states
//    0 = null
//    1 = O
//    2 = X
    int [] gamestate = {0,0,0,0,0,0,0,0,0};
    int [][] winningpositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    public void playertap(View a) {
        ImageView img = (ImageView) a;
        TextView z = findViewById(R.id.textView);
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gamereset(a);
        }
        if (gamestate[tappedimage] == 0 && gameactive) {
            gamestate[tappedimage] = activeplayer;
            img.setTranslationY(-1000f);
            z.setText("O's turn");
            if (activeplayer == 1) {
                activeplayer = 2;
                img.setImageResource(R.drawable.o);
                z.setText("X's turn");
            } else {
                activeplayer = 1;
                img.setImageResource(R.drawable.x);
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        // check for draw
        isdraw = true;
        for (int i = 0; i < gamestate.length ; i++) {
            if (gamestate[i] == 0){
                isdraw = false;
                break;
            }
        }

        // check to see im someone won or its draw
        if (isdraw){
            winner = "IT'S A DRAW";
            ((ImageView) findViewById(R.id.imageView1)).setClickable(false);
            ((ImageView) findViewById(R.id.imageView2)).setClickable(false);
            ((ImageView) findViewById(R.id.imageView3)).setClickable(false);
            ((ImageView) findViewById(R.id.imageView4)).setClickable(false);
            ((ImageView) findViewById(R.id.imageView5)).setClickable(false);
            ((ImageView) findViewById(R.id.imageView6)).setClickable(false);
            ((ImageView) findViewById(R.id.imageView7)).setClickable(false);
            ((ImageView) findViewById(R.id.imageView8)).setClickable(false);
            ((ImageView) findViewById(R.id.imageView9)).setClickable(false);
            LinearLayout ll = findViewById(R.id.ver);
            ImageView iv = findViewById(R.id.imageView10);
            TextView iv2 = findViewById(R.id.textView);
            Button resetButton = findViewById(R.id.button);
            TextView tv = findViewById(R.id.textView2);
            iv2.setVisibility(View.INVISIBLE);
            tv.setText(winner);
            Handler hd = new Handler();
            hd.postDelayed(new Runnable() {
                @Override
                public void run() {
                    iv.setVisibility(View.INVISIBLE);
                    ll.setVisibility(View.INVISIBLE);
                    resetButton.setVisibility(View.VISIBLE);
                    tv.setVisibility(View.VISIBLE);
                }
            }, 1500);
        }else {
            for (int[] winningposition : winningpositions) {
                if (gamestate[winningposition[0]] == gamestate[winningposition[1]] && gamestate[winningposition[1]] == gamestate[winningposition[2]] && gamestate[winningposition[0]] != 0) {
                    gameactive = false;
                    if (gamestate[winningposition[0]] == 1) {
                        winner = "O WON !!!";
                    } else {
                        winner = "X WON !!!";
                    }
                    ((ImageView) findViewById(R.id.imageView1)).setClickable(false);
                    ((ImageView) findViewById(R.id.imageView2)).setClickable(false);
                    ((ImageView) findViewById(R.id.imageView3)).setClickable(false);
                    ((ImageView) findViewById(R.id.imageView4)).setClickable(false);
                    ((ImageView) findViewById(R.id.imageView5)).setClickable(false);
                    ((ImageView) findViewById(R.id.imageView6)).setClickable(false);
                    ((ImageView) findViewById(R.id.imageView7)).setClickable(false);
                    ((ImageView) findViewById(R.id.imageView8)).setClickable(false);
                    ((ImageView) findViewById(R.id.imageView9)).setClickable(false);
                    LinearLayout ll = findViewById(R.id.ver);
                    ImageView iv = findViewById(R.id.imageView10);
                    TextView iv2 = findViewById(R.id.textView);
                    Button resetButton = findViewById(R.id.button);
                    TextView tv = findViewById(R.id.textView2);
                    iv2.setVisibility(View.INVISIBLE);
                    tv.setText(winner);
                    Handler hd = new Handler();
                    hd.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            iv.setVisibility(View.INVISIBLE);
                            ll.setVisibility(View.INVISIBLE);
                            resetButton.setVisibility(View.VISIBLE);
                            tv.setVisibility(View.VISIBLE);
                        }
                    }, 1500);

                }
            }
        }

    }

    public void gamereset(View view) {
        gameactive = true;
        for (int i = 0; i < gamestate.length; i++ ) {
            gamestate[i] = 0;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView2)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView3)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView4)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView5)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView6)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView7)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView8)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView9)).setClickable(true);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button resetButton = findViewById(R.id.button);
        TextView tv = findViewById(R.id.textView2);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButton.setVisibility(View.INVISIBLE);
                tv.setVisibility(View.INVISIBLE);
                gamereset(v);
                LinearLayout ll = findViewById(R.id.ver);
                ImageView iv = findViewById(R.id.imageView10);
                TextView iv2 = findViewById(R.id.textView);
                iv.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.VISIBLE);
                ll.setVisibility(View.VISIBLE);
            }
        });
    }


}