package com.example.animedxd;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Menggunakan switch-case untuk menentukan fragment mana yang akan ditampilkan
        switch (position) {
            case 0:
                return new InformationFragment();
            case 1:
                return new RatingReviewFragment();
            default:
                // Seharusnya tidak pernah terjadi, tetapi return fragment kosong untuk keamanan
                return new Fragment();
        }
    }

    @Override
    public int getItemCount() {
        // Jumlah total tab kita
        return 2;
    }
}