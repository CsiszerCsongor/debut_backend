package debut.zsn.backend.dto.response;

import debut.zsn.backend.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityToClientDTO {
    private Long id;
    private String name;
    private Long countryId;

    public CityToClientDTO(){ }

    public CityToClientDTO(City city) {
        this.id  = city.getId();
        this.name = city.getName();
        this.countryId = city.getCountry().getId();
    }

    public List<CityToClientDTO> changeCityListToCityDTO(List<City> cities){
        List<CityToClientDTO> tmpList = new ArrayList<>();

        for(int i = 0; i < cities.size(); ++i){
            tmpList.add(new CityToClientDTO(cities.get(i)));
        }

        return tmpList;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
