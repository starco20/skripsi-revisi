package com.example.skripsi2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btn_login, btn_Regis;
    EditText email, pass;
    String tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        btn_Regis = findViewById(R.id.btn_Regis);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        btn_Regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisPage.class));
            }
        });
    }

    public void Login(){
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.7/regist_and_login/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("1")) {
                            startActivity(new Intent(MainActivity.this, Home.class));
//                            Intent i = new Intent(MainActivity.this, Home.class);
//                            i.putExtra("Vtp", tp);
//                            startActivity(i);
//                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Email atau Password anda masih belum benar",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("email", email.getText().toString());
                params.put("pass", pass.getText().toString());
                tp = email.getText().toString();
                return params;
            }
        };

        Volley.newRequestQueue(this).add(request);
    }

}