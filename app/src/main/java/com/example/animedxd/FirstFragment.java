package com.example.animedxd;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.animedxd.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
    }

    private void validation() {
        binding.usernameLayout.setError(null);
        binding.passwordLayout.setError(null);

        String username = binding.username.getText().toString().trim();
        String password = binding.password.getText().toString().trim();

        if (username.isEmpty()) {
            binding.usernameLayout.setError("Username cannot be empty");
            binding.username.requestFocus(); // Move cursor to the username field
            return; // Stop further validation
        }

        if(username.length() < 5 && username.length() > 10) {
            binding.usernameLayout.setError("Username must be greater than 5 and less than 10");
            binding.username.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            binding.passwordLayout.setError("Password cannot be empty");
            binding.password.requestFocus();
            return;
        }

        if (password.length() < 8) {
            binding.passwordLayout.setError("Password must be at least 8 characters");
            binding.password.requestFocus();
            return;
        }

        // --- If all checks pass ---
        Toast.makeText(requireContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
        // Here you would proceed with the actual login process (e.g., API call)
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}