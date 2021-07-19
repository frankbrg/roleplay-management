package com.example.roleplaymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.roleplaymanagement.entity.Character;

import com.example.roleplaymanagement.entity.Item;
import com.example.roleplaymanagement.recycler.CardCharacterViewAdapter;
import com.example.roleplaymanagement.recycler.CardItemViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button;


    CardItemViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        //setContentView(R.layout.activity_edit_character);

       /* button = (Button) findViewById(R.id.floatingActionButton);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openActivity_add_character();
            }
        });*/


        //setContentView(R.layout.activity_add_character);


        // data to populate the RecyclerView with
        ArrayList<Character> characters = new ArrayList<>();
        characters.add(new Character("Gandalf", 40));
        characters.add(new Character("Dylan", 10));
        characters.add(new Character("Florian", 17));
        characters.add(new Character("Frank", 14));
        characters.add(new Character("Gandalf", 40));
        characters.add(new Character("Dylan", 10));
        characters.add(new Character("Florian", 17));
        characters.add(new Character("Frank", 14));
        characters.add(new Character("Gandalf", 40));
        characters.add(new Character("Dylan", 10));
        characters.add(new Character("Florian", 17));
        characters.add(new Character("Frank", 14));
        characters.add(new Character("Gandalf", 40));
        characters.add(new Character("Dylan", 10));
        characters.add(new Character("Florian", 17));
        characters.add(new Character("Frank", 14));


        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));
        items.add(new Item("Sword", 7));

        characters.get(0).setItems(
                items
        );

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvItems);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new CardItemViewAdapter(items);
        recyclerView.setAdapter(adapter);
    }

}