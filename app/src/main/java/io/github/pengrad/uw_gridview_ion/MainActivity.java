package io.github.pengrad.uw_gridview_ion;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.koushikdutta.ion.Ion;

import java.io.InputStreamReader;
import java.io.Reader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reader jsonReader = new InputStreamReader(getResources().openRawResource(R.raw.images));
        ImageSource[] images = new Gson().fromJson(jsonReader, ImageSource[].class);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this, images));
    }
}
