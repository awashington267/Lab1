package Project.DAO;

import hibernate.entity.Characters;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharactersDAOImpl implements CharactersDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Characters> getCharacters() {
        Session session = sessionFactory.getCurrentSession();
        List<Characters> list = session.createQuery("from Characters", Characters.class).getResultList();

        return list;
    }

    @Override
    public void saveCharacter(Characters character) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(character);
    }

    @Override
    public Characters getCharacters(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Characters.class, theId);
    }

    @Override
    public void deleteCharacter(int theId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Characters where characterID = :doomedCharacterId");

        query.setParameter("doomedCharacterId", theId);

        query.executeUpdate();

    }

    @Override
    public List<Characters> getCharacterByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        Query<Characters> query = session.createQuery("from Characters where lower(name) like :searchTerm");

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", theSearchTerm);

        return query.getResultList();
    }
}
