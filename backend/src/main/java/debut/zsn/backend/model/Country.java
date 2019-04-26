package debut.zsn.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country extends BaseEntity{
    private String name;

    public Country(){}

    public Country(String name, boolean isDeleted){
        this.name = name;
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
