package com.app.loader.app;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${zhaoyanjun} on 2017/4/19.
 */

public class AppLoader extends AsyncTaskLoader<List<AppBean>> {

    private Context context ;
    public AppLoader(Context context) {
        super(context);
        this.context = context ;
    }

    @Override
    public List<AppBean> loadInBackground() {
        List<AppBean> list = new ArrayList<>() ;
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> pakageinfos = pm.getInstalledPackages(PackageManager.MATCH_UNINSTALLED_PACKAGES);
        for (PackageInfo packageInfo : pakageinfos) {

            AppBean appBean = new AppBean() ;

            String str_name = packageInfo.applicationInfo.loadLabel(pm).toString();
            Drawable drawable = packageInfo.applicationInfo.loadIcon(pm);

            appBean.setmLabel( str_name );
            appBean.setmIcon(drawable);

            list.add( appBean ) ;
        }
        return list ;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
