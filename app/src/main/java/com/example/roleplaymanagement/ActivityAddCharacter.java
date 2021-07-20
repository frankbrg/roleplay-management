package com.example.roleplaymanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roleplaymanagement.R;
import com.example.roleplaymanagement.entity.Character;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityAddCharacter extends AppCompatActivity {

    public ActivityAddCharacter(){
        super();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_character);

        Button addCharacter = findViewById(R.id.button_create_character);
        TextInputEditText nameCharacter = findViewById(R.id.name_character);
        TextInputEditText inventorySizeCharacter = findViewById(R.id.inventory_size_character);


        addCharacter.setOnClickListener(new View.OnClickListener() {
                                             public void onClick(View v) {
                                                 String name = nameCharacter.getText().toString();
                                                 int weight = Integer.parseInt(inventorySizeCharacter.getText().toString());
                                                 Character character1 = new Character(name, weight);
                                                 Intent intent = new Intent();
                                                 intent.putExtra("character",character1);
                                                 setResult(Activity.RESULT_OK,intent);
                                                 finish();
                                             }
                                         }
        );
    }
}
