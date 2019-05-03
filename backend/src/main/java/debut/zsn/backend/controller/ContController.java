package debut.zsn.backend.controller;

import debut.zsn.backend.dto.request.CreateContDTO;
import debut.zsn.backend.dto.request.DeleteContDTO;
import debut.zsn.backend.dto.response.ResponseMessageCont;
import debut.zsn.backend.model.Cont;
import debut.zsn.backend.services.ContServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cont")
public class ContController {
    @Autowired
    private ContServiceImpl contService;

    @PostMapping("/createNewCont")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createNewCont(@RequestBody CreateContDTO createContDTO){
        System.out.println("Username: " + createContDTO.getUsername());
        System.out.println("Id : " + createContDTO.getCurrencyId());

        ResponseEntity responseEntity = contService.save(createContDTO);

        return responseEntity;
    }

    @PostMapping("/deleteCont")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCont(@RequestBody DeleteContDTO deleteContDTO){
        return contService.save(deleteContDTO);
    }
}
