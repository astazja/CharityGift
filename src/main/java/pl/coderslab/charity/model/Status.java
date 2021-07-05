package pl.coderslab.charity.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Status implements Comparable<Status>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime update;

    @PrePersist
    private void create() {
        this.update = LocalDateTime.now();
    }
    @PreUpdate
    private void update() {
        this.update = LocalDateTime.now();
    }

    @Override
    public int compareTo(Status o) {
        if(this.status.equals(o.status)) {
            return this.update.compareTo(o.update);
        }else {
            return this.status.compareTo(o.status);
        }
    }
}
