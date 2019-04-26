package debut.zsn.backend.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginDTO {
    @NotBlank
    @Size(min=8, max = 8)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}