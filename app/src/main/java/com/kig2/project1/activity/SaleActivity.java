package com.kig2.project1.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kig2.project1.R;
import com.kig2.project1.adapter.SaleAdapter;
import com.kig2.project1.model.Adv;
import com.kig2.project1.ultil.CheckConnection;
import com.kig2.project1.ultil.Server;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import androidx.appcompat.widget.Toolbar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SaleActivity extends AppCompatActivity {
    Toolbar toolbarSale;
    ListView lvSale;
    SaleAdapter saleAdapter;
    ArrayList<Adv> arraySale;
    int idSale=0;
    int page=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        mapping();
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            getIdMode();
            ActionToolBar();
            GetData(page);
        }
        else{
            CheckConnection.ShowToast_Shost(getApplicationContext(),"CHeck internet");
            finish();
        }

    }

    private void GetData(int Page) {
        Context context;
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        String duongdan= Server.DuongdanadvSale+String.valueOf(Page);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Integer advId=0;
                Integer seLLId=0;
                Integer usedId=0;
                Integer modeId=0;
                String header="";
                String content="";
                String address="";
                String photo="";
                double price=0;
                double area=0;
                Integer bedroom=0;
                if(response!=null){
                    try {
                        JSONArray jsonArray=new JSONArray(response);
                        for(int i =0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            advId = jsonObject.getInt("AdvId");
                            seLLId = jsonObject.getInt("SeLLId");
                            modeId = jsonObject.getInt("ModeId");
                            usedId = jsonObject.getInt("UsedId");
                            header = jsonObject.getString("Header");
                            content = jsonObject.getString("Content");
                            address = jsonObject.getString("Address");
                            photo = jsonObject.getString("Photo");
                            price = jsonObject.getDouble("Price");
                            area = jsonObject.getDouble("Area");
                            bedroom = jsonObject.getInt("Bedroom");
                            arraySale.add(new Adv(advId,seLLId,modeId,usedId,header,content,address,photo,price,area,bedroom));
                            saleAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param=new HashMap<String, String>();
                param.put("ModeId",String.valueOf(idSale));
                return param;
            }
        };requestQueue.add(stringRequest);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarSale);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarSale.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void getIdMode() {
        idSale=getIntent().getIntExtra("modeId",-1);
        Log.d("giatri",idSale+"");
    }

    private void mapping() {
        toolbarSale=findViewById(R.id.toolbarSale);
        lvSale=findViewById(R.id.listviewSale);
        arraySale=new ArrayList<>();
        saleAdapter=new SaleAdapter(getApplicationContext(),arraySale);
        lvSale.setAdapter(saleAdapter);

    }
}