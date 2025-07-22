package danrusso.U5_W1_Progetto_Settimanale.services;

import danrusso.U5_W1_Progetto_Settimanale.entities.Reservation;
import danrusso.U5_W1_Progetto_Settimanale.entities.User;
import danrusso.U5_W1_Progetto_Settimanale.entities.Workstation;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.NotFoundException;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.ValidationException;
import danrusso.U5_W1_Progetto_Settimanale.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public Reservation findByWorkstationAndDate(Workstation workstation, LocalDate date) {
        return reservationsRepository.findByWorkstationAndDate(workstation, date);
    }

    // Questo save controlla se la postazione indicata nella prenotazione è già occupata per la data inserita.
    // Inoltre controlla che l'utente inserito non abbia giù una postazione prenotata per quella data.

    public void saveReservation(LocalDate date, long userId, long workstationId) {

        User userFound = usersService.findById(userId);
        Workstation workstationFound = workstationsService.findById(workstationId);

        Reservation reservationFound = this.findByWorkstationAndDate(workstationFound, date);
        if (reservationFound != null)
            throw new ValidationException("You can't book workstation with id " + workstationId + " on the selected date.");

        Reservation reservationOfUserFound = reservationsRepository.findByUserAndDate(userFound, date);
        if (reservationOfUserFound != null)
            throw new ValidationException("You already have workstation with id " + reservationOfUserFound.getWorkstation().getId() + " booked for this date.");

        Reservation newReservation = new Reservation(date, userFound, workstationFound);
        reservationsRepository.save(newReservation);

        System.out.println("Reservation with id " + newReservation.getId() + " added successfully.");
    }


}
