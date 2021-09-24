package com.jnu.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button changeButton1 = findViewById(R.id.button_change_text);
        Button changeButton2 = findViewById(R.id.button_change_text2);

        changeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView hello = findViewById(R.id.hello_text);
                TextView world = findViewById(R.id.world_text);

                String worldText = (String) world.getText();
                String helloText = (String) hello.getText();

                hello.setText(worldText);
                world.setText(helloText);

                System.out.println("change1");
            }
        });



        changeButton2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        TextView hello = findViewById(R.id.hello_text);
        TextView world = findViewById(R.id.world_text);

        String worldText = (String) world.getText();
        String helloText = (String) hello.getText();

        hello.setText(worldText);
        world.setText(helloText);

        System.out.println("change2");
    }
}