package danrusso.U5_W1_Progetto_Settimanale.entities;

import java.time.LocalDate;

public class Reservation {
    private long id;
    private LocalDate date;
    private User userName;
    private Workstation workstation;

    public Reservation() {
    }

    public Reservation(LocalDate date, User userName, Workstation workstation) {
        this.date = date;
        this.userName = userName;
        this.workstation = workstation;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    public Workstation getWorkstation() {
        return workstation;
    }

    public void setWorkstation(Workstation workstation) {
        this.workstation = workstation;
    }
}
