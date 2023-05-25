package com.example.backend.model.dataLoader;

import com.example.backend.model.ScreeningRoom;
import com.example.backend.model.Movie;
import com.example.backend.repository.ScreeningRoomRepository;
import com.example.backend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.stream.Stream;


@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataLoader implements org.springframework.boot.CommandLineRunner{

    private final MovieRepository movieRepository;
    private final ScreeningRoomRepository screeningRoomRepository;

    @Override
    public void run(String... args) {
        loadMovies();
        loadScreeningRooms();
    }

    private void loadMovies() {
        Stream.of(
                Movie.builder()
                        .title("Titanic")
                        .description("A romantic disaster film about the sinking of the RMS Titanic.")
                        .filmDirector("James Cameron")
                        .genre("Romance, Drama")
                        .duration(Duration.ofMinutes(194))
                        .build(),

                Movie.builder()
                        .title("Shutter Island")
                        .description("A psychological thriller film directed by Martin Scorsese.")
                        .filmDirector("Martin Scorsese")
                        .genre("Mystery, Thriller")
                        .duration(Duration.ofMinutes(138))
                        .build(),

                Movie.builder()
                        .title("Inception")
                        .description("A science fiction action film directed by Christopher Nolan.")
                        .filmDirector("Christopher Nolan")
                        .genre("Action, Sci-Fi")
                        .duration(Duration.ofMinutes(148))
                        .build()
        ).forEach(movieRepository::save);
    }

    private void loadScreeningRooms(){
        Stream.of(
                ScreeningRoom.builder()
                        .number(1)
                        .rowQuantity(5)
                        .seatsPerRow(10)
                        .build()
        ).forEach(screeningRoomRepository::save);
    }


}
