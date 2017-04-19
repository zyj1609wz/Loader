package com.app.loader.sms;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

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

        return cursor;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
