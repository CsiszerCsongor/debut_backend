package debut.zsn.backend.services;

import debut.zsn.backend.model.Street;

public interface StreetService {
    Street save(Street street);
    Street findStreetById(Long id);
}
