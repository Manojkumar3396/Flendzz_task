package com.example.emp_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class Emp_detailActivity extends AppCompatActivity {

    TextView id, name, email, en_add, phone_em, Company, website;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_emp_detail);
        id = findViewById(R.id.en_id);
        name = findViewById(R.id.en_name);
        email = findViewById(R.id.en_mail);
        en_add = findViewById(R.id.en_add);
        phone_em = findViewById(R.id.phone_em);
        Company = findViewById(R.id.Company);
        website = findViewById(R.id.website);


        String id_EM = getIntent().getStringExtra("id");
        String name_EM = getIntent().getStringExtra("name");
        String email_EM = getIntent().getStringExtra("email");
        String suite_em = getIntent().getStringExtra("suite");
        String street_em = getIntent().getStringExtra("street");
        String city_em = getIntent().getStringExtra("city");
        String code_em = getIntent().getStringExtra("code");
        String name_cam = getIntent().getStringExtra("names");
        String bs_em = getIntent().getStringExtra("bs");


        id.setText(id_EM);
        name.setText(name_EM);
        email.setText(email_EM);
        en_add.setText(suite_em + "," + street_em + "," + city_em);
        phone_em.setText(code_em);
        Company.setText(" Company name : " + name_cam);
        website.setText(" Website : " + bs_em);


    }

}