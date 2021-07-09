package pl.coderslab.charity.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
public class Status implements Comparable<Status>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updated;

    @PrePersist
    private void create() {
        this.updated = LocalDateTime.now();
    }
    @PreUpdate
    private void update() {
        this.updated = LocalDateTime.now();
    }

    @Override
    public int compareTo(Status o) {
        if(this.status.equals(o.status)) {
            return this.updated.compareTo(o.updated);
        }else {
            return this.status.compareTo(o.status);
        }
    }
    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return this.updated.format(formatter);
    }
    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return this.updated.format(formatter);
    }
}
