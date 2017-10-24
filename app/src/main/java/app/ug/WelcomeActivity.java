package app.ug;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import android.net.Uri;

public class WelcomeActivity extends AppCompatActivity{
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnSkip, btnNext;
    private PreferencesManager preferencesManager;
    private VideoView videoview;

    @Override
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);

        // Check for first launch
        preferencesManager = new PreferencesManager(this);
        /*if (preferencesManager.isFirstTimeLaunch() == false) {
            launchHomeScreen();
        }//*/

        if (Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_welcome);

        viewPager  = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnSkip    = (Button) findViewById(R.id.btnSkip);
        btnNext    = (Button) findViewById(R.id.btnNext);

        // Layouts array
        layouts = new int[]{R.layout.slide_welcome1, R.layout.slide_welcome2};

        // Add dots
        addBottomDots(0);

        // Make notification bar transparent
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btnSkip.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v){
                launchHomeScreen();
            }
        });

        btnNext.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int current = getItem(+1);
                if (current < layouts.length){
                    viewPager.setCurrentItem(current);
                }
                else
                    launchHomeScreen();
            }
        });
    }

    private void addBottomDots(int current){
        dots = new TextView[layouts.length];

        int[] colorsActive   = getResources().getIntArray(R.array.array_dots_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dots_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[current]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[current].setTextColor(colorsActive[current]);
    }

    private int getItem(int i){
        return viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen(){
        preferencesManager.setFirstTimeLaunch(false);
        //startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
    }

    OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageSelected(int position){
            addBottomDots(position);

            if (position == layouts.length - 1){
                btnNext.setText("Listo");
                btnSkip.setVisibility(View.GONE);

                videoview = (VideoView) findViewById(R.id.videoview);
                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
                videoview.setVideoURI(uri);
                videoview.start();
            }
            else{
                btnNext.setText("Siguiente");
                btnSkip.setVisibility(View.VISIBLE);
                videoview.pause();
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2){}

        @Override
        public void onPageScrollStateChanged(int arg0){}
    };

    private void changeStatusBarColor(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter{
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter(){}

        @Override
        public Object instantiateItem(ViewGroup container, int position){
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount(){
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj){
            return view == obj;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object){
            View view = (View) object;
            container.removeView(view);
        }
    }
}
