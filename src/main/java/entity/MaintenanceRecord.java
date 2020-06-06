package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MAINTENANCERECORD")
public class MaintenanceRecord implements Serializable {

    @Id
    @SequenceGenerator(name = "maintenanceRec_seq_gen", sequenceName = "maintenanceRec_seq_id", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "maintenanceRec_seq_gen")
    private long MR_ID;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CP_ID", referencedColumnName = "CP_ID")
    private CarPart carPart;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "M_ID", referencedColumnName = "M_ID")
    private Mechanic mechanic;


    public long getMR_ID() {
        return MR_ID;
    }

    public void setMR_ID(long MR_ID) {
        this.MR_ID = MR_ID;
    }


    public CarPart getCarPart() {
        return carPart;
    }

    public void setCarPart(CarPart carPart) {
        this.carPart = carPart;
    }


    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

}
