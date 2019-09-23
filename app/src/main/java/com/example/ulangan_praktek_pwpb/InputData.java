package com.example.ulangan_praktek_pwpb;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InputData extends AppCompatActivity {

    EditText edtJudul,edtDeskripsi;
    Button btn_Update;

    DatabaseReference databaseSiswa;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.input_data);
        getSupportActionBar().setTitle("Ubah");

        databaseSiswa = FirebaseDatabase.getInstance().getReference("siswa");

        edtJudul = (EditText) findViewById(R.id.edtTextJudul);
        edtDeskripsi = (EditText) findViewById(R.id.edtTxtDeskripsi);
        btn_Update = (Button) findViewById(R.id.btn_update);




        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSiswa();

            }
        });
    }

    public void addSiswa(){
        String judul = edtJudul.getText().toString().trim();
        String deskripsi = edtDeskripsi.getText().toString().trim();

        if (!TextUtils.isEmpty(judul)){
            String id = databaseSiswa.push().getKey();
            Siswa siswa = new Siswa(id, judul, deskripsi);
            databaseSiswa.child(id).setValue(siswa);

            Toast.makeText(this, "Siswa added",Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this, "You Should Enter your judul", Toast.LENGTH_SHORT).show();
        }
    }
}
