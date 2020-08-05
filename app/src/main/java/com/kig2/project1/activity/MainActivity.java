package com.kig2.project1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.kig2.project1.R;
import com.kig2.project1.adapter.AdvAdapter;
import com.kig2.project1.adapter.ModeAdapter;
import com.kig2.project1.model.Adv;
import com.kig2.project1.model.Mode;
import com.kig2.project1.ultil.CheckConnection;
import com.kig2.project1.ultil.Server;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listViewHome;
    DrawerLayout drawerLayout;
    ArrayList<Mode> arrayMode;
    ModeAdapter modeAdapter;
        int modeId=0;
        String modeName="";
        String image="";

    ArrayList<Adv> arrayAdvNew;
    AdvAdapter advAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
            GetMode();
            GetAdvNew();
            CatchOnItemListView();
        }else{
            CheckConnection.ShowToast_Shost(getApplicationContext(),"Kiem tra lai connection!!!");
            finish();
        }
    }

    private void CatchOnItemListView() {
        listViewHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this,MainActivity.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Shost(getApplicationContext(),"Check connection!!!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this,SaleActivity.class);
                            intent.putExtra("modeId",arrayMode.get(i).getModeId());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Shost(getApplicationContext(),"Check connection!!!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this,BuyActivity.class);
                            intent.putExtra("modeId",arrayMode.get(i).getModeId());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Shost(getApplicationContext(),"Check connection!!!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this,RentActivity.class);
                            intent.putExtra("modeId",arrayMode.get(i).getModeId());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Shost(getApplicationContext(),"Check connection!!!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this,LeaseActivity.class);
                            intent.putExtra("modeId",arrayMode.get(i).getModeId());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Shost(getApplicationContext(),"Check connection!!!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }

    private void GetAdvNew() {
        Context context;
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest =new JsonArrayRequest(Server.Duongdanadvnew, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response != null) {
                    Integer advId=0;
                    Integer seLLId=0;
                    Integer usedId=0;
                    String header="";
                    String content="";
                    String address="";
                    String photo="";
                    double price=0;
                    double area=0;
                    Integer bedroom=0;
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
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
                            arrayAdvNew.add(new Adv(advId,seLLId,modeId,usedId,header,content,address,photo,price,area,bedroom));
                            advAdapter.notifyDataSetChanged();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Shost(getApplicationContext(),error.toString());
            }
        });

        requestQueue.add(jsonArrayRequest);
    }

    private void GetMode() {

        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.Duongdan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response !=null){
                    for(int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject=response.getJSONObject(i);
                            modeId=jsonObject.getInt("ModeId");
                            modeName=jsonObject.getString("ModeName");
                            image = jsonObject.getString("Image");

                            arrayMode.add(new Mode(modeId,modeName,image));
                            modeAdapter .notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Shost(getApplicationContext(),error.toString());
            }
        });
        jsonArrayRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
        requestQueue.add(jsonArrayRequest);

    }

    private void mapping(){
        toolbar= (Toolbar) findViewById(R.id.tbHome);
        viewFlipper=findViewById(R.id.vfHome);
        recyclerView=findViewById(R.id.rvHome);
        navigationView=findViewById(R.id.nvHome);
        listViewHome=findViewById(R.id.lvHome);
        drawerLayout=findViewById(R.id.drL);
        arrayMode=new ArrayList<>();
        arrayMode.add(0,new Mode(0,"Home","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRx1dgF6cD-O__Uz3xY5tGaImzIm1dVFF9zcg&usqp=CAU"));
        modeAdapter=new ModeAdapter(arrayMode,getApplicationContext());
        listViewHome.setAdapter(modeAdapter);
        arrayAdvNew=new ArrayList<>();
        advAdapter=new AdvAdapter(getApplicationContext(),arrayAdvNew);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(advAdapter);



    }

    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void ActionViewFlipper() {
        ArrayList<String> arrayListAdv=new ArrayList<>();
        arrayListAdv.add("https://tuhocdohoa.vn/wp-content/uploads/2018/08/M%E1%BA%ABu-banner-b%E1%BA%A5t-%C4%91%E1%BB%99ng-s%E1%BA%A3n.jpg");
        arrayListAdv.add("https://viettamduc.com/wp-content/uploads/2019/01/banner-bat-dong-san-lop-do-hoa-vtd.jpg");
        arrayListAdv.add("https://bdsweb.com.vn/upload_images/images/bbds/banner-bat-dong-san-01.jpg");
        arrayListAdv.add("https://bdsweb.com.vn/upload_images/images/bbds/banner-bat-dong-san-04.jpg");
        arrayListAdv.add("https://bdsweb.com.vn/upload_images/images/bbds/banner-bat-dong-san-11.jpg");
        for(int i=0;i<arrayListAdv.size();i++){
            ImageView imageView=new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(arrayListAdv.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);

        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Context context;
        Animation animation_slide_in=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.silde_in_right);
        Animation animation_slide_out=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);

    }





}