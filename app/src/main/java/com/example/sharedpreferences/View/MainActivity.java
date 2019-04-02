package com.example.sharedpreferences.View;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharedpreferences.R;


public class MainActivity extends AppCompatActivity {
    String SUsername, SPass;
    private Button btnlogin;
    private EditText tvUser, tvPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin = findViewById(R.id.btn_login);
        tvUser = findViewById(R.id.username);
        tvPass = findViewById(R.id.pass);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SUsername = tvUser.getText().toString();
                SPass = tvPass.getText().toString();
                if (SUsername.equals("rizky") && SPass.equals("123")) {
                    editor.putString("username", SUsername);
                    editor.commit();
                    Intent a = new Intent(getApplicationContext(), BottomNavigationActivity.class);
                    a.putExtra("username", SUsername);
                    a.putExtra("password", SPass);
                    startActivity(a);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Username atau Password salah", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
