package com.example.brightwave;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Pomodoro extends AppCompatActivity {

    TextView countdownTimerView;
    Button countdownButton;
    CountDownTimer timer; // Renamed variable to avoid conflict

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pomodoro);

        countdownTimerView = findViewById(R.id.countdown_timer);
        countdownButton = findViewById(R.id.countdown_button);

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });
    }

    private void startTimer() {
        if (timer != null) {
            timer.cancel(); // Cancel any existing timer before starting a new one
        }

        timer = new CountDownTimer(1500000, 1000) { // 10 seconds countdown
            @Override
            public void onTick(long millisUntilFinished) {
                long hours = (millisUntilFinished / 1000) / 3600;
                long minutes = (millisUntilFinished / 1000 % 3600) / 60;
                long seconds = (millisUntilFinished / 1000) % 60;
                String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
                countdownTimerView.setText(timeFormatted);
            }

            @Override
            public void onFinish() {
                countdownTimerView.setText("00:00:00");
                Toast.makeText(Pomodoro.this, "Time's up!", Toast.LENGTH_SHORT).show();

                MediaPlayer alarm = MediaPlayer.create(Pomodoro.this, R.raw.alarm);
                alarm.start();

                alarm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        alarm.release(); // Release MediaPlayer resources
                    }
                });
            }
        }.start();
    }
}
