package com.example.marco.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayerVsPlayer extends AppCompatActivity {

    int j=0;
    Intent i;
    Tris t=new Tris();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_vs_player);

        i = new Intent(this, ActivityTwo.class);
        t.restart();

    }


    public void clickListener(View view){

        Button clicked = (Button)view;
        char sign;

        if (j % 2 == 0) {
            clicked.setText("X");
            sign='X';
        } else {
            clicked.setText("O");
            sign='O';
        }

        j++;

        t.set(view, sign);


        if((j<9 || j==9) && t.checkVictory(i)) {
            startActivity(i);
            finish();
        }

        if(j==9 && !t.checkVictory(i)) {
            t.draw(i);
            startActivity(i);
            finish();
        }
    }
}
