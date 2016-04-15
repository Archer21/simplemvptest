package com.archer.mvptest.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.archer.mvptest.R;
import com.archer.mvptest.domain.Song;
import com.archer.mvptest.mvp.presenter.MainActivityPresenter;
import com.archer.mvptest.mvp.viewmodel.MainActivityViewModel;
import com.archer.mvptest.view.adapter.SongAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityViewModel {

    @Bind(R.id.new_song_title)
    EditText editSongName;

    @Bind(R.id.list_container)
    RecyclerView list;

    SongAdapter adapter;

    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitConfiguration();
        presenter = new MainActivityPresenter(this, adapter);
    }

    private void setInitConfiguration(){
        ButterKnife.bind(this);
        adapter = new SongAdapter(MainActivity.this);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        setDummieContent();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(MainActivity.this, "Song Inserted to list", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAlert(String msg) {
        Toast.makeText(MainActivity.this, "Error Inserting song", Toast.LENGTH_SHORT).show();
    }

    public void setDummieContent(){
        ArrayList<Song> dummieSongs = new ArrayList<>();
        for (int i = 1; i <= 4 ; i++) {
            Song currentSong = new Song();
            currentSong.setTitle("Song " + i);
            dummieSongs.add(currentSong);
        }
        adapter.addAll(dummieSongs);
    }

    public void insertSong(View view){
        String msg = editSongName.getText().toString();
        presenter.newSong(msg);
    }
}
