package edu.ltu.dailyhoroscope;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TopSectionFragment extends Fragment{
    //@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);
        return view;
    }
}
