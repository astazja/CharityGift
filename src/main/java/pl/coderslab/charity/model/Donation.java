package pl.coderslab.charity.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nie podano liczby worków do przekazania.")
    @Range(min = 1, message = "Liczba worków nie może być mniejsza niż 1.")
    private Integer quantity;
    @ManyToMany
    @Size(min = 1, message = "Nie wybrano kategorii przekazanych rzeczy.")
    private List<Category> categories;
    @ManyToOne
    @NotNull(message = "Nie wybrano instytucji, którą chce się wesprzeć.")
    private Institution institution;
    @NotBlank(message = "Nie podano ulicy.")
    private String street;
    @NotBlank(message = "Nie podano miasta.")
    private String city;
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}", message = "Niepoprawny kod pocztowy.")
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    private String pickUpComment;
    @ManyToOne
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime created;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Status status;

    @PrePersist
    private void create() {
        this.created = LocalDateTime.now();
    }
}
