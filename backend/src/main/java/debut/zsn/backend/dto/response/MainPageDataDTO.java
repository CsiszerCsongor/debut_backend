package debut.zsn.backend.dto.response;

import debut.zsn.backend.model.Cont;

public class MainPageDataDTO {
    private String username;
    private Cont[] conts;

    public MainPageDataDTO(){}

    public MainPageDataDTO(String username, Cont[] conts){
        this.username = username;
        this.conts = conts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Cont[] getConts() {
        return conts;
    }

    public void setConts(Cont[] conts) {
        this.conts = conts;
    }
}
