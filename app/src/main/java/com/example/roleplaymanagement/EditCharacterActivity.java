package com.example.roleplaymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.roleplaymanagement.entity.Character;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class EditCharacterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_character);

        Intent intent = getIntent();
        Character character= (Character)getIntent().getSerializableExtra("character");
        TextInputEditText characterName = findViewById(R.id.characterName);
        characterName.setText(character.getName());
        EditText itemWeight = findViewById(R.id.itemWeight);

        itemWeight.setText(String.valueOf(character.getInventorySize()));

    }
}