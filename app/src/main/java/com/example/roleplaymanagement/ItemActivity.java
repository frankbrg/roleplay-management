package com.example.roleplaymanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roleplaymanagement.entity.Character;
import com.example.roleplaymanagement.entity.Item;
import com.example.roleplaymanagement.recycler.CardCharacterViewAdapter;
import com.example.roleplaymanagement.recycler.CardItemViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class ItemActivity extends AppCompatActivity {

    CardItemViewAdapter adapter;

    TextView inventory;
    Character character;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_list_item);

        intent = getIntent();
        character = (Character)getIntent().getSerializableExtra("character");
        TextView inventoryLabel = findViewById(R.id.inventoryLabel);
        inventoryLabel.setText(character.getName()+" : ");
        inventory = findViewById(R.id.inventory);

        inventory.setText(character.getInventoryUsedSize()+" / "+character.getInventorySize());

        RecyclerView recyclerView = findViewById(R.id.rvItems);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new CardItemViewAdapter(character.getItems());
        recyclerView.setAdapter(adapter);

        FloatingActionButton button = findViewById(R.id.floatingActionButtonAddItem);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ItemActivity.this, AddItem.class);
                intent.putExtra("position", adapter.getPosition());

                startActivityForResult(intent, 3);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 3) {
            if(resultCode == Activity.RESULT_OK){

                Item item1 = (Item)data.getSerializableExtra("item");
                if( character.getInventoryUsedSize()+item1.getWeight() <= character.getInventorySize()) {
                    adapter.getItem().add(item1);
                    inventory.setText(character.getInventoryUsedSize() + " / " + character.getInventorySize());
                    adapter.notifyDataSetChanged();
                    intent.putExtra("position",adapter.getPosition());
                    intent.putExtra("inventory",adapter.getItem());

                    setResult(12);
                }
                else{
                    Toast.makeText(getApplication().getBaseContext(),"Objet trop lourd",Toast.LENGTH_SHORT);
                }


                }

            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }


    }
}