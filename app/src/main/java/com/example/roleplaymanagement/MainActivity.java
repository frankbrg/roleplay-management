package com.example.roleplaymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.roleplaymanagement.tests.Character;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Character character = new Character("fisty", 152);

        System.out.println(character);
    }
}