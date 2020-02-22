package kr.ac.kpu.ondot.Main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import kr.ac.kpu.ondot.R;

public class MainTranslate extends Fragment {


    public MainTranslate() {
        // Required empty public constructor
    }

    public static MainTranslate newInstance(){
        Bundle args = new Bundle();
        MainTranslate fragment = new MainTranslate();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_translate, container, false);
    }

}
