// File: ReviewAdapter.java
package com.example.animedxd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajar.R;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private List<Review> reviewList;

    public ReviewAdapter(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Membuat view baru dari layout item_review.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        // Mengambil data dari posisi tertentu dan menampilkannya di view holder
        Review review = reviewList.get(position);
        holder.name.setText(review.getName());
        holder.date.setText(review.getDate());
        holder.score.setText(review.getScore());
        holder.content.setText(review.getContent());
    }

    @Override
    public int getItemCount() {
        // Mengembalikan jumlah total item dalam daftar
        return reviewList.size();
    }

    // ViewHolder bertugas untuk menyimpan referensi ke setiap view di dalam satu item
    public static class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView name, date, score, content;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewReviewerName);
            date = itemView.findViewById(R.id.textViewReviewDate);
            score = itemView.findViewById(R.id.textViewRatingScore);
            content = itemView.findViewById(R.id.textViewReviewContent);
        }
    }
}