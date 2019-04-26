package debut.zsn.backend.model;

import javax.persistence.*;

@Entity
@Table(name="cities")
public class City extends BaseEntity{
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="country_id", nullable = false)
    private Country country;

    public City(){}

    public City(String name, Country country, boolean isDeleted){
        this.name = name;
        this.country = country;
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

