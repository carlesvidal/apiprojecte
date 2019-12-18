package org.hospital.projecte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<Users> findAll() {
        List<Users> listUsers= userDAO.findAll();
        return listUsers;
    }

    @Override
    public Users.User findById(int id) {
        Users.User user = userDAO.findById(id);
        return user;
    }

    @Override
    public void save(Users.User user) {
        userDAO.save(user);

    }

    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }

}