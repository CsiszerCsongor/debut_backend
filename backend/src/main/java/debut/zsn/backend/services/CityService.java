package debut.zsn.backend.services;

import debut.zsn.backend.model.City;
import debut.zsn.backend.model.Country;

import java.util.List;

public interface CityService {
    List<City> getAllUndeletedCity(Country country);
}
