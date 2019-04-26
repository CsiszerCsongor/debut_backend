package debut.zsn.backend.services;

import debut.zsn.backend.model.Street;
import debut.zsn.backend.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetRepository streetRepository;

    @Override
    public Street save(Street street) {
        return streetRepository.save(street);
    }

    @Override
    public Street findStreetById(Long id) {
        return streetRepository.findStreetById(id);
    }
}
