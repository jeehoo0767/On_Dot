package kr.ac.kpu.ondot.Educate;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import kr.ac.kpu.ondot.R;

public class EduFirstFrag extends Fragment {

    public EduFirstFrag() {
        // Required empty public constructor
    }

    public static EduFirstFrag newInstance(){
        Bundle args = new Bundle();
        EduFirstFrag fragment = new EduFirstFrag();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.edu_first_frag, container, false);
    }

}
