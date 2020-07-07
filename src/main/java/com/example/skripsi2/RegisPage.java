package com.example.skripsi2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RegisPage extends AppCompatActivity {

    private EditText user, email, pass, c_Pass;
    private Button btn_regist;
    private ProgressBar loading;
    private TextView code, pesan;
    private static String URL_REGIST = "http://192.168.1.7/regist_and_login/register.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis_page);

        loading = findViewById(R.id.loading);
        user = findViewById(R.id.user);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        c_Pass = findViewById(R.id.c_Pass);
        btn_regist = findViewById(R.id.btn_regist);
        code = findViewById(R.id.code);
        pesan = findViewById(R.id.pesan);

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code.setText(generateString(6));

                Regist();

                String pzan = pesan.getText().toString();
                Intent intent = new Intent(RegisPage.this, MainActivity.class);
                intent.putExtra("PZN",pzan);
                startActivity(intent);
            }

        });
    }

//    private boolean validateUser(){
//        String userInput = user.getText().toString().trim();
//        if (userInput.isEmpty() ){
//            userInput.setErrror("Nembole Kosong");
//            return false;
//        } else {
//            userInput.setError(null);
//            return true;
//        }
//    }

    private void Regist(){

        final String user = this.user.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String pass = this.pass.getText().toString().trim();
        final String code = this.code.getText().toString().trim();
        final String pesan = this.pesan.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{

                            JSONObject jsonObject = new JSONObject(response);

                            String success = jsonObject.getString("success");

                            if(success.equals("1")) {
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                Toast.makeText(RegisPage.this, "Register Success!", Toast.LENGTH_SHORT).show();
                            }



                        } catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(RegisPage.this, "Register Error!" + e.toString(), Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            btn_regist.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisPage.this, "Register Error!" + error.toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btn_regist.setVisibility(View.VISIBLE);
                    }
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user", user);
                params.put("email", email);
                params.put("pass", pass);
                params.put("code", code);
                params.put("pesan", pesan);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    private String generateString(int lenght){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i=0; i<lenght; i++){
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}