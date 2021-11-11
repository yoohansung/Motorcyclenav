package com.example.motorcycle_nav;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btnfrangment);

        button.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                NavFragment navFragment = new NavFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container,navFragment).commit();

            }
        });
    }
}