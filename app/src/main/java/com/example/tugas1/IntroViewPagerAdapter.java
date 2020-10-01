package com.example.tugas1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class IntroViewPagerAdapter extends PagerAdapter {
    Context mContext;
    List<WelcomeItem> mListWelcome;

    public IntroViewPagerAdapter(Context mContext, List<WelcomeItem> mListWelcome) {
        this.mContext = mContext;
        this.mListWelcome = mListWelcome;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen,null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.img_slide);
        TextView welcomeText = layoutScreen.findViewById(R.id.welcome_text);
        TextView subWelcomeText = layoutScreen.findViewById(R.id.sub_welcome);
        ImageView imgBackground = layoutScreen.findViewById(R.id.background_Img);

        imgSlide.setImageResource(mListWelcome.get(position).getImg_slide());
        welcomeText.setText(mListWelcome.get(position).getWelcome_text());
        subWelcomeText.setText(mListWelcome.get(position).getSub_welcome());
        imgBackground.setImageResource(mListWelcome.get(position).getBackground());
        container.addView(layoutScreen);
        return layoutScreen;
    }

    @Override
    public int getCount() {
        return mListWelcome.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
