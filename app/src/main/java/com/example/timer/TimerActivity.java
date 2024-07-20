package com.example.timer;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.LinearInterpolator;

import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {
    private TimerView timerView;
    private Handler handler = new Handler();
    private int totalTime; // Total time in seconds
    private int elapsedTime = 0; // Elapsed time in seconds
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerView = findViewById(R.id.timerView);

        // Get the total time from the intent
        totalTime = getIntent().getIntExtra("TOTAL_TIME", 60); // Default to 60 seconds if not provided
        timerView.setTotalTime(totalTime);

        // Initialize MediaPlayer with the sound resource
        mediaPlayer = MediaPlayer.create(this, R.raw.race_start_beeps);

        startTimer();
    }

    private void startTimer() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                elapsedTime++;
                // Animate from the previous elapsed time to the current
                animateElapsedTime(elapsedTime - 1, elapsedTime);

                // Check if the timer is in the last 3 seconds
                if (totalTime - elapsedTime == 3) {
                    mediaPlayer.start();
                }

                if (elapsedTime < totalTime) {
                    handler.postDelayed(this, 1000);
                }
            }
        }, 1000);
    }

    private void animateElapsedTime(int from, int to) {
        // Create an ObjectAnimator to animate the transition from 'from' to 'to'
        ObjectAnimator animator = ObjectAnimator.ofFloat(timerView, "animatedElapsedTime", from, to);
        animator.setDuration(750); // Adjust the duration as needed (e.g., 1000 milliseconds for 1 second)
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release MediaPlayer resources when the activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
