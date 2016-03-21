package com.cviceni.cv4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cviceni.MainActivity;
import com.cviceni.R;

public class MainFragment extends Fragment {

    onSendEmailListener listener;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // On button click send email to email adress from EditText to fragment
        Button redirect = (Button) view.findViewById(R.id.cv4_redirect);
        final EditText email = (EditText) view.findViewById(R.id.cv4_emain);
        redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailTxt = email.getText().toString();
                listener.sendEmail(emailTxt);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (onSendEmailListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    // interface
    public interface onSendEmailListener {
        public void sendEmail(String email);
    }
}
