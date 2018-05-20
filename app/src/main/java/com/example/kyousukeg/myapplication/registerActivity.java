package com.example.kyousukeg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText edUsername = (EditText)findViewById(R.id.edUsername);
        final EditText edEmail = (EditText)findViewById(R.id.edEmail);
        final EditText edPassword = (EditText)findViewById(R.id.edPass);
        final EditText confPassword = (EditText)findViewById(R.id.confPass);

        final Button backLogButton = (Button)findViewById(R.id.backLogButton);
        final Button confRegButton = (Button)findViewById(R.id.confRegButton);

        //back to login page from register
        backLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backLogIntent  = new Intent(registerActivity.this , loginActivity.class);
                registerActivity.this.startActivity(backLogIntent);
            }
        });

        //confirm register button back to login page
        confRegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confRegIntent = new Intent(registerActivity.this , loginActivity.class);
                registerActivity.this.startActivity(confRegIntent);
            }
        });

    }
}
