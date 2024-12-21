package com.example.brightwave;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brightwave.Adapter.ToDoAdapter;
import com.example.brightwave.Model.ToDoModel;
import com.example.brightwave.Utils.DataBaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Todo_list extends AppCompatActivity implements  OnDialogClosetListener{

    private RecyclerView mRecycleeview;
    private FloatingActionButton fab;
    private DataBaseHelper myDB;
    private List<ToDoModel> mList;
    private ToDoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_todo_list);

        mRecycleeview = findViewById(R.id.recycleview);
        fab = findViewById(R.id.fab);
        myDB = new DataBaseHelper(Todo_list.this);
        mList = new ArrayList<>();
        adapter = new ToDoAdapter(myDB , Todo_list.this);

        mRecycleeview.setHasFixedSize(true);
        mRecycleeview.setLayoutManager(new LinearLayoutManager(this));
        mRecycleeview.setAdapter(adapter);

        mList = myDB.getAllTask();
        Collections.reverse(mList);
        adapter.setTasks(mList);

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });
        ItemTouchHelper itemTouchHelper;
        itemTouchHelper = new ItemTouchHelper(new RecyclerViewTouchHelper(adapter));
        itemTouchHelper.attachToRecyclerView(mRecycleeview);
    }



    @Override
    public void onDialogClose(DialogInterface dialogInterface) {

    }
}
