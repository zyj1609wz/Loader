package com.app.loader.sms2;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.app.loader.R;

public class SmsActivity2 extends AppCompatActivity {

    private int loaderId = 6 ;
    private ListView lv;
    private SimpleCursorAdapter adapter;
    private LoaderManager.LoaderCallbacks loaderCallbacks ;

    private EditText editText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms );
        Log.e( "loader", "activity  onCreate: ");
        lv = (ListView) findViewById( R.id.listview );

        adapter = new SimpleCursorAdapter(this,
                R.layout.sms_listview_item ,
                null,
                new String[]{"address","body"},
                new int[]{R.id.address, R.id.body},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        lv.setAdapter(adapter);

        loaderCallbacks = new MyCallback() ;

        //初始化，并且创建Loader 实例，并且开始执行
        getLoaderManager().initLoader( loaderId , null,  loaderCallbacks );

        editText = (EditText) findViewById( R.id.editText );
        findViewById( R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始查询
                String tag = editText.getText().toString() ;
                Bundle bundle = new Bundle();
                bundle.putString("key", tag );
                getLoaderManager().restartLoader( loaderId , bundle, loaderCallbacks  );
            }
        });

        findViewById( R.id.init).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //初始化，并且创建Loader 实例，并且开始执行
                getLoaderManager().initLoader( loaderId , null,  loaderCallbacks );
            }
        });

    }

    class MyCallback implements LoaderManager.LoaderCallbacks<Cursor> {

        @Override
        public Loader onCreateLoader(int id, Bundle args) {
            Log.e( "loader", "onCreateLoader: ");

            Uri uri = Uri.parse("content://sms");
            String []colums = {"_id","address","body"};
            SmsLoader2 loader2 = new SmsLoader2( SmsActivity2.this , uri , colums , null , null , null  ) ;

            return loader2  ;
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            Log.e( "loader", "onLoadFinished: ");
            adapter.swapCursor( data );
        }

        @Override
        public void onLoaderReset(Loader loader) {
            Log.e( "loader", "onLoaderReset: ");
            //当 Activity OnDestory() , 系统会回调这个方法
            adapter.swapCursor(null);
        }
    }

    @Override
    protected void onResume() {
        Log.e( "loader", "activity onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e( "loader", "activity onPause: ");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.e( "loader", "activity onDestroy: ");
        super.onDestroy();
    }
   
}
