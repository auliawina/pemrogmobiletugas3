package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
        ImageView btnprofile, btnminuman, btnmakanan, btnproduk;
    public static final String Jenis_galeri_key= "jenis_galeri";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
    }
    private void inisialisasiView(){

        btnprofile = findViewById(R.id.buka_profil);
        btnminuman = findViewById(R.id.list_minuman);
        btnmakanan = findViewById(R.id.list_makanan);
        btnproduk = findViewById(R.id.list_produk);


        btnminuman.setOnClickListener(view -> bukalist("minuman"));
        btnmakanan.setOnClickListener(view -> bukalist("makanan"));
        btnproduk.setOnClickListener(view -> bukalist("tumblr"));
        btnprofile.setOnClickListener(view -> bukaProfilActivity());
    }

    private  void bukaProfilActivity() {
        Log.d("MAIN","Buka activity profile");
        Intent intent = new Intent(this,Profile_activity.class);
        startActivity(intent);
    }
    private void bukalist(String jenisproduk) {
        Log.d("MAIN","Buka activity ");
        Intent intent = new Intent(this, Keranjang_activity.class);
        intent.putExtra(Jenis_galeri_key, jenisproduk);
        startActivity(intent);
    }
}