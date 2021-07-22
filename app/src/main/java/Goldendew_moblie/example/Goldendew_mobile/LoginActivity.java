package Goldendew_moblie.example.Goldendew_mobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.GoldendewApp_V1.R;


public class LoginActivity extends AppCompatActivity {
    private EditText et_STORE;
    private Button btn_register, btn_information;
    private AlertDialog dialog;



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

                if (STORECODE.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    dialog = builder.setMessage("매장코드를 입력해주세요.")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                    return;
                }



                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.putExtra("STORECODE", et_STORE.getText().toString());
                startActivity(intent);
            }
        });



    }
}