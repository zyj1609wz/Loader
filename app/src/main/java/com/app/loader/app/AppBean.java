package com.app.loader.app;

import android.graphics.drawable.Drawable;

import java.io.File;

/**
 * Created by ${zhaoyanjun} on 2017/4/19.
 */

public class AppBean  {

    private File mApkFile;
    private String mLabel;
    private Drawable mIcon;

    public File getmApkFile() {
        return mApkFile;
    }

    public void setmApkFile(File mApkFile) {
        this.mApkFile = mApkFile;
    }

    public String getmLabel() {
        return mLabel;
    }

    public void setmLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    public Drawable getmIcon() {
        return mIcon;
    }

    public void setmIcon(Drawable mIcon) {
        this.mIcon = mIcon;
    }
}
