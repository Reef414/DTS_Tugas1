package com.example.tugas1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeBack#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeBack extends Fragment {
    View view;
    Button loginBtn;
    TextView forgotBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_welcome_back,container,false);
        loginBtn = (Button) view.findViewById(R.id.btnLogin);
        forgotBtn = (TextView) view.findViewById(R.id.forgot_password);
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new Success(), "NewFragmentTag");
                ft.commit();
            }
        });
        forgotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new ForgotPassword(), "NewFragmentTag");
                ft.commit();
            }
        });
        return view;
    }
}