package debut.zsn.backend.dto.request;

public class UpdateDataDTO {
    private String userCnp;
    private String dataString;
    private int dataNumber;

    public UpdateDataDTO() {}

    public UpdateDataDTO(String userCnp, String dataString, int dataNumber) {
        this.userCnp = userCnp;
        this.dataString = dataString;
        this.dataNumber = dataNumber;
    }

    public String getUserCnp() {
        return userCnp;
    }

    public void setUserCnp(String userCnp) {
        this.userCnp = userCnp;
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public int getDataNumber() {
        return dataNumber;
    }

    public void setDataNumber(int dataNumber) {
        this.dataNumber = dataNumber;
    }
}
