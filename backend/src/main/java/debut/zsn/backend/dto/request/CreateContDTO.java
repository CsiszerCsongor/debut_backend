package debut.zsn.backend.dto.request;

public class CreateContDTO {
    private String username;
    private Long currencyId;

    public CreateContDTO() {}

    public CreateContDTO(String username, Long currencyId) {
        this.username = username;
        this.currencyId = currencyId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }
}
