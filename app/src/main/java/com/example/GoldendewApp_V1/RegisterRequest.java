package com.example.GoldendewApp_V1;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 url 설정(php 파일 연동)
    final static private String URL = "http://139.150.75.242/registertest";
    private Map<String, String> map;


    public RegisterRequest(String userKor, String userResident1, String userAddr1,
                           String userAddr2, String userCellphone,String userSex,String userDtbirth
            , String userYnmarry, String userDtmarry,String userEmail,String userYNEMAIL, String userYNSMS, String userYNDM, String userYNTM,
                            String userYnaccept,Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userKor", userKor);
        map.put("userResident1", userResident1);
        map.put("userAddr1", userAddr1);
        map.put("userAddr2", userAddr2);
        map.put("userCellphone", userCellphone);
        map.put("userSex", userSex);
        map.put("userDtbirth", userDtbirth);
        map.put("userYnmarry", userYnmarry);
        map.put("userDtmarry", userDtmarry);
        map.put("userEmail", userEmail);
        map.put("userYNEMAIL", userYNEMAIL);
        map.put("userYNSMS", userYNSMS);
        map.put("userYNDM", userYNDM);
        map.put("userYNTM", userYNTM);
        map.put("userYnaccept", userYnaccept);





    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}