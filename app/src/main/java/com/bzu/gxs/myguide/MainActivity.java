package com.bzu.gxs.myguide;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.bzu.gxs.myguide.adapter.GalleryImageAdapter;
import com.bzu.gxs.myguide.utils.Cubic;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    FrameLayout frameLayout;
    HorizontalScrollView bg_horizontalScrollView;
    HorizontalScrollView layer_horizontalScrollView;
    private GalleryImageAdapter adapter;
    int total_page;
    int bg_width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAdapter();
        setViewPagerParams();
    }

    private void initAdapter() {
        adapter = new GalleryImageAdapter(this);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.image_pager);
        frameLayout = (FrameLayout)findViewById(R.id.backgroundLayout);
        bg_horizontalScrollView = (HorizontalScrollView) findViewById(R.id.background_srcollview);
        bg_horizontalScrollView.setHorizontalScrollBarEnabled(false);
        layer_horizontalScrollView = (HorizontalScrollView) findViewById(R.id.layer_srcollview);
        layer_horizontalScrollView.setHorizontalScrollBarEnabled(false);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        // 获得窗口属性
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        bg_width = displayMetrics.widthPixels * 5;
        ViewGroup.LayoutParams layoutParams;

        ImageView back_imageView = (ImageView) findViewById(R.id.back_image_one);
        layoutParams = back_imageView.getLayoutParams();
        layoutParams.height  = displayMetrics.heightPixels;
        layoutParams.width = displayMetrics.widthPixels;
        back_imageView.setLayoutParams(layoutParams);

        FrameLayout.LayoutParams fLayoutParams;
        ImageView layer_one = (ImageView) findViewById(R.id.layer_image_one);
        fLayoutParams = (FrameLayout.LayoutParams) layer_one.getLayoutParams();
        fLayoutParams.height = displayMetrics.heightPixels;
        fLayoutParams.width = displayMetrics.widthPixels;
        layer_one.setLayoutParams(fLayoutParams);

        ImageView layer_two = (ImageView) findViewById(R.id.layer_image_two);
        fLayoutParams = (FrameLayout.LayoutParams) layer_two.getLayoutParams();
        fLayoutParams.height = displayMetrics.heightPixels;
        fLayoutParams.width = displayMetrics.widthPixels;
        layer_two.setLayoutParams(fLayoutParams);

        ImageView layer_three = (ImageView) findViewById(R.id.layer_image_three);
        fLayoutParams = (FrameLayout.LayoutParams) layer_three.getLayoutParams();
        fLayoutParams.height = displayMetrics.heightPixels;
        fLayoutParams.width = displayMetrics.widthPixels;
        layer_three.setLayoutParams(fLayoutParams);

        ImageView layer_four = (ImageView) findViewById(R.id.layer_image_four);
        fLayoutParams = (FrameLayout.LayoutParams) layer_four.getLayoutParams();
        fLayoutParams.height = displayMetrics.heightPixels;
        fLayoutParams.width = displayMetrics.widthPixels;
        layer_four.setLayoutParams(fLayoutParams);

        ImageView layer_five = (ImageView) findViewById(R.id.layer_image_five);
        fLayoutParams = (FrameLayout.LayoutParams) layer_five.getLayoutParams();
        fLayoutParams.height = displayMetrics.heightPixels;
        fLayoutParams.width = displayMetrics.widthPixels;
        layer_five.setLayoutParams(fLayoutParams);

    }

    private void setViewPagerParams() {
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                float realOffset  = Cubic.easeIn(positionOffset,0,1,1);

                total_page = adapter.getCount();
                float offset =(float)((float)(position + realOffset) *1.0 / total_page);
                int layyeroffsetPosition = (int)(bg_width * offset);
                layer_horizontalScrollView.scrollTo(layyeroffsetPosition,0);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
