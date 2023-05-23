package com.example.backend.service;

import com.example.backend.model.Show;
import com.example.backend.model.requests.ShowRequest;

import java.util.List;

public interface ShowService {
    Show addShow(ShowRequest showRequest);
    List<Show> getAllShows();
    Show getShowById(Long id);
}
