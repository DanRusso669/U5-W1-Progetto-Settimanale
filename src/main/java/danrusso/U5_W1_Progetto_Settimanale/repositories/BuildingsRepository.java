package danrusso.U5_W1_Progetto_Settimanale.repositories;

import danrusso.U5_W1_Progetto_Settimanale.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingsRepository extends JpaRepository<Building, Long> {

    public Building findByName(String name);

    public Building findByAddress(String address);
}
