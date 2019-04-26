package debut.zsn.backend.controller;

import debut.zsn.backend.dto.request.LoginDTO;
import debut.zsn.backend.dto.request.SignUpDTO;
import debut.zsn.backend.dto.response.JwtResponse;
import debut.zsn.backend.dto.response.ResponseMessage;
import debut.zsn.backend.model.Role;
import debut.zsn.backend.model.RoleName;
import debut.zsn.backend.model.User;
import debut.zsn.backend.repository.RoleRepository;
import debut.zsn.backend.repository.UserRepository;
import debut.zsn.backend.security.jwt.JwtProvider;
import debut.zsn.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
    AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
    PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpDTO signUpRequest) {
		System.out.println(signUpRequest.toString());
		System.out.println("firstName : " + signUpRequest.getFirstName());
		System.out.println("lastName : " + signUpRequest.getLastName());
		System.out.println("city : " + signUpRequest.getCity());
		System.out.println("street : " + signUpRequest.getStreet());
		System.out.println("telephone : " + signUpRequest.getTelephone());
		System.out.println("cnp : " + signUpRequest.getCnp());
		System.out.println("serie : " + signUpRequest.getSerie());
		System.out.println("cnpNr : " + signUpRequest.getCnpNr());
		System.out.println("houseNumber : " + signUpRequest.getHouseNumber());
		System.out.println("apartman : " + signUpRequest.getApartman());
		System.out.println("email : " + signUpRequest.getEmail());
		System.out.println("role : " + signUpRequest.getRole());
		System.out.println("password : " + signUpRequest.getPassword());

		return userService.save(signUpRequest);
		//return new ResponseEntity<>(new ResponseMessage("User registered successfully!", new User()), HttpStatus.OK);
	}
}
