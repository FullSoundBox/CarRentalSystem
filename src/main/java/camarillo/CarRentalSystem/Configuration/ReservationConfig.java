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
                    "2022-01-01",
                    "2022-01-10",
                    "active",
                    1L,
                    1L);

            List<Reservation> reservationList = new ArrayList<>();
            reservationList.add(reservation1);
            repository.saveAll(reservationList);
        };
    }
}
