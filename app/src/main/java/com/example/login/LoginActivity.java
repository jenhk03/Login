package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{
    private EditText etUsername, etPwd;
    private Button btnLogin;
    private String username, pwd;
    LoginControl lc = new LoginControl();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.et_username);
        etPwd = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);
    }
    public void loginProcess(View v)
    {
        username = etUsername.getText().toString();
        pwd = etPwd.getText().toString();
        if (username.equals("admin") && pwd.equals("admin"))
        {
            lc.setPref(LoginActivity.this, "spPadang", username);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        else if (username.trim().equals(""))
        {
            etUsername.setError("Username tidak boleh kosong!");
        }
        else if (pwd.trim().equals(""))
        {
            etPwd.setError("Password tidak boleh kosong!");
        }
        else
        {
            Toast.makeText(this, "Login Error!", Toast.LENGTH_SHORT).show();
        }
    }
}