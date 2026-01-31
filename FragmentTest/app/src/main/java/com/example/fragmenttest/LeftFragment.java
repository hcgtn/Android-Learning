package com.example.fragmenttest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LeftFragment extends Fragment {
    public interface OnButtonClickListener {
        void onLeftButtonClick();
    }

    private OnButtonClickListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnButtonClickListener) {
            listener = (OnButtonClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnButtonClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("LeftFragment>>>>>>", "Inflating left fragment layout");
        // Inflate the layout for this fragment




        View view = inflater.inflate(R.layout.left_fragment, container, false);

        Button button = view.findViewById(R.id.button);
        // 强转调用
//        button.setOnClickListener(v -> {
//            MainActivity activity = (MainActivity) getActivity();
//            if (activity != null) {
//                activity.replaceFragment(new AnotherRightFragment());
//            }
//        });

        button.setOnClickListener(v -> {
            if (listener != null) {
                listener.onLeftButtonClick();
            }
        });

        return view;
    }
}