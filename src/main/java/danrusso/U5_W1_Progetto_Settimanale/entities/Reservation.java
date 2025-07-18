package danrusso.U5_W1_Progetto_Settimanale.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "dates")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "usernames")
    private User userName;

    @ManyToOne
    @JoinColumn(name = "workstations")
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
