package com.example.shaheed.schoolapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button contactBtn;
    Button galleryBtn;
    Button mediaBtn;
    Button writeupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactBtn = (Button) findViewById(R.id.contactBtn);
        galleryBtn = (Button) findViewById(R.id.galleryBtn);
        mediaBtn = (Button) findViewById(R.id.mediaBtn);
        writeupBtn = (Button) findViewById(R.id.writeupBtn);

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContactActivity.class));
            }
        });

        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GalleryActivity.class));
            }
        });

        mediaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MediaActivity.class));
            }
        });

        writeupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WriteupActivity.class));
            }
        });
    }
}
