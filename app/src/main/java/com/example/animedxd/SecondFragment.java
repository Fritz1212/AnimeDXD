package com.example.animedxd;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animedxd.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment implements ImageCarouselAdapter.OnItemClickListener {

    private FragmentSecondBinding binding;


    // 1. Create your list of images by referencing their filenames

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ✅ CORRECT: The code is inside a method
        List<CarouselItem> imageList = new ArrayList<>();
        imageList.add(new CarouselItem(R.drawable.boruto_yangbener, "Boruto"));
        imageList.add(new CarouselItem(R.drawable.frieren_yangbener, "Frieren"));
        imageList.add(new CarouselItem(R.drawable.tsukigakirei_yangbener, "Tsuki Ga Kirei"));
        imageList.add(new CarouselItem(R.drawable.haikyu_yangbener, "Haikyu"));

        List<CarouselItem> imageList2 = new ArrayList<>();
        imageList2.add(new CarouselItem(R.drawable.haikyu, "Haikyu"));
        imageList2.add(new CarouselItem(R.drawable.frieren, "Frieren"));

        ImageCarouselAdapter adapter = new ImageCarouselAdapter(requireContext(), imageList, R.layout.item_image, this);
        ImageCarouselAdapter adapter2 = new ImageCarouselAdapter(requireContext(), imageList2, R.layout.item_middle, this);
        RecyclerView recyclerView1 = view.findViewById(R.id.imageRecyclerView);
        RecyclerView recyclerView2 = view.findViewById(R.id.imageRecyclerView2);
        RecyclerView recyclerView3 = view.findViewById(R.id.imageRecyclerView3);

        recyclerView1.setLayoutManager(
                new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        );

        recyclerView1.setAdapter(adapter);

        recyclerView2.setLayoutManager(
                new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        );
        recyclerView2.setAdapter(adapter2);

        recyclerView3.setLayoutManager(
                new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        );

        recyclerView3.setAdapter(adapter);

        // ... other code ...
    }


    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        // Return the created view to the host Activity
        return binding.getRoot();
    }


    @Override
    public void onImageClick(int position) {
        Toast.makeText(getContext(), "Clicked item #" + position, Toast.LENGTH_SHORT).show();
    }
}