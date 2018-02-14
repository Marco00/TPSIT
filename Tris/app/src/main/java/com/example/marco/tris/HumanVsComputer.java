package com.example.marco.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HumanVsComputer extends AppCompatActivity {

    int j=0;
    Intent i;
    Tris t=new Tris();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_vs_computer);

        i = new Intent(this,ActivityTwo.class);
        t.restart();

    }


    public void clickListener(View view){

        Button clicked = (Button)view;
        char sign;
        clicked.setText("X");
        sign='X';
        j++;
        t.set(view, sign);

        if(j<9) {
            String moved = "button" + String.valueOf(t.moveComputerRandom());
            Button pressed = findViewById(getResources().getIdentifier(moved, "id", getPackageName()));
            pressed.setText("O");
        }
        if(j!=9)
            j++;

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
