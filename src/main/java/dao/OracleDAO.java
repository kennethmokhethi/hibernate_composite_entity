package dao;

import entity.CarPart;
import entity.MaintenanceRecord;
import entity.Mechanic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class OracleDAO implements DAO {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public Session session = null;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getActiveTransaction() {
        this.session = sessionFactory.openSession();
        return this.session.beginTransaction();
    }

    public MaintenanceRecord saveRecord(MaintenanceRecord record) {
        session.persist(record);
        return record;
    }


    public List<CarPart> getCarPartByMechanicName(String mechanicname) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarPart> criteriaQuery = criteriaBuilder.createQuery(CarPart.class);

        Root<CarPart> fromCarpat = criteriaQuery.from(CarPart.class);
        Root<MaintenanceRecord> frommainternaceRec = criteriaQuery.from(MaintenanceRecord.class);

        Join<MaintenanceRecord, Mechanic> maintenanceRecordMechanicJoin = frommainternaceRec.join("mechanic", JoinType.INNER);

        List<Predicate> conditions = new ArrayList<>();
        conditions.add(criteriaBuilder.equal(maintenanceRecordMechanicJoin.get("firstname"), mechanicname));

        List<CarPart> returnvalue;
        returnvalue = session.createQuery(criteriaQuery
                .select(fromCarpat)
                .where(conditions.toArray(new Predicate[]{}))).getResultList();
        return returnvalue;

    }

}
