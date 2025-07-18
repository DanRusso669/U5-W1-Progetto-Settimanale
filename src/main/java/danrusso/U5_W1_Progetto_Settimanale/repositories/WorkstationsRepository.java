package danrusso.U5_W1_Progetto_Settimanale.repositories;

import danrusso.U5_W1_Progetto_Settimanale.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkstationsRepository extends JpaRepository<Workstation, Long> {
}
