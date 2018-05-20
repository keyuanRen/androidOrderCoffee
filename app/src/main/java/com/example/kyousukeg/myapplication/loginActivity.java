

package com.example.kyousukeg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity {

    EditText checkUsername;
    EditText checkPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        checkUsername = (EditText)findViewById(R.id.checkUser);
        checkPassword = (EditText)findViewById(R.id.checkPass);

        final CardView loginButton = (CardView) findViewById(R.id.loginButton);
        final TextView registerHere = (TextView)findViewById(R.id.registerHere);

        //login button to home page
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(loginActivity.this , MainActivity.class);
                loginActivity.this.startActivity(loginIntent);
            }
        });

        //call register page
        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(loginActivity.this, registerActivity.class);
                loginActivity.this.startActivity(registerIntent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //empty textboxes
        checkUsername.setText("");
        checkPassword.setText("");
    }
}
