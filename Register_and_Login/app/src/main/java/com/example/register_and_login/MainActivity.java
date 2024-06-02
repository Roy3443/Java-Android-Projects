package com.example.register_and_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PLace_data[] pLace_data=new PLace_data[]{
                new PLace_data("Taj Mahal","India",R.drawable.download),
                new PLace_data("Great wall of China","China",R.drawable.img),
                new PLace_data("Eiffel Tower","Paris",R.drawable.img_1),
                new PLace_data("Mangalore","India",R.drawable.img_2),
                new PLace_data("Red Fort","India",R.drawable.img_3),
                new PLace_data("Grand Canyon","USA",R.drawable.img_4),
                new PLace_data("Mangalore","India",R.drawable.img_5),
                new PLace_data("Pyramids","Egypt",R.drawable.img_6),
                new PLace_data("Gateway of India","India",R.drawable.img_7),
                new PLace_data("Hawa Mahal","India",R.drawable.img_8),



        };
        MyPlaceAdapter myPlaceAdapter=new MyPlaceAdapter(pLace_data,MainActivity.this);
        recyclerView.setAdapter(myPlaceAdapter);
    }
}