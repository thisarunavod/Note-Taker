package lk.ijse.notetaker.controller;

import jdk.jshell.execution.Util;
import lk.ijse.notetaker.Util.AppUtil;
import lk.ijse.notetaker.dto.UserDTO;
import lk.ijse.notetaker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    //Save User
    @PostMapping (consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("password") String password,
            @RequestPart("email") String email,
            @RequestPart("profilePic") String profilePic) {


        // Handle profile picture
        String base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic); /* <--- converting to base64 format*/

        // build the user
        UserDTO buildUserDTO = new UserDTO();
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setPassword(password);
        buildUserDTO.setEmail(email);
        buildUserDTO.setProfilePic(base64ProfilePic);

        //Send to service layer
        return new ResponseEntity<>(userService.saveUser(buildUserDTO), HttpStatus.CREATED);

    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String userId) {
         return userService.deleteUser(userId) ?
                 new ResponseEntity<>(HttpStatus.NO_CONTENT)
                 : new ResponseEntity<>(HttpStatus.NOT_FOUND) ;

    }
}
