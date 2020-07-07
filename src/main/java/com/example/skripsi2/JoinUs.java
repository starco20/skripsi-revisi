package com.example.skripsi2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class JoinUs extends AppCompatActivity {

    EditText tempatlahir,tanggallahir,usersukuasalmarga,userdesa,userkecamatan,userkabupaten,
    userpropinsi,userkodepos,usernohp,userasalsma,asdesa,askecamatan,askabupaten,aspropinsi,askodepos,email,fatnama,
    fatdesa,fatkecamatan,fatkabupaten,fatpropinsi,fatkodepos,fatnohp,fatemail,ibunama,
    ibudesa,ibukecamatan,ibukabupaten,ibupropinsi,ibukodepos,ibunohp,ibuemail,wlnama,
    wldesa,wlkecamatan,wlkabupaten,wlpropinsi,wlkodepos,wlnohp,wlemail;
    Button update,nex;

    RadioGroup Jeniz,Gol,Ztat,Agm,Fatpen,Fatagm,Magm,Mapen,Wlgm,Wlpen;
    RadioButton jniz,glo,zat,gam,fatpen,fatagm,magm,mapen,wlagm,wlpn;

    TextView userjeniskelamin,usergolongandarah,userstatus,useragama,fatpendidikan,fatagama,ibupendidikan,ibuagama,wlpendidikan,wlagama;


    private static final String UPDATE_URL = "http://192.168.1.7/regist_and_login/kirim.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_us);


        Wlgm = findViewById(R.id.wlagm);
        Wlpen = findViewById(R.id.wlpen);
        Magm = findViewById(R.id.maagm);
        Mapen = findViewById(R.id.mapen);
        Jeniz = findViewById(R.id.jeniz);
        Gol = findViewById(R.id.gol);
        Ztat = findViewById(R.id.ztat);
        Agm = findViewById(R.id.agm);
        Fatpen = findViewById(R.id.fatpen);
        Fatagm = findViewById(R.id.fatagm);

        wlpendidikan = findViewById(R.id.wlpendidikan);
        wlagama = findViewById(R.id.wlagama);
        ibupendidikan = findViewById(R.id.ibupendidikan);
        ibuagama = findViewById(R.id.ibuagama);
        fatpendidikan = findViewById(R.id.fatpendidikan);
        fatagama = findViewById(R.id.fatagama);
        useragama = findViewById(R.id.useragama);
        userjeniskelamin = findViewById(R.id.userjeniskelamin);
        usergolongandarah = findViewById(R.id.usergolongandarah);
        userstatus = findViewById(R.id.userstatus);

        int radioId9 = Wlgm.getCheckedRadioButtonId();
        wlagm= findViewById(radioId9);
        wlagama.setText(wlagm.getText());

        int radioId10 = Wlpen.getCheckedRadioButtonId();
        wlpn = findViewById(radioId10);
        wlpendidikan.setText(wlpn.getText());

        int radioId7 = Magm.getCheckedRadioButtonId();
        magm = findViewById(radioId7);
        ibuagama.setText(magm.getText());

        int radioId8 = Mapen.getCheckedRadioButtonId();
        mapen = findViewById(radioId8);
        ibupendidikan.setText(mapen.getText());

        int radioId5 = Fatagm.getCheckedRadioButtonId();
        fatagm = findViewById(radioId5);
        fatagama.setText(fatagm.getText());

        int radioId6 = Fatpen.getCheckedRadioButtonId();
        fatpen = findViewById(radioId6);
        fatpendidikan.setText(fatpen.getText());

        int radioId4 = Agm.getCheckedRadioButtonId();
        gam = findViewById(radioId4);
        useragama.setText(gam.getText());

        int radioId3 = Ztat.getCheckedRadioButtonId();
        zat = findViewById(radioId3);
        userstatus.setText(zat.getText());

        int radioId = Jeniz.getCheckedRadioButtonId();
        jniz = findViewById(radioId);
        userjeniskelamin.setText(jniz.getText());

        int radioId2 = Gol.getCheckedRadioButtonId();
        glo = findViewById(radioId2);
        usergolongandarah.setText(glo.getText());

//        cek.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int radioId = Jeniz.getCheckedRadioButtonId();
//                jniz = findViewById(radioId);
//                userjeniskelamin.setText(jniz.getText());
//            }
//        });

        nex = findViewById(R.id.nex);

        wlnama = findViewById(R.id.wlnama);
        wldesa = findViewById(R.id.wldesa);
        wlkecamatan = findViewById(R.id.wlkecamatan);
        wlkabupaten = findViewById(R.id.wlkabupaten);
        wlpropinsi = findViewById(R.id.wlpropinsi);
        wlkodepos = findViewById(R.id.wlkodepos);
        wlnohp = findViewById(R.id.wlnohp);
        wlemail = findViewById(R.id.wlemail);


        ibunama = findViewById(R.id.ibunama);
        ibudesa = findViewById(R.id.ibudesa);
        ibukecamatan = findViewById(R.id.ibukecamatan);
        ibukabupaten = findViewById(R.id.ibukabupaten);
        ibupropinsi = findViewById(R.id.ibupropinsi);
        ibukodepos = findViewById(R.id.ibukodepos);
        ibunohp = findViewById(R.id.ibunohp);
        ibuemail = findViewById(R.id.ibuemail);


        email = findViewById(R.id.email);
        update = findViewById(R.id.krimdata);

        asdesa = findViewById(R.id.asdesa);
        askecamatan = findViewById(R.id.askecamatan);
        askabupaten = findViewById(R.id.askabupaten);
        aspropinsi = findViewById(R.id.aspropinsi);
        askodepos = findViewById(R.id.askodepos);


        tempatlahir = findViewById(R.id.tempatlahir);
        tanggallahir = findViewById(R.id.tanggallahir);
        usersukuasalmarga = findViewById(R.id.usersukuasalmarga);

        userdesa = findViewById(R.id.userdesa);
        userkecamatan = findViewById(R.id.userkecamatan);
        userkabupaten = findViewById(R.id.userkabupaten);

        userpropinsi = findViewById(R.id.userpropinsi);
        userkodepos = findViewById(R.id.userkodepos);
        usernohp = findViewById(R.id.usernohp);


        userasalsma = findViewById(R.id.userasalsma);

        fatnama = findViewById(R.id.fatnama);
        fatdesa = findViewById(R.id.fatdesa);
        fatkecamatan = findViewById(R.id.fatkecamatan);
        fatkabupaten = findViewById(R.id.fatkabupaten);
        fatpropinsi = findViewById(R.id.fatpropinsi);
        fatkodepos = findViewById(R.id.fatkodepos);
        fatnohp = findViewById(R.id.fatnohp);
        fatemail = findViewById(R.id.fatemail);




        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId9 = Wlgm.getCheckedRadioButtonId();
                wlagm= findViewById(radioId9);
                wlagama.setText(wlagm.getText());

                int radioId10 = Wlpen.getCheckedRadioButtonId();
                wlpn = findViewById(radioId10);
                wlpendidikan.setText(wlpn.getText());

                int radioId7 = Magm.getCheckedRadioButtonId();
                magm = findViewById(radioId7);
                ibuagama.setText(magm.getText());

                int radioId8 = Mapen.getCheckedRadioButtonId();
                mapen = findViewById(radioId8);
                ibupendidikan.setText(mapen.getText());

                int radioId5 = Fatagm.getCheckedRadioButtonId();
                fatagm = findViewById(radioId5);
                fatagama.setText(fatagm.getText());

                int radioId6 = Fatpen.getCheckedRadioButtonId();
                fatpen = findViewById(radioId6);
                fatpendidikan.setText(fatpen.getText());

                int radioId4 = Agm.getCheckedRadioButtonId();
                gam = findViewById(radioId4);
                useragama.setText(gam.getText());

                int radioId = Jeniz.getCheckedRadioButtonId();
                jniz = findViewById(radioId);
                userjeniskelamin.setText(jniz.getText());

                int radioId2 = Gol.getCheckedRadioButtonId();
                glo = findViewById(radioId2);
                usergolongandarah.setText(glo.getText());

                int radioId3 = Ztat.getCheckedRadioButtonId();
                zat = findViewById(radioId3);
                userstatus.setText(zat.getText());

                UpdateUser();

                startActivity(new Intent(JoinUs.this, Home.class));
            }
        });

        nex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JoinUs.this, UploadPhoto.class));
            }
        });
    }
    public void UpdateUser(){

        String Email = email.getText().toString().trim().toLowerCase();
        String Tempatlahir = tempatlahir.getText().toString().trim();
        String Tanggallahir = tanggallahir.getText().toString().trim();
        String Userjeniskelamin = userjeniskelamin.getText().toString().trim();
        String Usergolongandarah = usergolongandarah.getText().toString().trim();
        String Usersukuasalmarga = usersukuasalmarga.getText().toString().trim();

        String Userdesa = userdesa.getText().toString().trim();
        String Userkecamatan = userkecamatan.getText().toString().trim();
        String Userkabupaten = userkabupaten.getText().toString().trim();

        String Userpropinsi = userpropinsi.getText().toString().trim();
        String Userkodepos = userkodepos.getText().toString().trim();
        String Usernohp = usernohp.getText().toString().trim();
        String Userstatus = userstatus.getText().toString().trim();
        String Useragama = useragama.getText().toString().trim();
        String Userasalsma = userasalsma.getText().toString().trim();

        String Asdesa = asdesa.getText().toString().trim();
        String Askecamatan = askecamatan.getText().toString().trim();
        String Askabupaten = askabupaten.getText().toString().trim();
        String Aspropinsi = aspropinsi.getText().toString().trim();
        String Askodepos = askodepos.getText().toString().trim();

        String Fatnama = fatnama.getText().toString().trim();
        String Fatdesa = fatdesa.getText().toString().trim();
        String Fatkecamatan = fatkecamatan.getText().toString().trim();
        String Fatkabupaten = fatkabupaten.getText().toString().trim();
        String Fatpropinsi = fatpropinsi.getText().toString().trim();
        String Fatkodepos = fatkodepos.getText().toString().trim();
        String Fatnohp = fatnohp.getText().toString().trim();
        String Fatemail = fatemail.getText().toString().trim();
        String Fatpendidikan = fatpendidikan.getText().toString().trim();
        String Fatagama = fatagama.getText().toString().trim();


        String Ibunama = ibunama.getText().toString().trim();
        String Ibudesa = ibudesa.getText().toString().trim();
        String Ibukecamatan = ibukecamatan.getText().toString().trim();
        String Ibukabupaten = ibukabupaten.getText().toString().trim();
        String Ibupropinsi = ibupropinsi.getText().toString().trim();
        String Ibukodepos = ibukodepos.getText().toString().trim();
        String Ibunohp = ibunohp.getText().toString().trim();
        String Ibuemail = ibuemail.getText().toString().trim();
        String Ibupendidikan = ibupendidikan.getText().toString().trim();
        String Ibuagama = ibuagama.getText().toString().trim();

        String Wlnama = wlnama.getText().toString().trim();
        String Wldesa = wldesa.getText().toString().trim();
        String Wlkecamatan = wlkecamatan.getText().toString().trim();
        String Wlkabupaten = wlkabupaten.getText().toString().trim();
        String Wlpropinsi = wlpropinsi.getText().toString().trim();
        String Wlkodepos = wlkodepos.getText().toString().trim();
        String Wlnohp = wlnohp.getText().toString().trim();
        String Wlemail = wlemail.getText().toString().trim();
        String Wlpendidikan = wlpendidikan.getText().toString().trim();
        String Wlagama = wlagama.getText().toString().trim();

        Updater(Email, Tempatlahir,Tanggallahir,Userjeniskelamin,Usergolongandarah,Usersukuasalmarga,Userdesa,Userkecamatan,Userkabupaten,
                Userpropinsi,Userkodepos,Usernohp,Userstatus,Useragama,Userasalsma,Asdesa,Askecamatan,Askabupaten,Aspropinsi,Askodepos,Fatnama,Fatdesa,Fatkecamatan,Fatkabupaten,Fatpropinsi,
                Fatkodepos,Fatnohp,Fatemail,Fatpendidikan,Fatagama,
                Ibunama,Ibudesa,Ibukecamatan,Ibukabupaten,Ibupropinsi,Ibukodepos,Ibunohp,Ibuemail,Ibupendidikan,Ibuagama,
                Wlnama,Wldesa,Wlkecamatan,Wlkabupaten,Wlpropinsi,Wlkodepos,Wlnohp,Wlemail,Wlpendidikan,Wlagama

        );
    }

    private void Updater (String email, String tempatlahir, String tanggallahir, String userjeniskelamin,String usergolongandarah,String usersukuasalmarga,
                          String userdesa,String userkecamatan,String userkabupaten,String userpropinsi,String userkodepos, String usernohp,String userstatus,
                          String useragama,String userasalsma,String asdesa,String askecamatan,String askabupaten,String aspropinsi,String askodepos,String fatnama,String fatdesa,String fatkecamatan,String fatkabupaten,String fatpropinsi,String fatkodepos
            ,String fatnohp,String fatemail,String fatpendidikan,String fatagama,String ibunama,String ibudesa,String ibukecamatan,String ibukabupaten,String ibupropinsi,String ibukodepos,String ibunohp,String ibuemail,String ibupendidikan,String ibuagama,
                          String wlnama,String wldesa,String wlkecamatan,String wlkabupaten,String wlpropinsi,String wlkodepos
            ,String wlnohp,String wlemail,String wlpendidikan,String wlagama
                          ){
        class KirimDataz extends AsyncTask<String, Void, String>{
            ProgressDialog loading;
            KirimData ruci = new KirimData();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(JoinUs.this, "Please Wait", null, true, true);
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
                data.put("tempatlahir", params[1]);
                data.put("tanggallahir", params[2]);
                data.put("userjeniskelamin", params[3]);
                data.put("usergolongandarah", params[4]);
                data.put("usersukuasalmarga", params[5]);

                data.put("userdesa", params[6]);
                data.put("userkecamatan", params[7]);
                data.put("userkabupaten", params[8]);

                data.put("userpropinsi", params[9]);
                data.put("userkodepos", params[10]);
                data.put("usernohp", params[11]);
                data.put("userstatus", params[12]);
                data.put("useragama", params[13]);
                data.put("userasalsma", params[14]);

                data.put("asdesa", params[15]);
                data.put("askecamatan", params[16]);
                data.put("askabupaten", params[17]);
                data.put("aspropinsi", params[18]);
                data.put("askodepos", params[19]);

                data.put("fatnama", params[20]);
                data.put("fatdesa", params[21]);
                data.put("fatkecamatan", params[22]);
                data.put("fatkabupaten", params[23]);
                data.put("fatpropinsi", params[24]);
                data.put("fatkodepos", params[25]);
                data.put("fatnohp", params[26]);
                data.put("fatemail", params[27]);
                data.put("fatpendidikan", params[28]);
                data.put("fatagama", params[29]);

                data.put("ibunama", params[30]);
                data.put("ibudesa", params[31]);
                data.put("ibukecamatan", params[32]);
                data.put("ibukabupaten", params[33]);
                data.put("ibupropinsi", params[34]);
                data.put("ibukodepos", params[35]);
                data.put("ibunohp", params[36]);
                data.put("ibuemail", params[37]);
                data.put("ibupendidikan", params[38]);
                data.put("ibuagama", params[39]);

                data.put("wlnama", params[40]);
                data.put("wldesa", params[41]);
                data.put("wlkecamatan", params[42]);
                data.put("wlkabupaten", params[43]);
                data.put("wlpropinsi", params[44]);
                data.put("wlkodepos", params[45]);
                data.put("wlnohp", params[46]);
                data.put("wlemail", params[47]);
                data.put("wlpendidikan", params[48]);
                data.put("wlagama", params[49]);



                String result = ruci.sendPostRequest(UPDATE_URL, data);

                return result;
            }

        }
        KirimDataz rupi = new KirimDataz();
        rupi.execute(email,tempatlahir,tanggallahir,userjeniskelamin,usergolongandarah,usersukuasalmarga,userdesa,userkecamatan,userkabupaten,
                userpropinsi,userkodepos,usernohp,userstatus,useragama,userasalsma,asdesa,askecamatan,askabupaten,aspropinsi,askodepos,fatnama,
                fatdesa,fatkecamatan,fatkabupaten,fatpropinsi,fatkodepos,fatnohp,fatemail,fatpendidikan,fatagama,ibunama,ibudesa,ibukecamatan,ibukabupaten,ibupropinsi,ibukodepos,ibunohp,ibuemail,ibupendidikan,ibuagama
                ,wlnama,wldesa,wlkecamatan,wlkabupaten,wlpropinsi,wlkodepos,wlnohp,wlemail,wlpendidikan,wlagama
                );
    }
}