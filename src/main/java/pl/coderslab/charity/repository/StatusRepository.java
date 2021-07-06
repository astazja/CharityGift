package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
