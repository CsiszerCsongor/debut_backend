package debut.zsn.backend.services;

import debut.zsn.backend.model.City;
import debut.zsn.backend.model.Country;
import debut.zsn.backend.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepository cityRepository;

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public boolean save(List<City> cities) {
        for(int i = 0; i < cities.size(); ++i){
            City tmp = cityRepository.save(cities.get(i));
            if(tmp == null){
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean existCity(String cityName) {
        return cityRepository.existsByName(cityName);
    }

    @Override
    public List<City> getAllUndeletedCity(Country country) {
        return cityRepository.findByIsDeletedFalseAndCountry(country);
    }
}
