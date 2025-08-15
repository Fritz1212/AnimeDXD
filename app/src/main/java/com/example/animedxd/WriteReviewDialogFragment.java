package com.example.animedxd;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.animedxd.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class WriteReviewDialogFragment extends BottomSheetDialogFragment {

    private TextView buttonSubmit;
    private RatingBar ratingBar;
    private EditText editTextReview;
    private TextView textViewErrorMessage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_write_review, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView buttonCancel = view.findViewById(R.id.buttonCancel);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
        ratingBar = view.findViewById(R.id.ratingBar);
        editTextReview = view.findViewById(R.id.editTextReview);
        textViewErrorMessage = view.findViewById(R.id.textViewErrorMessage);

        checkFieldsForSubmitButton();
        buttonCancel.setOnClickListener(v -> dismiss());
        buttonSubmit.setOnClickListener(v -> handleSubmit());

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            checkFieldsForSubmitButton();
            if (rating > 0) {
                textViewErrorMessage.setVisibility(View.GONE);
            }
        });

        editTextReview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                checkFieldsForSubmitButton();
                if (!s.toString().trim().isEmpty()) {
                    textViewErrorMessage.setVisibility(View.GONE);
                }
            }
        });
    }

    private void handleSubmit() {
        boolean isRatingFilled = ratingBar.getRating() > 0;
        boolean isReviewFilled = !editTextReview.getText().toString().trim().isEmpty();

        if (!isRatingFilled && !isReviewFilled) {
            showError("Rating and Review cannot be empty");
        } else if (!isRatingFilled) {
            showError("Rating cannot be empty");
        } else if (!isReviewFilled) {
            showError("Review cannot be empty");
        } else {
            textViewErrorMessage.setVisibility(View.GONE);
            Toast.makeText(getContext(), "Review Submitted!", Toast.LENGTH_SHORT).show();
            dismiss();
        }
    }

    // Metode untuk mengaktifkan/menonaktifkan tombol submit
    private void checkFieldsForSubmitButton() {
        boolean isRatingFilled = ratingBar.getRating() > 0;
        boolean isReviewFilled = !editTextReview.getText().toString().trim().isEmpty();

        // Cukup ubah warnanya saja, jangan di-disable
        if (isRatingFilled && isReviewFilled) {
            buttonSubmit.setTextColor(ContextCompat.getColor(getContext(), R.color.orange));
        } else {
            buttonSubmit.setTextColor(ContextCompat.getColor(getContext(), R.color.gray));
        }
    }

    private void showError(String message) {
        textViewErrorMessage.setText(message);
        textViewErrorMessage.setVisibility(View.VISIBLE);
    }
}