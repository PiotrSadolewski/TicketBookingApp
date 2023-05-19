package com.example.backend.serviceImpl;

import com.example.backend.model.Show;
import com.example.backend.repository.ShowRepository;
import com.example.backend.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;

    @Autowired
    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    @Override
    public Show getShowById(Long id) {
        return showRepository.findById(id).orElseThrow(() -> new RuntimeException("Show not found"));
    }

    @Override
    public List<Show> getShowsByPeriod(LocalDateTime from, LocalDateTime to) {
        return showRepository.getShowsByPeriod(from, to);
    }

    @Override
    public List<Show> getShowsOnChosenDate(LocalDate date) {
        return showRepository.getShowsOnChosenDate(date);
    }

    @Override
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }



}
