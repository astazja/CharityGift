package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

public interface UserService {
    User findByUserEmail(String email);
    void saveUser(User user);
}
