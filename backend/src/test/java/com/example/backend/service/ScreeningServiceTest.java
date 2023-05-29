package com.example.backend.service;

import com.example.backend.exception.NotFoundException;
import com.example.backend.model.Movie;
import com.example.backend.model.Screening;
import com.example.backend.model.ScreeningRoom;
import com.example.backend.model.Seat;
import com.example.backend.repository.ScreeningRepository;
import com.example.backend.serviceImpl.ScreeningServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ScreeningServiceTest {

    @Mock
    private ScreeningRepository screeningRepository;
    @InjectMocks
    private ScreeningServiceImpl screeningService;

    @Test
    public void getScreeningById_NullScreeningId_ReturnsScreeningResponse(){
        Assertions.assertThrows(NotFoundException.class, () -> {
            screeningService.getScreeningById(null);
        });
    }

    @Test
    public void getScreeningById_NotExistingScreeningId_ReturnsScreeningResponse(){
        Assertions.assertThrows(NotFoundException.class, () -> {
            screeningService.getScreeningById(1L);
        });
    }

    @Test
    public void getScreeningById_ScreeningId_ReturnsScreeningResponse(){

        //given
        Movie movie = Movie.builder()
                .title("title")
                .duration(Duration.ofMinutes(120))
                .genre("genre")
                .filmDirector("filmDirector")
                .build();

        ScreeningRoom screeningRoom = ScreeningRoom.builder()
                .number(1)
                .rowQuantity(1)
                .seatsPerRow(1)
                .build();


        Screening screening = Screening.builder()
                .startTime(LocalDateTime.now().plusDays(1))
                .movie(movie)
                .screeningRoom(screeningRoom)
                .build();

        List<Seat> seats = List.of(Seat.builder()
                .rowNumber(1)
                .seatNumber(1)
                .isReserved(false)
                .build());

        screening.setSeats(seats);


        screeningService.addScreening(screening);

        //when
        when(screeningRepository.findById(1L)).thenReturn(java.util.Optional.of(screening));

        //then
        Assertions.assertDoesNotThrow(() -> {
            screeningService.getScreeningById(1L);
        });
    }

}