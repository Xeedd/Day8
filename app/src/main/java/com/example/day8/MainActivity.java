package com.example.day8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private Button btnLog;
        private EditText edtTxtUsername,edtTxtPassword;

        public static final String SHARED_PREFS = "sharedPrefs";
        public static final String USER = "Username";
        public static final String PASS = "Password";

        private String userName, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(areFieldsEmpty()){
                    Toast.makeText(MainActivity.this,"One of the fields is empty, please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else if (isMatchData()){
                   Toast.makeText(MainActivity.this, "User or password missmatch, try again.", Toast.LENGTH_SHORT).show();
                }
                else if (!(isMatchData())) {
                    Toast.makeText(MainActivity.this, "LOGGED IN SUCCESFULLY", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                   intent.putExtra("userName", userName);
                   intent.putExtra("password", password);
                   startActivity(intent);
                }
            }
        });

    }

    public void initViews(){
        btnLog = findViewById(R.id.btnLog);
        edtTxtUsername = findViewById(R.id.edtTxtUsername);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
    }




      private boolean areFieldsEmpty(){
               if(edtTxtUsername.getText().toString().isEmpty() || edtTxtPassword.getText().toString().isEmpty()){
                   return true;
               }
               return false;
      }


     /* public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER,edtTxtUsername.getText().toString());
        editor.putString(PASS,edtTxtPassword.getText().toString());
      }*/

public void loadData(){
    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
    userName = sharedPreferences.getString(USER,"plax");
    password = sharedPreferences.getString(PASS,"Login@123");


}

public boolean isMatchData(){
    loadData();
    if(!edtTxtUsername.getText().toString().equals(userName) || !edtTxtPassword.getText().toString().equals(password)){
        return true;
    }
   return false;
}


}