package com.example.brightwave;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    EditText getEmail;

   EditText getUsername;

  EditText getPassword;
  Button signupButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

       getEmail = findViewById(R.id.SignupText1);
      getUsername = findViewById(R.id.SignupText2);
       getPassword = findViewById(R.id.SignupText3);
       signupButton = findViewById(R.id.SignupButton);
      signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                if(getEmail.getText().toString().trim().equals("c223309@ugrad.iiuc.ac.bd") && getUsername.getText().toString().trim().equals("Shafwat Mahiya") && getPassword.getText().toString().trim().equals("ayman")){
                  Toast.makeText(SignupActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
               } else{
                  Toast.makeText(SignupActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
               }
           }
      });


        }
}