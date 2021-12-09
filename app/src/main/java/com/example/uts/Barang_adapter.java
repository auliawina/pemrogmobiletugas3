package com.example.uts;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uts.model.produk;

import java.util.List;

public class Barang_adapter extends ArrayAdapter<produk> {

    public final static String MASUKKAN_KERANJANG = "barang_obj_key";
    Context context;
    private RecyclerView.ViewHolder viewHolder;

    public Barang_adapter (Context context, List<produk> produks){
        super(context, R.layout.row_item_keranjang,produks);
        this.context = context;
    }
    private static class Viewholder {
        ImageView barang;
        TextView txbarang;
        TextView txharga;
        LinearLayout button;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
    produk produks = getItem(position);
    Viewholder viewholder;

    if (convertView == null){
        viewholder = new Viewholder();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.row_item_keranjang,parent,false);
        viewholder.barang = convertView.findViewById(R.id.barang);
        viewholder.txbarang = convertView.findViewById(R.id.namabarang);
        viewholder.barang.setOnClickListener(view -> {
            Intent intent = new Intent(context.getApplicationContext(), List_barang_activity.class);
            intent.putExtra(MASUKKAN_KERANJANG, produks);
            context.startActivity(intent);
        });
        viewholder.txharga = convertView.findViewById(R.id.hargabarang);
        viewholder.button = convertView.findViewById(R.id.button);
        convertView.setTag(viewholder);
    }
        else {
            viewholder = (Viewholder) convertView.getTag();
        }

    viewholder.barang.setImageDrawable(context.getDrawable(produks.getDrawable()));
    viewholder.txbarang.setText(produks.getNama());
    viewholder.txharga.setText(produks.getHarga());
        return convertView;
    }

}
