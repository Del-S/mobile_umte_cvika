package com.cviceni.cv4;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cviceni.R;

public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }

    TextView txtRewrite;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        txtRewrite = (TextView) view.findViewById(R.id.cv4_rewrite);

        return view;
    }

    public void setEmail(String email) {
        txtRewrite.setText(email);
    }

}
