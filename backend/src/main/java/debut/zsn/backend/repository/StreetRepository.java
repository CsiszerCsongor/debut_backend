package debut.zsn.backend.repository;

import debut.zsn.backend.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {
    Street findStreetById(Long id);
}
