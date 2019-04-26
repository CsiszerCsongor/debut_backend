package debut.zsn.backend.controller;

import debut.zsn.backend.dto.response.RoleToClientDTO;
import debut.zsn.backend.model.Role;
import debut.zsn.backend.services.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/getAll")
    public List<RoleToClientDTO> getAllRoles(){
        return new RoleToClientDTO().RoleListToClientDTO(roleService.getAll());
    }
}
