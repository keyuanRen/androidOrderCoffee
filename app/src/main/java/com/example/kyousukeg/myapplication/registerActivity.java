package com.example.kyousukeg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {

    DatabaseBasic db;
    EditText edUsername, edEmail, edPassword, confPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseBasic(this);

        edUsername = (EditText)findViewById(R.id.edUsername);
        edEmail = (EditText)findViewById(R.id.edEmail);
        edPassword = (EditText)findViewById(R.id.edPass);
        confPassword = (EditText)findViewById(R.id.confPass);

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
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confpassword = confPassword.getText().toString();
                if(username.equals("")||email.equals("")||password.equals("")||confpassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(password.equals(confpassword))
                    {
                        Boolean checkUser = db.checkIfUserExist(username, email);
                        if(checkUser == true)
                        {
                            Boolean insert = db.insert(username,email,password);
                            if(insert == true)
                            {
                                Intent confRegIntent = new Intent(registerActivity.this , loginActivity.class);
                                registerActivity.this.startActivity(confRegIntent);
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Username or Email Already Exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Password Does Not Match",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}
