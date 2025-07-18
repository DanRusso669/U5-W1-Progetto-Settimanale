package danrusso.U5_W1_Progetto_Settimanale.repositories;

import danrusso.U5_W1_Progetto_Settimanale.entities.Reservation;
import danrusso.U5_W1_Progetto_Settimanale.entities.User;
import danrusso.U5_W1_Progetto_Settimanale.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation, Long> {

    Reservation findByWorkstationAndDate(Workstation workstation, LocalDate date);

    Reservation findByUserAndDate(User user, LocalDate date);
}
