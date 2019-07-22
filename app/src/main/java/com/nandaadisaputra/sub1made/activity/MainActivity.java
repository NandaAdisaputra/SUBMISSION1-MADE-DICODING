package com.nandaadisaputra.sub1made.activity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nandaadisaputra.sub1made.R;
import com.nandaadisaputra.sub1made.adapter.MovieAdapter;
import com.nandaadisaputra.sub1made.model.Movie;

import java.util.ArrayList;

//TODO 11. atur MainActivity
public class MainActivity extends AppCompatActivity {
    //deklarasi dan inisialisasi tipe data nya
    private TypedArray dataGambar;
    private String[] dataJudul;
    private String[] dataDeskripsi;
    private String[] dataTanggal;
    private String[] dataGenre;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        //deklarasi dan inisialisasi id listview
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        prepare();
        addItem();
    }

    private void addItem() {
        //array
        ArrayList<Movie> nmovie = new ArrayList<>();

        for (int i = 0; i < dataJudul.length; i++) {
            Movie movie = new Movie();
            movie.setGambar(dataGambar.getResourceId(i, -1));
            movie.setJudul(dataJudul[i]);
            movie.setDeskripsi(dataDeskripsi[i]);
            movie.setTanggalRilis(dataTanggal[i]);
            movie.setGenre(dataGenre[i]);
            nmovie.add(movie);
        }
        adapter.setMovie(nmovie);
    }

    //get data
    private void prepare() {
        dataGambar = getResources().obtainTypedArray(R.array.data_gambar);
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        dataTanggal = getResources().getStringArray(R.array.data_tanggalrilis);
        dataGenre = getResources().getStringArray(R.array.data_genre);

    }
}
