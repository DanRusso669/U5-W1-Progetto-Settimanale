package danrusso.U5_W1_Progetto_Settimanale.services;

import danrusso.U5_W1_Progetto_Settimanale.entities.Building;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.NotFoundException;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.ValidationException;
import danrusso.U5_W1_Progetto_Settimanale.repositories.BuildingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingsService {
    @Autowired
    private BuildingsRepository buildingsRepository;

    public Building findById(long id) {
        return buildingsRepository.findById(id).orElseThrow(() -> new NotFoundException("Building with id " + id + " not found."));
    }

    public List<Building> findAll() {
        return buildingsRepository.findAll();
    }

    public void saveBuilding(String name, String address, String city) {

        if (buildingsRepository.findByName(name) != null)
            throw new ValidationException("Name " + name + " is already connected to a building.");

        if (buildingsRepository.findByAddress(address) != null)
            throw new ValidationException("Address *" + address + "* is already connected to a building.");

        Building newBuilding = new Building(name, address, city);

        buildingsRepository.save(newBuilding);

        System.out.println("Building " + name + " addedd successfully.");
    }
}
