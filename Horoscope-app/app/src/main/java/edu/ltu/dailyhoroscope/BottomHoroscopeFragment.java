package edu.ltu.dailyhoroscope;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.TextView;

public class BottomHoroscopeFragment extends Fragment {
    private static TextView summarytext;

    //@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.bottom_horoscope_fragment, container, false);
        summarytext = (TextView) view.findViewById(R.id.summarytext);
        return view;
    }
    public void setSummaryText(String text){
        summarytext.setText(text);
    }
}