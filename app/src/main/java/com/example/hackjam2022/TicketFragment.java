package com.example.hackjam2022;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hackjam2022.databinding.FragmentTicketBinding;

public class TicketFragment extends Fragment {

    private FragmentTicketBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TicketViewModel ticketViewModel =
                new ViewModelProvider(this).get(TicketViewModel.class);

        View view = inflater.inflate(R.layout.fragment_ticket, container, false);
        //edit here

//        final TextView textView = binding.textTicket;
//        ticketViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}