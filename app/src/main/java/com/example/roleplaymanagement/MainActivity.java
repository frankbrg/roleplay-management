package com.example.roleplaymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.roleplaymanagement.entity.Character;

import com.example.roleplaymanagement.recycler.CardCharacterViewAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    CardCharacterViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_character);

        Character character = new Character(0,"fisty", 152);

        System.out.println(character);

        setContentView(R.layout.activity_add_character);

        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<Character> characters = new ArrayList<>();
        characters.add(new Character(1,"Gandalf", 40));
        characters.add(new Character(2,"Dylan", 10));
        characters.add(new Character(3,"Florian", 17));
        characters.add(new Character(4,"Frank", 14));
        characters.add(new Character(5,"Gandalf", 40));
        characters.add(new Character(6,"Dylan", 10));
        characters.add(new Character(7,"Florian", 17));
        characters.add(new Character(8,"Frank", 14));
        characters.add(new Character(9,"Gandalf", 40));
        characters.add(new Character(10,"Dylan", 10));
        characters.add(new Character(11,"Florian", 17));
        characters.add(new Character(12,"Frank", 14));
        characters.add(new Character(13,"Gandalf", 40));
        characters.add(new Character(14,"Dylan", 10));
        characters.add(new Character(15,"Florian", 17));
        characters.add(new Character(16,"Frank", 14));

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvCharacters);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new CardCharacterViewAdapter(characters);
        recyclerView.setAdapter(adapter);
    }

}