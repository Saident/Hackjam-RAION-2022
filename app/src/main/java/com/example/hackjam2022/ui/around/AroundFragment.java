package com.example.hackjam2022.ui.around;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hackjam2022.databinding.FragmentAroundBinding;

public class AroundFragment extends Fragment {

    private FragmentAroundBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AroundViewModel aroundViewModel =
                new ViewModelProvider(this).get(AroundViewModel.class);

        binding = FragmentAroundBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        //edit here

//        final TextView textView = binding.textAround;
//        aroundViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}