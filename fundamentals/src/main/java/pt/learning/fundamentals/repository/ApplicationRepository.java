package pt.learning.fundamentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.learning.fundamentals.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
