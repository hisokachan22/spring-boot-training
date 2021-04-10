package pt.learning.fundamentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.learning.fundamentals.entity.Release;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {
}
