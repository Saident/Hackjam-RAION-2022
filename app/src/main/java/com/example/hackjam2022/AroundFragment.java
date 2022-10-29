package com.example.hackjam2022;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackjam2022.databinding.FragmentAroundBinding;

public class AroundFragment extends Fragment {

    private FragmentAroundBinding binding;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AroundViewModel aroundViewModel =
                new ViewModelProvider(this).get(AroundViewModel.class);

        View view = inflater.inflate(R.layout.fragment_around, container, false);


//        recyclerView.setAdapter(new RandomNumListAdapter(1234));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}