package debut.zsn.backend.services;

import debut.zsn.backend.model.Cont;
import debut.zsn.backend.repository.ContRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContServiceImpl implements ContService {
    @Autowired
    private ContRepository contRepository;


    @Override
    public boolean save(Cont cont) {
        return false;
    }
}
