package com.water.reminder;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;



public class HomeFragment extends Fragment {

    int prog_water;
    @Override
    public View onCreateView( LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        final Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);

        View v= inflater.inflate(R.layout.home_fragment,container,false);
        ImageView img_mesure_cup = v.findViewById(R.id.img_mesure_cup);
        ProgressBar prog_bar_water = v.findViewById((R.id.prog_bar_water));


        img_mesure_cup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            img_mesure_cup.startAnimation(animation);

                prog_water+=10;
                prog_bar_water.setProgress(prog_water);

            }
        });


        return  v;
    }

}


