package com.example.GoldendewApp_V1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText et_STORE;
    private Button btn_register, btn_information;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);



        setContentView(R.layout.activity_login);

        et_STORE = findViewById(R.id.et_STORE);
        btn_register = findViewById(R.id.btn_register);
        btn_information = findViewById(R.id.btn_information);

        btn_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CompanyInformation.class);
                startActivity(intent);
            }
        });


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String STORECODE = et_STORE.getText().toString();



                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.putExtra("STORECODE", et_STORE.getText().toString());
                startActivity(intent);
            }
        });



    }
}