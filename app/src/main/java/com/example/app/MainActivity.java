package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        // Create Integer Array
        Integer[] numberImages = {R.drawable.n1,R.drawable.n2,R.drawable.n3,R.drawable.n4,R.drawable.n5,
        R.drawable.n6,R.drawable.n7,R.drawable.n8,R.drawable.n9};

        // Create String Array
        String[] numberWords = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};

        mainModels = new ArrayList<>();
        for (int i=0;i<numberImages.length;i++){
            MainModel mainModel = new MainModel(numberImages[i],numberWords[i]);
            this.mainModels.add(mainModel);
        }

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(
                2,StaggeredGridLayoutManager.VERTICAL
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(MainActivity.this,mainModels);
        recyclerView.setAdapter(mainAdapter);
    }
}