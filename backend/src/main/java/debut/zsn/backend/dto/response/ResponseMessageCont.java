package debut.zsn.backend.dto.response;

import debut.zsn.backend.model.Cont;
import debut.zsn.backend.model.Currency;

public class ResponseMessageCont {
    private String message;
    private ContToClient cont;

    public ResponseMessageCont(String message, ContToClient currency) {
        this.message = message;
        this.cont = currency;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ContToClient getUser(){
        return cont;
    }

    public void setUser(ContToClient user){
        this.cont = user;
    }
}
