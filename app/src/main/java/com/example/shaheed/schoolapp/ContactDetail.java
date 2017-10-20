package com.example.shaheed.schoolapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ContactDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Intent intent = getIntent();
        String contactName = intent.getStringExtra("name");
        TextView nameTextView = (TextView)findViewById(R.id.detailName);
        nameTextView.setText(contactName);

        String contactImage = intent.getStringExtra("avatar");
        ImageView contactImageView = (ImageView) findViewById(R.id.detailImage);
        Picasso.with(getApplicationContext())
                .load(contactImage)
                .resize(50, 50)
                .into(contactImageView);

        String contactWord = intent.getStringExtra("word");
        TextView wordTextView = (TextView) findViewById(R.id.textWord);
        wordTextView.setText(contactWord);

    }
}
