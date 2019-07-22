package com.nandaadisaputra.sub1made.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nandaadisaputra.sub1made.R;
import com.nandaadisaputra.sub1made.model.Movie;

public class DetailActivity extends AppCompatActivity {
    //TODO 12. buat Detail_Activitynya dan dikasih sedikit logic
    Movie movie;
    //deklarasikan variabel nya dan viewnya
    private TextView tvJudul;
    private ImageView ivGambar;
    private TextView tvDeskripsi;
    private TextView tvTanggalrilis;
    private TextView tvGenre;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        movie = getIntent().getParcelableExtra("model");
        //set data
        assert movie != null;
        tvJudul.setText("" + movie.getJudul());
        tvDeskripsi.setText("" + movie.getDeskripsi());
        tvTanggalrilis.setText("" + movie.getTanggalRilis());
        tvGenre.setText("" + movie.getGenre());
        ivGambar.setImageResource(Integer.parseInt("" + movie.getGambar()));

    }

    private void initView() {
        tvJudul = findViewById(R.id.tv_judul);
        ivGambar = findViewById(R.id.iv_gambar);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);
        tvTanggalrilis = findViewById(R.id.tv_tanggalrilis);
        tvGenre = findViewById(R.id.tv_genre);
    }
}
