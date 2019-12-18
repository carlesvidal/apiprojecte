package org.hospital.projecte;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Users> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Users> theQuery = currentSession.createQuery("select id from User" , Users.class);

        List<Users> users = theQuery.getResultList();

        return users;

    }

    @Override
    public Users.User findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Users.User user = currentSession.get(Users.User.class, id);

        return user;
    }

    @Override
    public void save(Users.User user) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(user);

    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Users.User> theQuery = currentSession.createQuery("delete from User where id=:idUser");

        theQuery.setParameter("idUser", id);
        theQuery.executeUpdate();

    }


}
