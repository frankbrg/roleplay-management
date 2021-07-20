package com.example.roleplaymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roleplaymanagement.entity.Character;
import com.example.roleplaymanagement.entity.Item;

public class AddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_item);

        Button addItem = findViewById(R.id.button_create_object);
        EditText nameObject = findViewById(R.id.name_object);
        EditText sizeObject = findViewById(R.id.size_object);


        addItem.setOnClickListener(new View.OnClickListener() {
                                             public void onClick(View v) {
                                                 String name = nameObject.getText().toString();
                                                 int weight = Integer.parseInt(sizeObject.getText().toString());
                                                 Item item = new Item(name, weight);
                                                 Intent intent = new Intent();
                                                 intent.putExtra("item",item);
                                                 intent.putExtra("position",getIntent().getIntExtra("position", 0));
                                                 setResult(Activity.RESULT_OK,intent);
                                                 finish();
                                             }
                                         }
        );

    }
}