package com.example.marco.tris;

import android.content.Intent;
import android.view.View;
import java.util.Random;

public class Tris {

    char[][] btn;
    boolean victory;
    final int ROWS=3;
    final int COLS=3;

    public void set(View view, char sign){
        switch (view.getId()) {
            case R.id.button0:
                btn[0][0] = sign;
                break;
            case R.id.button1:
                btn[0][1] = sign;
                break;
            case R.id.button2:
                btn[0][2] = sign;
                break;
            case R.id.button3:
                btn[1][0] = sign;
                break;
            case R.id.button4:
                btn[1][1] = sign;
                break;
            case R.id.button5:
                btn[1][2] = sign;
                break;
            case R.id.button6:
                btn[2][0] = sign;
                break;
            case R.id.button7:
                btn[2][1] = sign;
                break;
            case R.id.button8:
                btn[2][2] = sign;
                break;
        }

    }

    public boolean checkVictory(Intent i){

        victory=false;

        //check horizontal victory
        if(btn[0][0]==btn[0][1] && btn[0][0]==btn[0][2] && btn[0][0]!=' ') {
            i.putExtra("victory", btn[0][0]);
            victory=true;
        }
        if(btn[1][0]==btn[1][1] && btn[1][0]==btn[1][2] && btn[1][0]!=' ') {
            i.putExtra("victory", btn[1][0]);
            victory=true;
        }
        if(btn[2][0]==btn[2][1] && btn[2][0]==btn[2][2] && btn[2][0]!=' ') {
            i.putExtra("victory", btn[2][0]);
            victory=true;
        }

        //check vertical victory
        if(btn[0][0]==btn[1][0] && btn[0][0]==btn[2][0] && btn[0][0]!=' ') {
            i.putExtra("victory", btn[0][0]);
            victory=true;
        }
        if(btn[0][1]==btn[1][1] && btn[0][1]==btn[2][1] && btn[0][1]!=' ') {
            i.putExtra("victory", btn[0][1]);
            victory=true;
        }
        if(btn[0][2]==btn[1][2] && btn[0][2]==btn[2][2] && btn[0][2]!=' ') {
            i.putExtra("victory",btn[0][2]);
            victory=true;
        }

        //check diagonal victory
        if(btn[0][0]==btn[1][1] && btn[0][0]==btn[2][2] && btn[0][0]!=' ') {
            i.putExtra("victory",btn[0][0]);
            victory=true;
        }
        if(btn[0][2]==btn[1][1] && btn[0][2]==btn[2][0] && btn[0][2]!=' ') {
            i.putExtra("victory",btn[0][2]);
            victory=true;
        }

        return victory;

    }

    public int moveComputerRandom() {
        boolean flag=false;
        int freeCells = 0, number=0;
        for (char[] cells : btn)
            for (char c : cells)
                if (c == ' ')
                    freeCells++;
        if (freeCells > 0) {
            while (flag == false) {
                int cellNumber = new Random().nextInt(freeCells) + 1;
                int count = 0;
                for (int i = 0; i < ROWS; i++)
                    for (int j = 0; j < COLS; j++) {
                        if (btn[i][j] == ' ')
                            count++;
                        if (count == cellNumber && btn[i][j]==' ') {
                            flag=true;
                            btn[i][j] = 'O';
                            number= i * 3 + j;
                            return number;
                        }
                    }
            }
        }
        return number;
    }

    public void draw(Intent i){
        i.putExtra("victory",'n');
    }

    public void restart(){
        btn= new char[][] { {' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '} };
        victory=false;
    }
}
