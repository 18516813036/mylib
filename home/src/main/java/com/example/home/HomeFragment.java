package com.example.home;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.common.utils.LogUtils;
import com.example.core.view.BaseFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnBannerListener {

    private View baseView;

    private Banner fragHomeBanner;
//    private ViewFlipper fragHomeVf;

    private List<String> images;
    private List<String> titles;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        baseView = inflater.inflate(R.layout.layout_home, container, false);
        return baseView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragHomeBanner = (Banner) baseView.findViewById(R.id.frag_home_banner);

//        fragHomeVf = (ViewFlipper) baseView.findViewById(R.id.frag_home_vf);
//
//        for (int i = 0; i < 10; i++) {
//            View view1 = getLayoutInflater().inflate(R.layout.item_viewflipper, null);
//            TextView tv = view1.findViewById(R.id.tv_item_flipper);
//            tv.setText("我是系统通知，内容"+i);
//            tv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(getActivity(), ""+((TextView)view).getText(), Toast.LENGTH_SHORT).show();
//                }
//            });
//            fragHomeVf.addView(view1);
//        }
//        fragHomeVf.setFlipInterval(2000);
//        fragHomeVf.startFlipping();

        initBanner();
    }

    private void initBanner() {
        images = new ArrayList<>();
        titles = new ArrayList<>();

        String str1 = "http://img1.imgtn.bdimg.com/it/u=2534156228,2756034867&fm=26&gp=0.jpg";
        String str2 = "http://img2.imgtn.bdimg.com/it/u=2677929620,4206585946&fm=26&gp=0.jpg";
        String str3 = "http://img1.imgtn.bdimg.com/it/u=2715070468,3635545927&fm=26&gp=0.jpg";
        String str4 = "http://img1.imgtn.bdimg.com/it/u=2356505222,2932087731&fm=26&gp=0.jpg";
        String str5 = "http://img4.imgtn.bdimg.com/it/u=2164364420,1703200550&fm=26&gp=0.jpg";
        String str6 = "http://img3.imgtn.bdimg.com/it/u=2419550195,2445223670&fm=26&gp=0.jpg";
        String str7 = "http://img3.imgtn.bdimg.com/it/u=2047708823,1694462320&fm=26&gp=0.jpg";
        String str8 = "http://img1.imgtn.bdimg.com/it/u=1931527234,1673354277&fm=26&gp=0.jpg";

        String title1 = "标题1";
        String title2 = "标题2";
        String title3 = "标题3";
        String title4 = "标题4";

        images.add(str1);
        images.add(str2);
        images.add(str3);
        images.add(str4);
        titles.add(title1);
        titles.add(title2);
        titles.add(title3);
        titles.add(title4);

        fragHomeBanner.setImages(images);
        fragHomeBanner.setBannerTitles(titles);
        fragHomeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        fragHomeBanner.setImageLoader(new MyBannerLoader());
        fragHomeBanner.setBannerAnimation(Transformer.Default);
        fragHomeBanner.setDelayTime(3000);
        fragHomeBanner.isAutoPlay(true);

        fragHomeBanner.setIndicatorGravity(Gravity.CENTER)
                .setOnBannerListener(this)
                .start();
    }

    @Override
    public void OnBannerClick(int position) {
        LogUtils.i(""+position);
    }

    class MyBannerLoader extends ImageLoader{
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
