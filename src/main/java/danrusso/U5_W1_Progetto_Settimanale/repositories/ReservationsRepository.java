package danrusso.U5_W1_Progetto_Settimanale.repositories;

import danrusso.U5_W1_Progetto_Settimanale.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation, Long> {

    // public Reservation findByWorkstationAndDate(long id, LocalDate date);

}
