package com.example.animedxd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajar.R;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class RatingReviewFragment extends Fragment {

    // ... (constructor tidak berubah)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rating_review, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup RecyclerView (kode dari sebelumnya, tidak berubah)
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewReviews);
        List<Review> reviewList = new ArrayList<>();
        // ... (isi reviewList seperti sebelumnya)
        reviewList.add(new Review("Frtz Grdyg", "1 Month Ago", "4/5", "The adventure never gets boring—there's always a surprise in every arc!"));
        reviewList.add(new Review("Lyn Mts", "2 Month Ago", "5/5", "One Piece is more than just an anime—it's a story about dreams, friendship, and freedom."));
        ReviewAdapter adapter = new ReviewAdapter(reviewList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // **TAMBAHKAN KODE INI**
        // Setup tombol Add Review
        MaterialButton buttonAddReview = view.findViewById(R.id.buttonAddReview);
        buttonAddReview.setOnClickListener(v -> {
            WriteReviewDialogFragment dialogFragment = new WriteReviewDialogFragment();
            // Gunakan getChildFragmentManager() karena kita memanggil dari dalam Fragment
            dialogFragment.show(getChildFragmentManager(), "write_review_dialog");
        });
    }
}