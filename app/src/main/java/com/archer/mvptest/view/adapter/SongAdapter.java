package com.archer.mvptest.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.mvptest.R;
import com.archer.mvptest.domain.Song;
import com.archer.mvptest.view.holder.SongViewHolder;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {

    private Context context;
    private ArrayList<Song> songList;

    public SongAdapter(Context context){
        this.context = context;
        songList     = new ArrayList<>();
    }

    /**
     * Overrides methods
     */

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_song_row, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        Song currentSong = songList.get(position);
        holder.setSongTitle(currentSong.getTitle());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    /**
     * Public adapter methods
     */

    public void addAll(ArrayList<Song> songs){
        songList = songs;
        notifyDataSetChanged();
    }

    public void addItem(Song song){
        songList.add(song);
        notifyDataSetChanged();
    }

    public void removeSong(Song song){
        songList.remove(song);
    }
}



























