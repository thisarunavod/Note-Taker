package lk.ijse.notetaker.service;

import lk.ijse.notetaker.customObj.UserResponse;
import lk.ijse.notetaker.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(String userId,UserDTO userDTO) ;
    void deleteUser( String userId );
    UserResponse getSelectedUser(String userId);
    List<UserDTO> getAllUser();
}
