package pt.learning.fundamentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.learning.fundamentals.entity.Application;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<Application> findByName(final String name);

    void deleteByName(final String name);
}
