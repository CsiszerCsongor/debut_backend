package debut.zsn.backend.services;

import debut.zsn.backend.model.Role;
import debut.zsn.backend.model.RoleName;

import java.util.List;

public interface RoleService {
    boolean existRoleName(RoleName roleName);
    Role save(Role role);
    boolean save(List<Role> roles);
    List<Role> getAll();
}
