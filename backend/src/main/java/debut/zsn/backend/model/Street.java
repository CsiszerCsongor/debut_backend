package debut.zsn.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="streets")
public class Street extends BaseEntity{
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="city_id", nullable = false)
    @JsonIgnore
    private City city;

    public Street(){}

    public Street(String name, City city, boolean isDeleted){
        this.name = name;
        this.city = city;
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
