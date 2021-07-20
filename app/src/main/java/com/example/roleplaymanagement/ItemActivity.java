package com.example.roleplaymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roleplaymanagement.entity.Character;
import com.example.roleplaymanagement.recycler.CardCharacterViewAdapter;
import com.example.roleplaymanagement.recycler.CardItemViewAdapter;
import com.google.android.material.textfield.TextInputEditText;

public class ItemActivity extends AppCompatActivity {

    CardItemViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_item);

        Intent intent = getIntent();
        Character character = (Character)getIntent().getSerializableExtra("character");
        TextView inventoryLabel = findViewById(R.id.inventoryLabel);
        inventoryLabel.setText(character.getName()+" : ");

        TextView inventory = findViewById(R.id.inventory);
        inventory.setText(character.getInventoryUsedSize()+" / "+character.getInventorySize());

        RecyclerView recyclerView = findViewById(R.id.rvItems);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new CardItemViewAdapter(character.getItems());
        recyclerView.setAdapter(adapter);
    }
}