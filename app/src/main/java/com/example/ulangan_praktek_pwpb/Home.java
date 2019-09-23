package com.example.ulangan_praktek_pwpb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity  {
    ImageButton tambah;

    DatabaseReference databaseSiswa;
    ListView listViewSiswa;
    List<Siswa> siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_activtiy);
        getSupportActionBar().setTitle("Notes");

        databaseSiswa = FirebaseDatabase.getInstance().getReference("siswa");


        tambah = (ImageButton) findViewById(R.id.btn_tambah);
        listViewSiswa = (ListView)findViewById(R.id.listView);

        siswaList = new ArrayList<>();

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(getApplicationContext(), InputData.class);
                startActivity(pindah);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();

        databaseSiswa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                siswaList.clear();

                for (DataSnapshot siswaSnapshot : dataSnapshot.getChildren()){
                    Siswa siswa = siswaSnapshot.getValue(Siswa.class);
                    siswaList.add(siswa);
                }
                SiswaList adapter = new SiswaList(Home.this, siswaList);
                listViewSiswa.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
