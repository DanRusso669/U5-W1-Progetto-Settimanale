package danrusso.U5_W1_Progetto_Settimanale;

import danrusso.U5_W1_Progetto_Settimanale.entities.Reservation;
import danrusso.U5_W1_Progetto_Settimanale.entities.Workstation;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.InvalidLenghtException;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.ValidationException;
import danrusso.U5_W1_Progetto_Settimanale.services.BuildingsService;
import danrusso.U5_W1_Progetto_Settimanale.services.ReservationsService;
import danrusso.U5_W1_Progetto_Settimanale.services.UsersService;
import danrusso.U5_W1_Progetto_Settimanale.services.WorkstationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private UsersService usersService;

    @Autowired
    private BuildingsService buildingsService;

    @Autowired
    private WorkstationsService workstationsService;

    @Autowired
    private ReservationsService reservationsService;

    @Override
    public void run(String... args) throws Exception {

        try {
            usersService.saveUser("SuperMario", "Mario Rossi", "m_rossi@gmail.com");
            usersService.saveUser("Batman", "Bruce Wayne", "darkknight@gotham.com");
            usersService.saveUser("Trinità", "Bud Spencer", "trinity@gmail.com");
            usersService.saveUser("Yotobi", "Karim Musa", "yotobi@gmail.com");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            buildingsService.saveBuilding("The Gherkin", "Lakeview Drive, 621", "Columbus");
            buildingsService.saveBuilding("The Chrysler Building", "Maple Grove Lane, 157", "Albuquerque");
            buildingsService.saveBuilding("Woolworth Building", "Hawthorne Avenue, 56", "Portland");
            buildingsService.saveBuilding("One World Trade Center", "Fulton Street, 285", "New York");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
//            workstationsService.saveWorkstation("Bright private area for working, alone or in a team, away from noise and distractions.", WorkstationType.PRIVATE, 4, 1);
//            workstationsService.saveWorkstation("Bright private area for working, alone or in a team, away from noise and distractions.", WorkstationType.PRIVATE, 4, 1);
//            workstationsService.saveWorkstation("Bright private area for working, alone or in a team, away from noise and distractions.", WorkstationType.PRIVATE, 4, 2);
//            workstationsService.saveWorkstation("Bright private area for working, alone or in a team, away from noise and distractions.", WorkstationType.PRIVATE, 4, 3);
//            workstationsService.saveWorkstation("Bright open space in which to study, relax or work without feeling stuffy.", WorkstationType.OPENSPACE, 50, 1);
//            workstationsService.saveWorkstation("Bright open space in which to study, relax or work without feeling stuffy.", WorkstationType.OPENSPACE, 50, 2);
//            workstationsService.saveWorkstation("Bright open space in which to study, relax or work without feeling stuffy.", WorkstationType.OPENSPACE, 50, 2);
//            workstationsService.saveWorkstation("Bright open space in which to study, relax or work without feeling stuffy.", WorkstationType.OPENSPACE, 50, 3);
//            workstationsService.saveWorkstation("Bright open space in which to study, relax or work without feeling stuffy.", WorkstationType.OPENSPACE, 50, 3);
//            workstationsService.saveWorkstation("Bright open space in which to study, relax or work without feeling stuffy.", WorkstationType.OPENSPACE, 50, 4);
//            workstationsService.saveWorkstation("Spacious room in which to hold meetings with all the teams in your workforce.", WorkstationType.MEETING_ROOM, 20, 3);
//            workstationsService.saveWorkstation("Spacious room in which to hold meetings with all the teams in your workforce.", WorkstationType.MEETING_ROOM, 20, 4);
//            workstationsService.saveWorkstation("Spacious room in which to hold meetings with all the teams in your workforce.", WorkstationType.MEETING_ROOM, 20, 4);
        } catch (InvalidLenghtException e) {
            System.out.println(e.getMessage());
        }

        Workstation found1 = workstationsService.findById(1);
        Reservation found2 = reservationsService.findByWorkstationAndDate(found1, LocalDate.now().minusDays(14));
        System.out.println(found2);

        try {
            reservationsService.saveReservation(LocalDate.now().minusDays(14), 2, 1);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

    }
}
