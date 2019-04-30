package debut.zsn.backend.dto.response;

import debut.zsn.backend.model.Cont;

public class UserToAdmin {
    private String firstName;
    private String lastName;
    private String street;
    private String telephone;
    private String cnp;
    private String serie;
    private int cnpNr;
    private int houseNumber;
    private int apartman;
    private String username;
    private String email;
    private ContToClient[] conts;

    public UserToAdmin(){};

    public UserToAdmin(String firstName, String lastName, String street, String telephone, String cnp, String serie, int cnpNr, int houseNumber, int apartman, String username, String email, ContToClient[] conts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.telephone = telephone;
        this.cnp = cnp;
        this.serie = serie;
        this.cnpNr = cnpNr;
        this.houseNumber = houseNumber;
        this.apartman = apartman;
        this.username = username;
        this.email = email;
        this.conts = conts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getCnpNr() {
        return cnpNr;
    }

    public void setCnpNr(int cnpNr) {
        this.cnpNr = cnpNr;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getApartman() {
        return apartman;
    }

    public void setApartman(int apartman) {
        this.apartman = apartman;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContToClient[] getConts() {
        return conts;
    }

    public void setConts(ContToClient[] conts) {
        this.conts = conts;
    }
}
