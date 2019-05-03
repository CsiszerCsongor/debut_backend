package debut.zsn.backend.controller;

import debut.zsn.backend.dto.request.UpdateDataDTO;
import debut.zsn.backend.dto.response.MainPageDataDTO;
import debut.zsn.backend.dto.response.UserToAdmin;
import debut.zsn.backend.model.Cont;
import debut.zsn.backend.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/checkTelephone")
    public boolean checkTelephone(@RequestBody String telephone){
        return userService.checkTelephone(telephone);
    }

    @PostMapping("/checkEmail")
    public boolean checkEmail(@RequestBody String email){
        return userService.checkEmail(email);
    }

    @PostMapping("/checkCNP")
    public boolean checkCNP(@RequestBody String cnp){
        return userService.checkCNP(cnp);
    }

    @PostMapping("/getUserOwnConts")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public MainPageDataDTO getMainPageDatas(@RequestBody String username){
        Cont[] conts = userService.getUserConts(username);
        return new MainPageDataDTO(username, conts);
    }

    @PostMapping("/getUserByCNP")
    @PreAuthorize("hasRole('ADMIN')")
    public UserToAdmin getUserByCNP(@RequestBody String cnp){
        System.out.println("CNP : " + cnp);
        return userService.getUserByCnp(cnp);
    }

    @PostMapping("/update/firstname")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateFirstName(@RequestBody UpdateDataDTO updateDataDTO){
        return userService.updateUserFirstName(updateDataDTO);
    }

    @PostMapping("/getOwnCNP")
    @PreAuthorize("hasRole('USER')")
    public String getOwnCNP(@RequestBody String username){
        return userService.getOwnCNP(username);
    }
}

