package entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "MECHANIC")
public class Mechanic implements Serializable {


    private static final long serialVersionUID = 92646268961240179L;
    @Id
    @SequenceGenerator(name = "mechanic_seq_gen", sequenceName = "mechanic_seq_id", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mechanic_seq_gen")
    private long M_ID;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @OneToMany(mappedBy = "mechanic", fetch = FetchType.LAZY)
    private List<MaintenanceRecord> maintenanceRecord = new ArrayList<>();

    public Mechanic() {
    }

    public Mechanic(String firstname, String lastname) {
        setFirstname(firstname);
        setLastname(lastname);
    }

    public long getM_ID() {
        return M_ID;
    }

    public void setM_ID(long m_ID) {
        M_ID = m_ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<MaintenanceRecord> getMaintenanceRecord() {
        return maintenanceRecord;
    }

    public void setMaintenanceRecord(ArrayList<MaintenanceRecord> maintenanceRecord) {
        this.maintenanceRecord = maintenanceRecord;
    }
}
