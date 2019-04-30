package debut.zsn.backend.services;

import debut.zsn.backend.dto.request.SignUpDTO;
import debut.zsn.backend.dto.response.UserToAdmin;
import debut.zsn.backend.model.Cont;
import debut.zsn.backend.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save();

    User save(User item);

    ResponseEntity<?> save(SignUpDTO item);

    Optional<User> findByUsername(String username);

    User getCity(Long index);

    User update(User item);

    void delete(User item);

    List<User> getAll();

    boolean checkTelephone(String telephone);

    boolean checkEmail(String email);

    boolean checkCNP(String cnp);

    Cont[] getUserConts(String username);

    UserToAdmin getUserByCnp(String cnp);
}
