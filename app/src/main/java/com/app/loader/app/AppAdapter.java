package com.app.loader.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.app.loader.R;
import java.util.List;

/**
 * Created by ${zhaoyanjun} on 2017/4/19.
 */

public class AppAdapter extends BaseAdapter  {

    private List<AppBean > list ;
    private Context context ;

    public AppAdapter(List<AppBean > list , Context context ){
        this.list = list ;
        this.context = context ;
    }

    @Override
    public int getCount() {
        return  list == null ? 0 : list.size() ;
    }

    @Override
    public Object getItem(int position) {
        return list.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {

            holder=new ViewHolder();

            convertView = LayoutInflater.from( context ).inflate(R.layout.app_listview_item , null);
            holder.image = (ImageView) convertView.findViewById( R.id.image)  ;
            holder.name = (TextView)convertView.findViewById(R.id.name );
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        AppBean bean = list.get( position ) ;
        holder.name.setText( bean.getmLabel() );

        holder.image.setImageDrawable( bean.getmIcon() );

        return convertView ;
    }

    public final class ViewHolder{
        public TextView name ;
        public ImageView image ;
    }

    public void setData( List<AppBean> list ){
        this.list = list ;
    }
}
