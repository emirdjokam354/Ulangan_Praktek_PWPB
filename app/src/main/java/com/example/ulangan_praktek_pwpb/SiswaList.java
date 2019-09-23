package com.example.ulangan_praktek_pwpb;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SiswaList extends ArrayAdapter {
    private Activity context;
    private List<Siswa> siswaList;

    public SiswaList(Activity context, List<Siswa> siswaList) {

        super(context, R.layout.list_view, siswaList);
        this.context = context;
        this.siswaList = siswaList;
    }

    @NonNull
    @Override
    public View getView(int position,@NonNull View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View ListViewItem = inflater.inflate(R.layout.list_view, null, true);
        TextView textViewJudul =ListViewItem.findViewById(R.id.textViewJudul);
        TextView textViewDeskripsi = ListViewItem.findViewById(R.id.textViewDeskripsi);

        Siswa siswa = siswaList.get(position);

        textViewJudul.setText(siswa.getSiswaJudul());
        textViewDeskripsi.setText(siswa.getSiswaDeskripsi());

        return ListViewItem;
    }
}
