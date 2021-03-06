package com.udacity.music;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.udacity.music.R;

import java.util.ArrayList;

public class AlbunsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> albuns = new ArrayList<Word>();

        albuns.add(new Word("The Best of Udacity Vol.1", R.drawable.album1));
        albuns.add(new Word("The Best of Udacity Vol.2", R.drawable.album1));
        albuns.add(new Word("The Best of Udacity Vol.3", R.drawable.album1));
        albuns.add(new Word("The Best of Udacity Vol.4", R.drawable.album1));

        ListView listView = (ListView) findViewById(R.id.word_list);

        // Getting Model of Header from XML
        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.instructions_header, listView, false);
        TextView makeHeader = (TextView) headerView.findViewById(R.id.text_listview_header);
        // Setting text on Header
        makeHeader.setText(getString(R.string.header_album));
        // Add header view to the ListView
        listView.addHeaderView(headerView);

        // Create PlayListAdapter object to display list view
        WordAdapter itemsAdapter = new WordAdapter(this, albuns);
        listView.setAdapter(itemsAdapter);

        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to PlaylistActivity
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }
}
