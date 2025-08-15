package com.example.animedxd;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

// Ganti com.example.belajar dengan nama package aplikasi Anda
import com.example.belajar.R;


public class DetailAnime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);

        // Inisialisasi Views
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        // Setup Adapter
        viewPager.setAdapter(new ViewPagerAdapter(this));

        // Hubungkan TabLayout dengan ViewPager menggunakan TabLayoutMediator
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    // Mengatur teks untuk setiap tab berdasarkan posisinya
                    switch (position) {
                        case 0:
                            tab.setText("Information");
                            break;
                        case 1:
                            tab.setText("Rating and Review");
                            break;
                    }
                }
        ).attach();

        // Panggil metode untuk animasi fade
        setupFadeAnimation(viewPager);
    }

    private void setupFadeAnimation(ViewPager2 viewPager) {
        // Menerapkan PageTransformer untuk animasi kustom
        viewPager.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                // Menggunakan Math.abs() untuk mendapatkan nilai absolut dari posisi
                page.setAlpha(1 - Math.abs(position));

                // Efek parallax ringan (opsional)
                // Menggunakan page.getWidth() / 2f untuk memastikan pembagian float
                page.setTranslationX(-position * (page.getWidth() / 2f));
            }
        });
    }
}