package debut.zsn.backend.services;

import debut.zsn.backend.dto.request.CreateContDTO;
import debut.zsn.backend.dto.request.DeleteContDTO;
import debut.zsn.backend.model.Cont;
import org.springframework.http.ResponseEntity;

public interface ContService {
    boolean save(Cont cont);
    String save(DeleteContDTO deleteContDTO);
    ResponseEntity<?> save(CreateContDTO createContDTO);
}
