package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    LoginControl LC = new LoginControl();
    private TextView tvSession;
    private String takeSession;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (!LC.isLogin(MainActivity.this, "spPadang"))
        {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        else
        {
            setContentView(R.layout.activity_main);
            takeSession = LC.getPref(MainActivity.this, "spPadang");
            tvSession = findViewById(R.id.tv_session);
            tvSession.setText(takeSession);
        }
    }
    public void logoutProcess(View v)
    {
        LC.setPref(MainActivity.this, "spPadang", null);
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }
}