package DAO;

import hibernate.entity.Class;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDAOImpl implements ClassDAO{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Class> getRole() {
        Session session = sessionFactory.getCurrentSession();
        List<Class> list = session.createQuery("from Class", Class.class).getResultList();

        return list;
    }

    @Override
    public void saveRole(Class role) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(role);
    }

    @Override
    public Class getRole(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Class.class, theId);
    }

    @Override
    public void deleteRole(int theId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Class where classID = :doomedClassId");

        query.setParameter("doomedClassId", theId);

        query.executeUpdate();
    }

    @Override
    public List<Class> getRoleByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        Query<Class> query = session.createQuery("from Class where lower(role) like :searchTerm");

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", theSearchTerm);

        return query.getResultList();
    }
}
