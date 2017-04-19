package com.app.loader.app;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.app.loader.MainActivity;
import com.app.loader.R;

import java.util.List;

/**
 * Created by ${zhaoyanjun} on 2017/4/19.
 */

public class AppActivity extends AppCompatActivity {

    private ListView listView ;
    private AppAdapter appAdapter ;
    private LoaderManager.LoaderCallbacks loaderCallbacks ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app );

        listView = (ListView) findViewById( R.id.listview );

        appAdapter = new AppAdapter( null , this ) ;
        listView.setAdapter( appAdapter );

        loaderCallbacks = new MyCallback() ;

        getLoaderManager().initLoader( 1 , null,  loaderCallbacks );

        getLoaderManager().restartLoader( 1 , null , loaderCallbacks ) ;
    }

    class MyCallback implements LoaderManager.LoaderCallbacks<List<AppBean>>{

        @Override
        public Loader<List<AppBean>> onCreateLoader(int id, Bundle args) {
            return new AppLoader( AppActivity.this );
        }

        @Override
        public void onLoadFinished(Loader<List<AppBean>> loader, List<AppBean> data) {
            appAdapter.setData( data );
            appAdapter.notifyDataSetChanged();
        }

        @Override
        public void onLoaderReset(Loader<List<AppBean>> loader) {
            appAdapter.notifyDataSetChanged();
        }
    }
}
