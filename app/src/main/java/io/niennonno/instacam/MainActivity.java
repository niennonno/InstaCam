package io.niennonno.instacam;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 10;
    private static final String TAG = "MainActivity";
    private File mPhoto;
    private FeedFragment mFeedFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //FrameLayout frameLayout = (FrameLayout)findViewById(R.id.feed_container);
        //mFeedFragment = getFragmentManager().findFragmentById()


        mFeedFragment = (FeedFragment) getFragmentManager().findFragmentById(R.id.feed_container);
        if (mFeedFragment == null){
            mFeedFragment = new FeedFragment();


            getFragmentManager().beginTransaction()
                    .add(R.id.feed_container, mFeedFragment)
                    .commit();
        }

    }

    public void onClick(View v) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        mPhoto = new File(directory, "sample.jpeg");
        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mPhoto));


        startActivityForResult(i, CAMERA_REQUEST);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
