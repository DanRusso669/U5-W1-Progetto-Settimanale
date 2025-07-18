package danrusso.U5_W1_Progetto_Settimanale.services;

import danrusso.U5_W1_Progetto_Settimanale.entities.Workstation;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.NotFoundException;
import danrusso.U5_W1_Progetto_Settimanale.repositories.WorkstationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkstationsService {

    @Autowired
    private WorkstationsRepository workstationsRepository;

    public Workstation findById(long id) {
        return workstationsRepository.findById(id).orElseThrow(() -> new NotFoundException("Workstation with id " + id + " not found."));
    }

    public List<Workstation> findAll() {
        return workstationsRepository.findAll();
    }

    public void saveWorkstation(Workstation newWorkstation) {
        
    }
}
