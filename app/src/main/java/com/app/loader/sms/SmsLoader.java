package com.app.loader.sms;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by ${zhaoyanjun} on 2017/4/19.
 */

public class SmsLoader extends AsyncTaskLoader<Cursor> {

    private Bundle bundle;
    private Uri uri = Uri.parse("content://sms");
    private String []colums = {"_id","address","body"};

    public SmsLoader(Context context , Bundle bundle ) {
        super(context);
        this.bundle = bundle;
    }

    @Override
    public Cursor loadInBackground() {
        String selection = null;
        String[] selectionArgs = null;
        if (bundle!=null) {
            selection = "body like ? ";
            selectionArgs = new String[]{"%"+bundle.getString("key")+"%"};
        }

        Cursor cursor = getContext().getContentResolver().query(uri, colums, selection  , selectionArgs, null);

        Log.e( "loader", "loadInBackground: ");
        return cursor;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
        Log.e( "loader", "onStartLoading: ");
        //这里一定要执行 forceLoad(); 否则 Loader 不会正常工作
        // onStartLoading()  --> forceLoad --> 调用 AsyncTaskLoader 里面的 forceLoad()
        // --> 开始创建 AsyncTask 对象实例，并且运行 AsyncTask 的 doInBackground --> SmsLoader 类中 loadInBackground()
        // --> 开始把结果 回调给主线程 AsyncTask onPostExecute（）  -->  AsyncTaskLoader  dispatchOnLoadComplete（）
        // -- AsyncTaskLoader deliverResult() 把最后的结果回调给 LoaderManager.LoaderCallbacks

    }
}
