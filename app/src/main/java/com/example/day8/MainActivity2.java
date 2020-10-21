package com.example.day8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {
           private TextView txtUsername;
           private Button btnLogout;
           private String userName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        txtUsername = findViewById(R.id.txtUsername);
        btnLogout = findViewById(R.id.btnLogout);
        userName = getIntent().getExtras().getString("userName");
        txtUsername.setText(userName);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity2.this, "You have logged out", Toast.LENGTH_SHORT).show();
            }
        });


    }
}