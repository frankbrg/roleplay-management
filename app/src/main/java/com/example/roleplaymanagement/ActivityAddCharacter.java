package com.example.roleplaymanagement;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roleplaymanagement.R;

public class ActivityAddCharacter extends AppCompatActivity {

    public ActivityAddCharacter(){
        super();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_character);
    }
}
