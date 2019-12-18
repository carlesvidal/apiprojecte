package org.hospital.projecte;

import java.util.List;

public interface UserDAO {

    public List<Users> findAll();

    public Users.User findById(int id);

    public void save(Users.User user);

    public void deleteById(int id);

}
