package pl.coderslab.charity.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=2, message = "Nie podano imienia")
    private String firstName;
    @Size(min=2, message = "Nie podano nazwiska")
    private String lastName;
    @Email(message = "Błędny email")
    @Column(nullable = false, unique = true)
    private String email;
    @Size(min = 6, message = "Za krótkie hasło, minimalna ilość znaków: 6")
    private String password;
    private Integer enable;
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Role> roles;
}
