package debut.zsn.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="currencies")
public class Currency extends BaseEntity {
    private String name;

    public Currency(){}

    public Currency(String name) {
        this.name = name;
        this.isDeleted = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
