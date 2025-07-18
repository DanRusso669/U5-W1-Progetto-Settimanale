package danrusso.U5_W1_Progetto_Settimanale.repositories;

import danrusso.U5_W1_Progetto_Settimanale.entities.Workstation;
import danrusso.U5_W1_Progetto_Settimanale.enums.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkstationsRepository extends JpaRepository<Workstation, Long> {

    @Query("SELECT w FROM Workstation w WHERE w.type = :type AND w.building.city = :city")
    List<Workstation> filterByTypeAndCity(WorkstationType type, String city);

}
