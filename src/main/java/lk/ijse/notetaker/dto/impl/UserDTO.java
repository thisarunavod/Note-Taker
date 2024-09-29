package lk.ijse.notetaker.dto.impl;


import lk.ijse.notetaker.customObj.UserResponse;
import lk.ijse.notetaker.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDTO implements SuperDTO, UserResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePic;
}
