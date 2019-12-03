package Project.DAO;

import hibernate.entity.Class;

import java.util.List;

public interface ClassDAO {


    List<Class> getRole();

    void saveRole(Class role);

    Class getRole(int theId);

    void deleteRole(int theId);

    List<Class> getRoleByName(String theSearchTerm);
}
