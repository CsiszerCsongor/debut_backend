package debut.zsn.backend.repository;

import debut.zsn.backend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByIsDeletedFalse();
    Optional<Country> findById(Long id);
}
