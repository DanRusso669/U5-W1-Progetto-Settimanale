package danrusso.U5_W1_Progetto_Settimanale.services;

import danrusso.U5_W1_Progetto_Settimanale.entities.Reservation;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.NotFoundException;
import danrusso.U5_W1_Progetto_Settimanale.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Autowired
    private WorkstationsService workstationsService;

    @Autowired
    private UsersService usersService;

    public Reservation findById(long id) {
        return reservationsRepository.findById(id).orElseThrow(() -> new NotFoundException("Reservation with id " + id + " not found."));
    }

    public List<Reservation> findAll() {
        return reservationsRepository.findAll();
    }

//    public void saveReservation(LocalDate date, String username, long workstationId) {
//
//        User userFound = usersService.findByUsername(username);
//        Workstation workstationFound = workstationsService.findById(workstationId);
//
//        //reservationsRepository.findByWorkstationAndDate()
//        Reservation newReservation = new Reservation(date, userFound, workstationFound);
//
//        System.out.println("Reservation with id " + newReservation.getId() + " added successfully.");
//    }
}
