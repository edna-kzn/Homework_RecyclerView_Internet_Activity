package com.kazarian.android.homework_recyclerview_internet_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.google.gson.Gson;
import com.kazarian.android.homework_recyclerview_internet_activity.homework_recyclerview_internet_activity_Gsonfiles_cars.PouyaheydariCars;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> myType, myimg_Link;
    ArrayList<Double> myLat, myLng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String myUrl = "https://pouyaheydari.com/vehicles.json";
        AsyncHttpClient client = new AsyncHttpClient();


        client.get(myUrl, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                System.out.println("edna1 = " + response.toString());

                Gson gson = new Gson();
                PouyaheydariCars carslist = gson.fromJson(response.toString(), PouyaheydariCars.class);

                myType = new ArrayList<>();
                myLat = new ArrayList<>();
                myLng = new ArrayList<>();
                myimg_Link = new ArrayList<>();

                //ArrayList CarLists = new ArrayList();

                for (int i=0; i<carslist.getVehicles().size(); i++){
                    myType.add(carslist.getVehicles().get(i).getType());
                    myLng.add(carslist.getVehicles().get(i).getLng());
                    myLat.add(carslist.getVehicles().get(i).getLat());
                    myimg_Link.add(carslist.getVehicles().get(i).getImageUrl());

                    System.out.println("ednatype" + i +" = " + myType.get(i).toString() );
                    //CarLists.add(carslist.getVehicles().toString());
                    //System.out.println("texte ma"+ CarLists.get(i).toString());
                    //System.out.println("texte to"+ myvehicle.getType());
                }


                RecyclerView myrecycler = findViewById(R.id.recycler);

                LinearLayoutManager mymanager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                myrecycler.setLayoutManager(mymanager);

                CarAdapter myadapter = new CarAdapter(myType, myLng, myLat, myimg_Link);  //<----- esme list araye ra bayad pas bedim
                myrecycler.setAdapter(myadapter);

            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

        //fetching data
        //ArrayList<String> mycarlist = new ArrayList<>();
        //mycarlist.add("pride");
        //mycarlist.add("BMW");

    }
}