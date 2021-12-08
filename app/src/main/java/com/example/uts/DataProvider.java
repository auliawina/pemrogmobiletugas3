package com.example.uts;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.example.uts.model.makanan;
import com.example.uts.model.minuman;
import com.example.uts.model.produk;
import com.example.uts.model.tumblr;

public class DataProvider {
    private static List<produk> produks = new ArrayList<>();

    private static List<minuman> dataminuman (Context ctx){
        List<minuman> list_minuman = new ArrayList<>();
        list_minuman.add(new minuman("Caramel Java Chip Frappucino","10 menit","4.1","100kal",
                "Espresso with bittersweet mocha sauce and steamed milk, topped with " +
                        "sweetened whipped cream.Delightful.","Rp.55.000",R.drawable.es1));
        list_minuman.add(new minuman("Java Chip Frappucino","15 menit","5.0","150kal",
                "Two fresh shots of espresso, hand shaken with classic syrup and ice, " +
                        "finished with low fat milkmixed with sweetened whipped cream.","Rp.57.000",R.drawable.es2));
        list_minuman.add(new minuman("Chocolate Chip Frappucino","10 menit","4.1","200kal",
                "ASlightly sweetened ice-cold espresso, poured through a distinct layer " +
                        "of surprisingly creamy nonfat milk cold foam.","Rp.51.000",R.drawable.es3));
        return list_minuman;
    }

    private static List<makanan> datamakanan (Context ctx){
        List<makanan> list_makanans = new ArrayList<>();
        list_makanans.add(new makanan("Cheese Chip Waffel","20 menit","5.0","500kal","A classic dutch cookie " +
                "made from Caramel","Rp.12.000",R.drawable.makanan1));
        list_makanans.add(new makanan("Caramel Stroop Waffel","20 menit","4.1","550kal","Engery booster " +
                "cookie made from Raisin & Oats","Rp.10.000",R.drawable.makanan2));
        list_makanans.add(new makanan("Chocolate Stroop Waffel","15 menit","3.7","600kal","A classic " +
                "dutch cookie made from Caramel & Chocolate","Rp.20.000",R.drawable.makanan3));
        return list_makanans;
    }

    private static List<tumblr> datatumblr (Context ctx){
        List<tumblr> list_tumblrs = new ArrayList<>();
        list_tumblrs.add(new tumblr("Reuseable WTR Bottle","-","5.0","-","Get our cold drinkware to " +
                "keep your beverages frosty all day long","Rp.100.000",R.drawable.produk1));
        list_tumblrs.add(new tumblr("Cold Cup CPPER","-","4.1","-","Our machines take pressing " +
                "coffee to another level....check them out here","Rp.180.000",R.drawable.produk2));
        list_tumblrs.add(new tumblr("Tumbler Badge Siren Black","-","4.5","-","We have the perfect " +
                "drinkware sizes that will fulfill all your coffee requirements","Rp.170.000",R.drawable.produk3));
        return list_tumblrs;
    }
    private static void allproduk (Context ctx) {
        produks.addAll(dataminuman(ctx));
        produks.addAll(datamakanan(ctx));
        produks.addAll(datatumblr(ctx));
    }
    public static List<produk> getAllProduk(Context ctx) {
        if (produks.size() == 0) {
            allproduk(ctx);
        }
        return produks;
    }
    public static List<produk> getProduksByTipe (Context ctx, String jenis) {
        List<produk> produksByTipe = new ArrayList<>();
        if (produks.size() == 0) {
            allproduk(ctx);
        }
        for (produk p : produks) {
            if (p.getJenis().equals(jenis)) {
                produksByTipe.add(p);
            }
        }
        return produksByTipe;
    }

}