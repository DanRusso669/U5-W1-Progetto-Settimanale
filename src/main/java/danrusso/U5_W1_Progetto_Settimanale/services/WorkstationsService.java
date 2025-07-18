package danrusso.U5_W1_Progetto_Settimanale.services;

import danrusso.U5_W1_Progetto_Settimanale.entities.Building;
import danrusso.U5_W1_Progetto_Settimanale.entities.Workstation;
import danrusso.U5_W1_Progetto_Settimanale.enums.WorkstationType;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.InvalidLenghtException;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.NotFoundException;
import danrusso.U5_W1_Progetto_Settimanale.repositories.WorkstationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkstationsService {

    @Autowired
    private WorkstationsRepository workstationsRepository;

    @Autowired
    private BuildingsService buildingsService;

    public Workstation findById(long id) {
        return workstationsRepository.findById(id).orElseThrow(() -> new NotFoundException("Workstation with id " + id + " not found."));
    }

    public List<Workstation> findAll() {
        return workstationsRepository.findAll();
    }

    public void saveWorkstation(String description, WorkstationType type, int maxGuests, long buildingId) {
        if (description.length() < 20)
            throw new InvalidLenghtException("Descrition should be at least 20 characters long.");

        try {
            Building found = buildingsService.findById(buildingId);
            Workstation newWorkstation = new Workstation(description, type, maxGuests, found);
            workstationsRepository.save(newWorkstation);
            System.out.println("Workstation with id " + newWorkstation.getId() + " addedd successfully.");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
