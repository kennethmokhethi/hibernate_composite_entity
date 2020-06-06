package dao;

import entity.CarPart;
import entity.MaintenanceRecord;
import entity.Mechanic;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class OracleDAOTest {

    private static DAO database;

    @BeforeClass
    public static void initialize() {
        database = new OracleSub();
    }


    @Test
    public void saveRecord() {

        Transaction transaction = database.getActiveTransaction();
        MaintenanceRecord result = null;
        try {
            MaintenanceRecord record = new MaintenanceRecord();
            record.setMechanic(new Mechanic("Katlego", "Nkosi"));
            record.setCarPart(new CarPart("Engine2"));
            result = database.saveRecord(record);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        assertEquals("Engine2", result.getCarPart().getName());
    }


    @Test
    public void getCarPartByMechanicName() {
        Transaction transaction = database.getActiveTransaction();
        List<CarPart> result = null;
        try {
            MaintenanceRecord record2 = new MaintenanceRecord();
            record2.setMechanic(new Mechanic("Sipho", "John"));
            record2.setCarPart(new CarPart("Tires"));
             database.saveRecord(record2);
             result = database.getCarPartByMechanicName("Sipho");
             transaction.commit();

        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        assertEquals("Tires",result.get(1).getName());

    }
}
