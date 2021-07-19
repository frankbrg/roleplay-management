package com.example.roleplaymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.roleplaymanagement.entity.Character;

import com.example.roleplaymanagement.recycler.CardCharacterViewAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements CardCharacterViewAdapter.ItemClickListener{

    CardCharacterViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_character);

        Character character = new Character("fisty", 152);

        System.out.println(character);

        setContentView(R.layout.activity_add_character);

        setContentView(R.layout.activity_main);

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

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvCharacters);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new CardCharacterViewAdapter(characters);
        adapter.setClickListener(this);
        //adapter.setEditClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, EditCharacterActivity.class);
        intent.putExtra("character",adapter.getItem(position));
        startActivity(intent);
    }

}