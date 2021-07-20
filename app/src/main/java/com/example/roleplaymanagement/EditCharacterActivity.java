package com.example.roleplaymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roleplaymanagement.entity.Character;
import com.example.roleplaymanagement.recycler.CardCharacterViewAdapter;
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
        Button editCharacter = findViewById(R.id.editCharacter);


        editCharacter.setOnClickListener(new View.OnClickListener() {
                                             public void onClick(View v) {
                                                 String name = characterName.getText().toString();
                                                 int weight = Integer.parseInt(itemWeight.getText().toString());
                                                 Character character1 = new Character(name, weight);
                                                 Intent intent = new Intent();
                                                 intent.putExtra("character",character1);
                                                 intent.putExtra("position",getIntent().getIntExtra("position", 0));
                                                 setResult(Activity.RESULT_OK,intent);
                                                 finish();
                                             }
                                         }
        );
        Button deleteCharacter = findViewById(R.id.deleteCharacter);
        deleteCharacter.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                             public void onClick(View v) {
                                                 Toast.makeText(EditCharacterActivity.this,"test",Toast.LENGTH_SHORT).show();
                                                 String name = characterName.getText().toString();
                                                 int weight = Integer.parseInt(itemWeight.getText().toString());
                                                 Character character1 = new Character(name, weight);
                                                 Intent intent = new Intent();
                                                 intent.putExtra("delete",true);
                                                 intent.putExtra("position",getIntent().getIntExtra("position", 0));
                                                 setResult(Activity.RESULT_OK,intent);
                                                finish();
                                            }
                                         }
        );
    }
}