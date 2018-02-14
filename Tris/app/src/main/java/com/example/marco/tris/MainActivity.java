package com.example.marco.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button first=findViewById(R.id.first);

        first.setOnClickListener((View view) -> {
            Intent i = new Intent(this, HumanVsComputer.class);
            startActivity(i);
            finish();
        });

        Button second = findViewById(R.id.second);

        second.setOnClickListener((View view) -> {
            Intent i = new Intent(this, PlayerVsPlayer.class);
            startActivity(i);
            finish();
        });

    }
}
