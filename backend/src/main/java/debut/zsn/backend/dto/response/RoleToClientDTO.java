package debut.zsn.backend.dto.response;

import debut.zsn.backend.model.Role;
import debut.zsn.backend.model.RoleName;

import java.util.ArrayList;
import java.util.List;

public class RoleToClientDTO {
    private Long id;
    private String name;

    public RoleToClientDTO(){}

    public RoleToClientDTO(Role role){
        this.id = role.getId();
        System.out.println("Role : " + role.toString() + "\nRole name : " + role.getName());
        if(role.getName() == RoleName.ROLE_ADMIN)
            name = "Admin";
        else
            name = "User";
    }

    public List<RoleToClientDTO> RoleListToClientDTO(List<Role> roles){
        List<RoleToClientDTO> tmpList = new ArrayList<>();

        for(int i = 0; i < roles.size(); ++i){
            tmpList.add(new RoleToClientDTO(roles.get(i)));
        }

        return tmpList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
