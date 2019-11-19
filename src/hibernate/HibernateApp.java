package hibernate;

import hibernate.entity.*;
import hibernate.entity.Class;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import java.util.List;
import org.hibernate.cfg.Configuration;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp(){
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Characters.class)
                .addAnnotatedClass(Class.class)
                .buildSessionFactory();
    }

    public void close(){
        factory.close();
    }

    public static void main(String[] args) {
        HibernateApp app = new HibernateApp();

        try{
            app.deleteCharacter();

        }finally {
            app.close();
        }
    }

    private int createCharacter(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        Characters character = new Characters("Pearl", "", "F", "I love fame.");
        Class role = session.get(Class.class, 1);

        character.setClassID(role);
        session.save(character);

        System.out.println(character);

        session.getTransaction().commit();

        return character.getCharacterID();
    }

    private void readCharacter(int charId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Characters character = session.get(Characters.class, charId);

        System.out.println(character);

        session.getTransaction().commit();

    }

    public void updateCharacter(int charId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Characters character = session.get(Characters.class, charId);
        if (character != null)
            character.setName(character.getName().toUpperCase());
        System.out.println(character);

        session.getTransaction().commit();
    }

    public void deleteCharacter(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        session.createQuery("delete from Characters where name like '%Pearl%'").executeUpdate();


        session.getTransaction().commit();
    }

    private void listAllCharacters() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        List<Characters> list = session.createQuery("from Characters").getResultList();
        printCharactersList(list);

        session.getTransaction().commit();
    }

    private void printCharactersList(List<Characters> list) {
        if (list.isEmpty()) {
            System.out.println("No characters added in the list");
        } else {
            for (Characters character : list) {
                System.out.println(character);
            }
        }
    }

    private int createRole(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        Class role = new Class("Tank");


        session.save(role);

        System.out.println(role);

        session.getTransaction().commit();

        return role.getClassID();
    }

    public void readRole(int roleId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Class role = session.get(Class.class, roleId);

        System.out.println(role);

        session.getTransaction().commit();

    }

    public void updateRole(int roleId){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Class role = session.get(Class.class, roleId);
        if (role != null)
            role.setRole(role.getRole().toUpperCase());

        System.out.println(role);

        session.getTransaction().commit();

    }

    public void deleteRole(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        session.createQuery("delete from Class where name like 'NA'").executeUpdate();


        session.getTransaction().commit();

    }
}
