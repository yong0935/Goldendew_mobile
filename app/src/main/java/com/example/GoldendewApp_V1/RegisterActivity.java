package com.example.GoldendewApp_V1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_KOR, et_RESIDENT1, et_CELLPHONE, et_TXADDR1, et_TXADDR2, et_EMAIL;
    private Button btn_register;
    private CheckBox chk_EMAIL, chk_SMS, chk_DM, chk_TM, chk_YNMARRY, chk_YNACCEPT;
    private EditText edt_DTMARRY, edt_DTBIRTH;
    private TextView et_storecode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {//액티비티 시작시 처음으로 실행되는 생명주
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Intent intent1 = getIntent();
        Bundle bundle = intent1.getExtras();

        String STORECOD = bundle.getString("STORECODE");

        et_storecode = findViewById(R.id.et_storecode);
        et_storecode.setText(STORECOD);

        // 아이디 값 찾아주
        et_KOR = findViewById(R.id.et_STORE);
        et_RESIDENT1 = findViewById(R.id.et_RESIDENT1);
        et_TXADDR1 = findViewById(R.id.et_TXADDR1);
        et_TXADDR2 = findViewById(R.id.et_TXADDR2);
        et_CELLPHONE = findViewById(R.id.et_CELLPHONE);
        TextView tx_SEX = (TextView)findViewById(R.id.tx_SEX);
        edt_DTBIRTH = findViewById(R.id.edt_DTBIRTH);
        chk_YNMARRY = findViewById(R.id.chk_YNMARRY);
        edt_DTMARRY = findViewById(R.id.edt_DTMARRY);
        et_EMAIL = findViewById(R.id.et_EMAIL);
        chk_EMAIL = findViewById(R.id.chk_EMAIL);
        chk_SMS = findViewById(R.id.chk_SMS);
        chk_DM = findViewById(R.id.chk_DM);
        chk_TM = findViewById(R.id.chk_TM);
        chk_YNACCEPT = findViewById(R.id.chk_YNACCEPT);
        RadioGroup Gender = (RadioGroup)findViewById(R.id.Gender);
        btn_register = findViewById(R.id.btn_login);







        Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String gender;
                if (checkedId == R.id.btn_MAN){
                    tx_SEX.setText("01");
                }
                else if (checkedId == R.id.btn_WOMAN){
                    tx_SEX.setText("02");
                }

            }
        });









        //회원가입 버튼 클릭 시 수
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //Edittext 에 입력되어 있는 현재 데이터를 가져온
                String userKor = et_KOR.getText().toString();
                String userResident1 = et_RESIDENT1.getText().toString();
                String userAddr1 = et_TXADDR1.getText().toString();
                String userAddr2 = et_TXADDR2.getText().toString();
                String userCellphone = et_CELLPHONE.getText().toString();
                String userSex = tx_SEX.getText().toString();
                String userDtbirth = edt_DTBIRTH.getText().toString();

                String userYnmarry = "";
                if (chk_YNMARRY.isChecked()){
                    userYnmarry = chk_YNMARRY.getText().toString();
                }

                String userDtmarry = edt_DTMARRY.getText().toString();

                String userEmail = et_EMAIL.getText().toString();

                String userYNEMAIL = "";
                if (chk_EMAIL.isChecked()){
                    userYNEMAIL = chk_EMAIL.getText().toString();
                }

                String userYNSMS = "";
                if (chk_SMS.isChecked()){
                    userYNSMS = chk_SMS.getText().toString();
                }

                String userYNDM = "";
                if (chk_DM.isChecked()){
                    userYNDM = chk_DM.getText().toString();
                }

                String userYNTM = "";
                if (chk_TM.isChecked()){
                    userYNTM = chk_TM.getText().toString();
                }

                String userYnaccept = "";
                if (chk_YNACCEPT.isChecked()){
                    userYnaccept = chk_YNACCEPT.getText().toString();
                }



                


                Response.Listener<String> reponseLister = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { //회원등록에 성공한 경
                                Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "실", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };
                //서버로 volley를 이용해서 요청
                RegisterRequest registerRequest = new RegisterRequest(userKor, userResident1, userAddr1, userAddr2,userCellphone, userSex, userDtbirth,
                        userYnmarry,userDtmarry, userEmail, userYNEMAIL,
                       userYNSMS, userYNDM, userYNTM,    userYnaccept,reponseLister);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);


            }
        });


    }
}


