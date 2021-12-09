package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uts.model.produk;
import java.util.List;

public class List_barang_activity extends AppCompatActivity {

    produk produks;
    Button home;
    TextView txnama, txdeskripsi, txwaktu, txrate, txharga, txkalori;
    ImageView ftproduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_barang);

        Intent intent = getIntent();
        produks = (produk) intent.getSerializableExtra(Keranjang_activity.MASUKKAN_KERANJANG);
        inisialisasiView();
        tampilkanProfil(produks);
    }

    private void tampilkanProfil(produk produks) {
        Log.d("List","List Barang"+produks.getNama());
        txnama.setText(produks.getNama());
        txwaktu.setText(produks.getWaktu());
        txrate.setText(produks.getRate());
        txkalori.setText(produks.getKalori());
        txdeskripsi.setText(produks.getDeskripsi());
        txharga.setText(produks.getHarga());
        ftproduk.setImageDrawable(this.getDrawable(produks.getDrawable()));
    }

    private void inisialisasiView() {
        home = findViewById(R.id.tombol_balik);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_barang_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        txnama = findViewById(R.id.nama);
        txwaktu = findViewById(R.id.waktu);
        txrate = findViewById(R.id.rate);
        txkalori = findViewById(R.id.kalori);
        txdeskripsi = findViewById(R.id.deskripsi);
        txharga = findViewById(R.id.harga);
        ftproduk = findViewById(R.id.starbuck);
    }
}