package com.example.tugas1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResetPassword#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResetPassword extends Fragment {

    View view;
    Button changePassBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reset_password,container,false);
        changePassBtn = (Button) view.findViewById(R.id.btnChangePass);
        changePassBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new Success(), "NewFragmentTag");
                ft.commit();
            }
        });
        return view;
    }
}