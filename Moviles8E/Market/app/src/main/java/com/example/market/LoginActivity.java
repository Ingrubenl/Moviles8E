package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btnLogin(View view){
        //Toast.makeText(this, "You have pressed Login Button", Toast.LENGTH_SHORT).show();
        Intent actHome = new Intent(this, HomeActivity.class);
        startActivity(actHome);
    }

    public void btnSignup(View view){
        //Toast.makeText(this, "You have pressed Sign up Button", Toast.LENGTH_SHORT).show();
        Intent actRegister = new Intent(this, RegisterActivity.class);
        startActivity(actRegister);
    }
}
