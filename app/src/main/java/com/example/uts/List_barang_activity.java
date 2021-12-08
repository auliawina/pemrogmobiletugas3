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

    List<produk> produks;
    int indexTampil = 0;
    String jenisProduk;
    Button home, balik, lanjut;
    TextView txnama, txdeskripsi, txwaktu, txrate, txharga, txkalori;
    ImageView ftproduk;
    LinearLayout addkeranjang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_barang);

        Intent intent = getIntent();
        jenisProduk = intent.getStringExtra(MainActivity.Jenis_galeri_key);
        produks = DataProvider.getProduksByTipe(this, jenisProduk);
        inisialisasiView();
        tampilkanProfil();
    }
    private void inisialisasiView() {
        home = findViewById(R.id.tombol_balik);
        balik = findViewById(R.id.kembali);
        lanjut = findViewById(R.id.lanjut);
        addkeranjang = findViewById(R.id.tambah_keranjang);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_barang_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        addkeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_barang_activity.this, Keranjang_activity.class);
                startActivity(intent);
            }
        });

        balik.setOnClickListener(view -> produksebelumnya());
        lanjut.setOnClickListener(view -> produkselanjutnya());

        txnama = findViewById(R.id.nama);
        txwaktu = findViewById(R.id.waktu);
        txrate = findViewById(R.id.rate);
        txkalori = findViewById(R.id.kalori);
        txdeskripsi = findViewById(R.id.deskripsi);
        txharga = findViewById(R.id.harga);
        ftproduk = findViewById(R.id.starbuck);
    }
    private void tampilkanProfil () {
        produk p = produks.get(indexTampil);

        txnama.setText(p.getNama());
        txwaktu.setText(p.getWaktu());
        txrate.setText(p.getRate());
        txkalori.setText(p.getKalori());
        txdeskripsi.setText(p.getDeskripsi());
        txharga.setText(p.getHarga());
        ftproduk.setImageDrawable(this.getDrawable(p.getDrawable()));
    }
    private void produkselanjutnya() {
        if (indexTampil == produks.size() - 1) {
            Toast.makeText(this,"terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indexTampil++;
            tampilkanProfil();
        }
    }

    private void produksebelumnya() {
        if (indexTampil == 0) {
            Toast.makeText(this,"awal",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indexTampil--;
            tampilkanProfil();
        }
    }
}