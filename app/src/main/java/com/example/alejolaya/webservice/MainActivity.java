package com.example.alejolaya.webservice;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Firebase mRef;
    TextView texto;
    Button norte,sur,borrar;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        mRef=new Firebase("https://boiling-fire-6064.firebaseio.com/");
        texto= (TextView)findViewById(R.id.text);
        norte= (Button)findViewById(R.id.north);
        sur= (Button)findViewById(R.id.south);
        borrar= (Button)findViewById(R.id.delete);

        final Firebase ejemplo1=mRef.child("Condiciòn");

        ejemplo1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = (String) dataSnapshot.getValue();
                texto.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        norte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejemplo1.setValue("norte");
            }
        });
        sur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejemplo1.setValue("sur");
            }
        });
    }
}
