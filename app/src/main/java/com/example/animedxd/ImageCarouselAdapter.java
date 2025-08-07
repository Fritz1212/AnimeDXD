package com.example.animedxd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageCarouselAdapter extends RecyclerView.Adapter<ImageCarouselAdapter.ImageViewHolder> {

    private final List<CarouselItem> imageList; // List of drawable resource IDs
    private int layoutResId;

    public interface OnItemClickListener {
        void onImageClick(int position); // Pass whatever data you need
    }

    private final OnItemClickListener listener;

    public ImageCarouselAdapter(Context secondFragment, List<CarouselItem> imageList, int layoutResId, OnItemClickListener listener) {
        this.imageList = imageList;
        this.layoutResId = layoutResId;
        this.listener = listener;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView animeNameView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gambar_carousel_no_auto);
            animeNameView = itemView.findViewById(R.id.carousel_text_view);
        }
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        // Set the image for the current item
        CarouselItem currentItem = imageList.get(position);

        // This is the critical part. If currentItem is null, the app will crash.
        if (currentItem == null) {
            return; // Exit early to prevent a crash
        }

        // Safely check if holder.imageView is not null before using it.
        // This handles the case where you inflated a layout that doesn't have this ID.
        if (holder.imageView != null) {
            holder.imageView.setImageResource(currentItem.imageRes1);
        }

        holder.animeNameView.setText(currentItem.animeName);


        holder.itemView.setOnClickListener(v -> {
            listener.onImageClick(holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        // Return the total number of images
        return imageList.size();
    }

    // The ViewHolder holds the views for each item

}