package com.example.shaheed.schoolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ListView mlistView = (ListView) findViewById(R.id.listView);

        ArrayList<Card> list = new ArrayList<>();

        for (int i = 0; i < 200; i++){
            list.add(i, new Card("drawable://" + R.drawable.mbuntu1, "one"));
        }

        //list.add(new Card("drawable://" + R.drawable.mbuntu1, "one"));

        ListAdapter mCustomListAdapter = new CustomListAdapter(ContactActivity.this,
                R.layout.list_layout, list);

        mlistView.setAdapter(mCustomListAdapter);
    }
}