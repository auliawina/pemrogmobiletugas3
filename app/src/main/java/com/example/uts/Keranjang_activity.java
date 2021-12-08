package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.uts.model.produk;

import java.util.List;

public class Keranjang_activity extends AppCompatActivity {

    public final static String MASUKKAN_KERANJANG = "barang_obj_key";
    List<produk> produks;
    ListView listView;
    String jenisProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keranjang);
        Intent intent = getIntent();
        jenisProduk = intent.getStringExtra(MainActivity.Jenis_galeri_key);
        TextView textKeranjang = findViewById(R.id.tx_keranjang);
        textKeranjang.setText("Produk Starbuck "+jenisProduk.toUpperCase());
        produks = DataProvider.getProduksByTipe(this,jenisProduk);
        setupListView();

    }

    private void setupListView() {
        listView = findViewById(R.id.listview_barang);
        Barang_adapter adapter = new Barang_adapter(this,produks);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClick);
    }

    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            produk terpilih = produks.get(position);
            bukaproduk(terpilih);
        }
    };

    private  void bukaproduk(produk produkterpilih){
        Log.d("Main","produk Anda");
        Intent intent = new Intent(this, List_barang_activity.class);
        intent.putExtra(MASUKKAN_KERANJANG, produkterpilih);
        startActivity(intent);
    }

}