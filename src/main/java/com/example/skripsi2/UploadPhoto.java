package com.example.skripsi2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class UploadPhoto extends AppCompatActivity {

    EditText email,photo1;
    Button update;

    private static final String UPDATE_URL = "http://192.168.1.11/regist_and_login/kirim2.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);

        email = findViewById(R.id.email);
        photo1 = findViewById(R.id.photo1);

        update = findViewById(R.id.buttonupdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateUser();
            }
        });
    }

    private void UpdateUser() {

        String Email = email.getText().toString().trim();
        String Photo1 = photo1.getText().toString().trim();
        Updater(Email, Photo1);
    }

    private void Updater(String email, String photo1) {
        class Kirimdataa extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            KirimData ruc = new KirimData();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(UploadPhoto.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String, String>();

                data.put("email", params[0]);
                data.put("photo1", params[1]);

                String result = ruc.sendPostRequest(UPDATE_URL, data);

                return result;
            }
        }

        Kirimdataa ru = new Kirimdataa();
        ru.execute(email,photo1);
    }

}
