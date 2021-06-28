package pl.coderslab.charity.service.implementation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class ImplUserService implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ImplUserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnable(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public void editUser(User user, String password, String confPass) {
        User change = userRepository.findById(user.getId()).get();
        if(!password.isBlank() && password.equals(confPass)) {
            user.setPassword(passwordEncoder.encode(password));
        }else {
            user.setPassword(change.getPassword());
        }
        user.setEmail(change.getEmail());
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> findUsersByRole(String role) {
        Role roles = roleRepository.findByName(role);
        List<User> admins = userRepository.findAllByRolesIn(Arrays.asList(roles));
        admins.forEach(r->r.getRoles().size());
        return admins;
    }

    @Override
    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnable(1);
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(adminRole)));
        userRepository.save(user);
    }

    @Override
    public void editAdmin(User user, String password) {
        User change = userRepository.findById(user.getId()).get();
        if(!password.isBlank()) {
            user.setPassword(passwordEncoder.encode(password));
        }else {
            user.setPassword(change.getPassword());
        }
        user.setEmail(change.getEmail());
        user.setEnable(change.getEnable());
        user.setRoles(change.getRoles());
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

}
