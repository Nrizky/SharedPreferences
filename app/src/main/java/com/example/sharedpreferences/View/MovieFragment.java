package com.example.sharedpreferences.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sharedpreferences.Adapter.MovieAdapter;
import com.example.sharedpreferences.Model.MovieModel;
import com.example.sharedpreferences.Presenter.MoviePresenter;
import com.example.sharedpreferences.R;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment implements MainView {
    RecyclerView rvVertical;
    MovieAdapter adapter;
    MoviePresenter presenter;
    List<MovieModel> movieModels = new ArrayList<>();
    View v;

    public MovieFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_movie, container, false);
        return v;
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvVertical = v.findViewById(R.id.rvV);
        Toast.makeText(getContext(), "Menampilakan Vertical Layout", Toast.LENGTH_SHORT).show();
        rvVertical.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new MovieAdapter(getContext(), movieModels);
        rvVertical.setAdapter(adapter);
        presenter = new MoviePresenter(this, getContext());
        presenter.setData();
    }

    @Override
    public void onSuccess(List<MovieModel> movieModels) {
        this.movieModels.clear();
        this.movieModels.addAll(movieModels);
        this.adapter.notifyDataSetChanged();

    }

}
