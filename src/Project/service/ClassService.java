package Project.service;

import hibernate.entity.Class;

import java.util.List;

public interface ClassService {

    List<Class> getRole();

    Class getRole(int theId);

    void deleteRole(int theId);

    List<Class> getRoleByName(String theSearchTerm);
}
