package com.example.notes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ImageFragment extends Fragment {
    public static final String ARG_INDEX = "index";
    public static final int DEFAULT_INDEX = 0;
    private int index = DEFAULT_INDEX;
    private static final int[] CITY_IMAGES = {
            R.drawable.msk,
            R.drawable.spb,
            R.drawable.ekt,
            R.drawable.nsb,
            R.drawable.smr
    };

    public ImageFragment() {
        // Required empty public constructor
    }

    public static ImageFragment newInstance(int index) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX, DEFAULT_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        ImageView imageView = view.findViewById(R.id.city_image);
        imageView.setImageResource(CITY_IMAGES[index]);
        return view;
    }
}