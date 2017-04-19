package com.app.loader.sms;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.app.loader.R;

public class SmsActivity extends AppCompatActivity {

    private int loaderId = 0 ;
    private ListView lv;
    private SimpleCursorAdapter adapter;
    private LoaderManager.LoaderCallbacks loaderCallbacks ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms );

        lv = (ListView) findViewById( R.id.listview );

        adapter = new SimpleCursorAdapter(this,
                R.layout.sms_listview_item ,
                null,
                new String[]{"address","body"},
                new int[]{R.id.address, R.id.body},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        lv.setAdapter(adapter);

        loaderCallbacks = new MyCallback() ;
        getLoaderManager().initLoader( loaderId , null,  loaderCallbacks );

        //开始查询
        Bundle bundle = new Bundle();
        bundle.putString("key", "小");
        getLoaderManager().restartLoader(1, bundle, loaderCallbacks  );

    }

    class MyCallback implements LoaderManager.LoaderCallbacks<Cursor> {

        @Override
        public Loader onCreateLoader(int id, Bundle args) {
            SmsLoader loader = new SmsLoader( SmsActivity.this , args);
            return loader ;
        }



        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            adapter.changeCursor( data );
        }


        @Override
        public void onLoaderReset(Loader loader) {
            adapter.changeCursor(null);
        }
    }

}
