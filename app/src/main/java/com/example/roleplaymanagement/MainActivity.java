package com.example.roleplaymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.Context;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import com.example.roleplaymanagement.entity.Character;

import com.example.roleplaymanagement.recycler.CardCharacterViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ArrayList<Character> characters;


    CardCharacterViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setContentView(R.layout.activity_edit_character);

       /* button = (Button) findViewById(R.id.floatingActionButton);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openActivity_add_character();
            }
        });*/

        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        System.out.println(button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityAddCharacter.class);
                startActivity(intent);
                        }
        });

        String json = readFromFile(MainActivity.this);

        Type gsonCharacters = new TypeToken<List<Character>>(){}.getType();
        characters = new Gson().fromJson(json, gsonCharacters);
        System.out.println(characters);
        //setContentView(R.layout.activity_add_character);


        // data to populate the RecyclerView with
        /*characters = new ArrayList<>();
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
        */

        //Lire le Json
        //fromString() --> ArrayList<Character>
        //définir Cha
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvCharacters);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new CardCharacterViewAdapter(characters);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStop(){
        super.onStop();

        String json = new Gson().toJson(characters);
        writeToFile(json, MainActivity.this);
        System.out.println(json);


    }

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

}

