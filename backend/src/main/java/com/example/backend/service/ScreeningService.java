package com.example.backend.service;

import com.example.backend.model.Screening;
import com.example.backend.model.requests.ScreeningRequest;
import com.example.backend.model.response.ScreeningResponse;

import java.util.List;

public interface ScreeningService {
    Screening addScreening(ScreeningRequest screeningRequest);
    List<Screening> getAllScreenings();
    ScreeningResponse getScreeningById(Long id);
}
