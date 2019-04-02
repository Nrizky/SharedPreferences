package com.example.sharedpreferences.View;

import com.example.sharedpreferences.Model.MovieModel;

import java.util.List;

public interface MainView {
    void onSuccess(List<MovieModel> movieModels);
}
