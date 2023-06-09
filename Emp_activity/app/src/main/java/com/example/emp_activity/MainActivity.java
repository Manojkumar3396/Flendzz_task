package com.example.emp_activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String url = "https://jsonplaceholder.typicode.com/users";
    ArrayList<LinearPojo> arrayList;
    String bs;
    RecyclerView recyclerView;
    AdapterRecycler adapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();


        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#93C572"));

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.purple_200));
        actionBar.setBackgroundDrawable(colorDrawable);
        loginUser();

        recyclerView = findViewById(R.id.recy);


    }

    private void loginUser() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i <= jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String id = jsonObject.getString("id");
                                String name = jsonObject.getString("name");
                                String email = jsonObject.getString("email");
                                JSONObject jsonObject1 = jsonObject.getJSONObject("address");
                                String suite = jsonObject1.getString("suite");
                                String street = jsonObject1.getString("street");
                                String city = jsonObject1.getString("city");
                                String zipcode = jsonObject1.getString("zipcode");
                                String phone = jsonObject.getString("phone");
                                JSONObject jsonObject2 = jsonObject.getJSONObject("company");
                                String C_name = jsonObject2.getString("name");
                                String catchPhrase = jsonObject2.getString("catchPhrase");
                                String website = jsonObject.getString("website");

                                arrayList.add(new LinearPojo(id, name, email, suite, city, zipcode, phone, C_name, catchPhrase, website, street));


                                recyclerView.setHasFixedSize(true);
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                                recyclerView.setLayoutManager(linearLayoutManager);

                                adapterRecycler = new AdapterRecycler(MainActivity.this, arrayList);
                                recyclerView.setAdapter(adapterRecycler);
                            }

                        } catch (JSONException e) {


                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();

                    }

                }) {


        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}