package com.example.belajar;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final TextView userNameTextView = findViewById(R.id.userNameTextView);

        userNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tidak ada perubahan di sini, karena sekarang menggunakan PopupMenu yang benar dari import
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view, Gravity.BOTTOM);
                popupMenu.getMenuInflater().inflate(R.menu.profile_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(menuItem -> {
                    if (menuItem.getItemId() == R.id.action_logout) {
                        Toast.makeText(MainActivity.this, "Logout berhasil!", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                    return false;
                });

                popupMenu.setForceShowIcon(true);
                popupMenu.show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerViewAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 2. Buat data dummy
        List<Anime> animeList = new ArrayList<>();
        animeList.add(new Anime("Akame Ga Kill", "Action, Fantasy", "Akame ga Kill! follows Tatsumi, a village boy who joins Night Raid—a group of assassins fighting to stop a corrupt government hurting the people. As they take down evil leaders, Tatsumi faces strong enemies and learns the harsh truth about justice, sacrifice, and what it means to fight for a better world.", R.drawable.akame_ga_kill));
        animeList.add(new Anime("Attack on Titan", "Action, Dark Fantasy", "In a world where humanity resides within enormous walls, Titans roam the land...", R.drawable.attack_on_titan));
        animeList.add(new Anime("Akame Ga Kill", "Action, Fantasy", "Akame ga Kill! follows Tatsumi, a village boy who joins Night Raid—a group of assassins...", R.drawable.akame_ga_kill));
        animeList.add(new Anime("Attack on Titan", "Action, Dark Fantasy", "In a world where humanity resides within enormous walls, Titans roam the land...", R.drawable.attack_on_titan));
        animeList.add(new Anime("Akame Ga Kill", "Action, Fantasy", "Akame ga Kill! follows Tatsumi, a village boy who joins Night Raid—a group of assassins...", R.drawable.akame_ga_kill));
        animeList.add(new Anime("Attack on Titan", "Action, Dark Fantasy", "In a world where humanity resides within enormous walls, Titans roam the land...", R.drawable.attack_on_titan));
        // Tambahkan anime lain jika perlu

        // 3. Buat dan atur adapter
        AnimeAdapter adapter = new AnimeAdapter(animeList);
        recyclerView.setAdapter(adapter);
    }
}