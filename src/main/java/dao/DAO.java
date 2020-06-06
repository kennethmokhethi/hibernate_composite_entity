package dao;

import entity.CarPart;
import entity.MaintenanceRecord;
import entity.Mechanic;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public interface DAO {
    Session getSession();

    Transaction getActiveTransaction();

    MaintenanceRecord saveRecord(MaintenanceRecord record);

    List<CarPart> getCarPartByMechanicName(String mechanicname);


}
