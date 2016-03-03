package com.covain.movies.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.covain.movies.activity.MainActivity;

public class BaseFragment extends Fragment {

    protected MainActivity mMainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        mMainActivity = (MainActivity) getActivity();
    }
}
