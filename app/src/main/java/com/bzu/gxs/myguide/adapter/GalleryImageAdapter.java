package com.bzu.gxs.myguide.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bzu.gxs.myguide.R;

/**
 * Created by GXS on 2016/5/9.
 */
public class GalleryImageAdapter extends PagerAdapter{

    private LayoutInflater mLayoutInflater;
    private Context context;
    public Handler mHandler;
    LayoutInflater inflater;

    public GalleryImageAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final ViewHolder holder;
        holder = new ViewHolder();
        View imageLayout = mLayoutInflater.inflate(R.layout.activity_item,null);
        holder.image = (LinearLayout) imageLayout.findViewById(R.id.gallery_image_item_view);

        if (position == 4){
            holder.image.setEnabled(true);
        }
        else {
            holder.image.setEnabled(false);
        }
        if (position == 0){
            holder.image.removeAllViews();
            View view0 = inflater.inflate(R.layout.layout_one,null);
            holder.image.addView(view0);
        }
        else if (position == 1){
            holder.image.removeAllViews();
            View view1 = inflater.inflate(R.layout.layout_two,null);
            holder.image.addView(view1);
        }
        else if (position == 2){
            holder.image.removeAllViews();
            View view2 = inflater.inflate(R.layout.layout_three,null);
            holder.image.addView(view2);
        }
        else if (position ==3){
            holder.image.removeAllViews();
            View view3 = inflater.inflate(R.layout.layout_four,null);
            holder.image.addView(view3);
        }
        else if (position == 4){
            holder.image.removeAllViews();
            View view4 = inflater.inflate(R.layout.layout_five,null);
            holder.image.addView(view4);
        }
        ((ViewPager)container).addView(imageLayout,0);

        return imageLayout;
    }

    class ViewHolder{
        private LinearLayout image;
    }
}
