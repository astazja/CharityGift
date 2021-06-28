package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

import java.util.List;

public interface UserService {
    User findByUserEmail(String email);
    void saveUser(User user);
    void editUser(User user, String password, String confPass);
    User getUserById (Long id);
    List<User> findUsersByRole(String role);
    void saveAdmin(User user);
    void editAdmin(User user, String password);
}
