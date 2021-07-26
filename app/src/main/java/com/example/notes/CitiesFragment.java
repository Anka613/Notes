package com.example.notes;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CitiesFragment extends Fragment {

    private boolean isLandscape;

    public CitiesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (isLandscape) {
            showImage(ImageFragment.DEFAULT_INDEX);
        }
    }

    private void initList(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        String[] cities = getResources().getStringArray(R.array.cities);
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            TextView textView = new TextView(getContext());
            textView.setText(city);
            textView.setTextSize(30);
            linearLayout.addView(textView);

            final int currentIndex = i;
            textView.setOnClickListener(v -> {
                showImage(currentIndex);
            });
        }
    }

    void showImage(int index){
        if(isLandscape){
            showLandImage(index);
        }
        showPortImage(index);
    }

    private void showLandImage(int index){
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.image_fragment_container, ImageFragment.newInstance(index))
                .commit();
    }

    void showPortImage(int index) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), CityImageActivity.class);
        intent.putExtra(ImageFragment.ARG_INDEX, index);
        startActivity(intent);
    }

}
