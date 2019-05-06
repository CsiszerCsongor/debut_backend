package debut.zsn.backend.services;

import debut.zsn.backend.model.City;
import debut.zsn.backend.model.Country;

import java.util.List;

public interface CityService {
    City save(City city);
    boolean save(List<City> cities);
    boolean existCity(String cityName);
    List<City> getAllUndeletedCity(Country country);
}
