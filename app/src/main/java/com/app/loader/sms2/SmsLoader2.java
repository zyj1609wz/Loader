package com.app.loader.sms2;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;

/**
 * Created by ${zhaoyanjun} on 2017/4/20.
 */

public class SmsLoader2 extends CursorLoader  {

    public SmsLoader2(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        super(context, uri, projection, selection, selectionArgs, sortOrder);
    }
}
