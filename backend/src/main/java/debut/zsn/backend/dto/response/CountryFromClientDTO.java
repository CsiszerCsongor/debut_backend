package debut.zsn.backend.dto.response;

import debut.zsn.backend.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryFromClientDTO {
    private Long id;
    private String name;

    public CountryFromClientDTO(){}

    public CountryFromClientDTO(Country country){
        this.id = country.getId();
        this.name = country.getName();
    }

    public List<CountryFromClientDTO> changeCountriesToDTO(List<Country> countries){
        ArrayList<CountryFromClientDTO> tmpList = new ArrayList<>();

        for(int i = 0; i < countries.size(); ++i){
            tmpList.add(new CountryFromClientDTO(countries.get(i)));
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
}
