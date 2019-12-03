package Project.service;


import Project.DAO.ClassDAO;
import hibernate.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    private ClassDAO classDAO;


    @Override
    @Transactional
    public List<Class> getRole() {
        return classDAO.getRole();
    }


    @Override
    @Transactional
    public Class getRole(int theId) {
        return classDAO.getRole(theId);
    }

    @Override
    @Transactional
    public void deleteRole(int theId) {
        classDAO.deleteRole(theId);
    }

    @Override
    @Transactional
    public List<Class> getRoleByName(String theSearchTerm) {
        return classDAO.getRoleByName(theSearchTerm);
    }
}
