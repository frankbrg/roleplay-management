package com.example.roleplaymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Button;

import com.example.roleplaymanagement.entity.Character;

import com.example.roleplaymanagement.entity.Item;
import com.example.roleplaymanagement.recycler.CardCharacterViewAdapter;
import com.example.roleplaymanagement.recycler.CardItemViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements CardCharacterViewAdapter.ItemClickListener{

    private Button button;

    ArrayList<Character> characters = new ArrayList<>();
    CardCharacterViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton button = findViewById(R.id.floatingActionButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityAddCharacter.class);
                startActivity(intent);
                        }
        });

        // data to populate the RecyclerView with

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
        RecyclerView recyclerView = findViewById(R.id.rvCharacters);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        //adapter = new CardItemViewAdapter(items);

        adapter = new CardCharacterViewAdapter(characters);
        adapter.setClickListener(this);
        //adapter.setEditClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, EditCharacterActivity.class);
        intent.putExtra("character",adapter.getItem(position));
        intent.putExtra("position",position);
        startActivityForResult(intent, 1);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                if(data.getBooleanExtra("delete", false)==true) {
                    characters.remove(data.getIntExtra("position", 0));
                    adapter.notifyDataSetChanged();
                }
                else{
                    Character character = (Character) data.getSerializableExtra("character");
                    int position = data.getIntExtra("position", 0);
                    characters.get(position).setName(character.getName());
                    characters.get(position).setInventorySize(character.getInventorySize());
                    adapter.notifyDataSetChanged();

                }

            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }

}