package entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARPAT")
public class CarPart implements Serializable {


    private static final long serialVersionUID = 473001743622806351L;
    @Id
    @SequenceGenerator(name = "carpart_seq_gen", sequenceName = "carpart_seq_id", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carpart_seq_gen")
    private long CP_ID;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "carPart",fetch = FetchType.LAZY)
    private List<MaintenanceRecord> maintenanceRecord = new ArrayList<>();

    public CarPart() {
    }

    public CarPart(String name) {
        setName(name);
    }

    public long getCP_ID() {
        return CP_ID;
    }

    public void setCP_ID(long CP_ID) {
        this.CP_ID = CP_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MaintenanceRecord> getMaintenanceRecord() {
        return maintenanceRecord;
    }

    public void setMaintenanceRecord(ArrayList<MaintenanceRecord> maintenanceRecord) {
        this.maintenanceRecord = maintenanceRecord;
    }
}
