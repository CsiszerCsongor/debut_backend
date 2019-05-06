package debut.zsn.backend.repository;

import debut.zsn.backend.model.City;
import debut.zsn.backend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    boolean existsByName(String cityName);
    List<City> findByIsDeletedFalseAndCountry(Country country);
    City findCityById(Long id);
}
