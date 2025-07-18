package danrusso.U5_W1_Progetto_Settimanale.entities;

import danrusso.U5_W1_Progetto_Settimanale.enums.WorkstationType;
import jakarta.persistence.*;

@Entity
@Table(name = "workstations")
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @Column(name = "workstation_type")
    @Enumerated(EnumType.STRING)
    private WorkstationType type;
    @Column(name = "maximum_guests")
    private int maxGuests;

    @ManyToOne
    private Building building;

    public Workstation() {
    }

    public Workstation(String description, WorkstationType type, int maxGuests, Building building) {
        this.description = description;
        this.type = type;
        this.maxGuests = maxGuests;
        this.building = building;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WorkstationType getType() {
        return type;
    }

    public void setType(WorkstationType type) {
        this.type = type;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
