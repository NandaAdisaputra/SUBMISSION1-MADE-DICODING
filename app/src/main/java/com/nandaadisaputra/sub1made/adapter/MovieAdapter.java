package com.nandaadisaputra.sub1made.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nandaadisaputra.sub1made.R;
import com.nandaadisaputra.sub1made.activity.DetailActivity;
import com.nandaadisaputra.sub1made.model.Movie;

import java.util.ArrayList;

//TODO 10. Buat Adapternya
public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movie;

    public MovieAdapter(Context context) {
        this.context = context;
        movie = new ArrayList<>();
    }

    public void setMovie(ArrayList<Movie> movie) {
        this.movie = movie;
    }

    @Override
    public int getCount() {
        return movie.size();
    }

    @Override
    public Object getItem(int i) {
        return movie.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        private ImageView iv_Gambar;
        private TextView tv_Judul, tv_Deskripsi, tv_Tanggal, tv_Genre;
        private View view;

        ViewHolder(View view) {
            iv_Gambar = view.findViewById(R.id.iv_gambar);
            tv_Judul = view.findViewById(R.id.tv_judul);
            tv_Deskripsi = view.findViewById(R.id.tv_deskripsi);
            tv_Tanggal = view.findViewById(R.id.tv_tanggalrilis);
            tv_Genre = view.findViewById(R.id.tv_genre);
            this.view = view;
        }

        void bind(final Movie movie) {
            iv_Gambar.setImageResource(movie.getGambar());
            tv_Judul.setText(movie.getJudul());
            tv_Deskripsi.setText(movie.getDeskripsi());
            tv_Tanggal.setText(movie.getTanggalRilis());
            tv_Genre.setText(movie.getGenre());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DetailActivity.class);
                    intent.putExtra("model", movie);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
