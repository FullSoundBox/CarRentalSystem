package camarillo.CarRentalSystem.Configuration;

import camarillo.CarRentalSystem.Entities.Reservation;
import camarillo.CarRentalSystem.Repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ReservationConfig {

    @Bean
    CommandLineRunner commandLineRunner(ReservationRepository repository){
        return args -> {
            Reservation reservation1 = new Reservation(
                    1L,
                    1000F,
                    LocalDateTime.of(2021, 1, 1, 0, 0),
                    LocalDateTime.now(),
                    1L,
                    1L,
                    0);

            Reservation reservation2 = new Reservation(
                    2L,
                    2000F,
                    LocalDateTime.of(2021, 1, 7, 0, 0),
                    LocalDateTime.now(),
                    2L,
                    3L,
                    0);

            List<Reservation> reservationList = new ArrayList<>();
            reservationList.add(reservation1);
            reservationList.add(reservation2);
            repository.saveAll(reservationList);
        };
    }
}
