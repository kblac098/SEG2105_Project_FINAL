package com.example.localloop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.localloop.R;
import com.example.localloop.model.DatabaseConnection;
import com.example.localloop.model.Participant;

public class WelcomeParticipant extends AppCompatActivity {

    private static Participant user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome_participant);

        // Set window insets to maintain future layout compatibility
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.returnToLogin), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        user = (Participant)DatabaseInstance.get().getUser();
        String username = user.getUsername();

        // Set welcome message
        TextView welcomeMessage = findViewById(R.id.welcome_message3);
        String message = "Welcome " + user.getUsername();
        welcomeMessage.setText(message);
    }

    public void ReturnToLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}