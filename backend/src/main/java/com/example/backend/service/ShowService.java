package com.example.backend.service;

import com.example.backend.model.Show;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ShowService {
    Show addShow(Show show);
    List<Show> getAllShows();
    Show getShowById(Long id);
    List<Show> getShowsByPeriod(LocalDateTime from, LocalDateTime to);
    List<Show> getShowsOnChosenDate(LocalDate date);

}
