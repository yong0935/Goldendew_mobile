package Goldendew_moblie.example.Goldendew_mobile;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterCheck extends StringRequest {

    //서버 url 설정(php 파일 연동)
    final static private String URL = "Login";
    private Map<String, String> map;


    public RegisterCheck(String userKor,  String userDtbirth, String userCellphone,Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userKor", userKor);
        map.put("userDtbirth", userDtbirth);
        map.put("userCellphone", userCellphone);


    }


    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

