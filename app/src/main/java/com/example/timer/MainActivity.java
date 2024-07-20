package com.example.timer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputTime;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTime = findViewById(R.id.inputTime);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String timeInput = inputTime.getText().toString();
                if (!timeInput.isEmpty()) {
                    int totalTime = Integer.parseInt(timeInput);
                    Intent intent = new Intent(MainActivity.this, TimerActivity.class);
                    intent.putExtra("TOTAL_TIME", totalTime);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a time", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
