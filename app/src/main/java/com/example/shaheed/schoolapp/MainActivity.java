package com.example.shaheed.schoolapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    ContactClass[] contactArray;
    int[] imagesArray;
    String response = null;
    String line;
    JSONObject jsonObject;
    ContactClass mcontactClass;
    StringBuilder jsonBuilder;
    JSONObject mJsonObject;
    int i;
    JSONArray mJsonArray;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mListView = (ListView) findViewById(R.id.mListView);

        try {
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.datajson)));
            jsonBuilder = new StringBuilder();
            for (line = null;
                 (line = jsonReader.readLine()) != null;) {
                jsonBuilder.append(line).append("\n");
            }
            response = jsonBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            mJsonObject = new JSONObject(response);
            mJsonArray = mJsonObject.getJSONArray("Contacts");
            contactArray = new ContactClass[mJsonArray.length()];

            imagesArray = new int[]{
                    R.drawable.mbuntu0,
                    R.drawable.mbuntu1,
                    R.drawable.mbuntu2,
                    R.drawable.mbuntu3,
                    R.drawable.mbuntu5,
                    R.drawable.mbuntu6,
                    R.drawable.mbuntu7,
                    R.drawable.mbuntu8,
                    R.drawable.mbuntu9,
                    R.drawable.mbuntu10,
                    R.drawable.mbuntu11,
                    R.drawable.mbuntu12
            };

            for (i = 0; i < mJsonArray.length(); i++) {
                jsonObject = mJsonArray.getJSONObject(i);

                mcontactClass = new ContactClass();
                mcontactClass.setName(jsonObject.getString("name"));
                mcontactClass.setPhoneNumber(jsonObject.getString("phone"));
                mcontactClass.setId(Integer.valueOf(jsonObject.getString("id")));
                mcontactClass.setWords(jsonObject.getString("partingWord"));

                contactArray[i] = mcontactClass;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapter mCustomAdapter = new CustomAdapter() {
            @Override
            public int getCount() {
                return contactArray.length;
            }

            @Override
            public Object getItem(int position) {
                return contactArray[position];
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }
        };

        mListView.setAdapter(mCustomAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(MainActivity.this, ContactDetail.class);

                mIntent.putExtra("avatar", imagesArray[position]);
                mIntent.putExtra("name", contactArray[position].Name);
                mIntent.putExtra("word", contactArray[position].word);

                startActivity(mIntent);
            }
        });
    }

        public abstract class CustomAdapter extends BaseAdapter {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.listview_layout, parent,
                        false);

                ContactClass contactClass = (ContactClass) getItem(position);
                ((TextView) convertView.findViewById(R.id.nameTextView)).
                        setText(contactClass.getName());

                        Picasso.with(MainActivity.this)
                                .load(imagesArray[Integer.valueOf(contactClass.getId())])
                                .resize(90, 90)
                                .centerCrop()
                                .placeholder(R.mipmap.ic_launcher)
                                .error(R.mipmap.ic_launcher_round)
                                .into(((ImageView) convertView.findViewById(R.id.mImageView)));

                ((TextView) convertView.findViewById(R.id.phoneTextView)).
                        setText(contactClass.getPhoneNumber());
            }
            return convertView;
        }
    }
}