package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerSetup extends AppCompatActivity {

    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);

        Button submitName = findViewById(R.id.submitName);
        submitName.setOnClickListener(v -> submitButton());
    }

    public void submitButton() {
        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();

        if( player1Name.isEmpty() || player2Name.isEmpty() ) {
            Toast.makeText(this, "Input Two Valid Names", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, GameDisplay.class);
            intent.putExtra("PLAYER_NAMES", new String[]{player1Name, player2Name});
            startActivity(intent);
        }
    }
}