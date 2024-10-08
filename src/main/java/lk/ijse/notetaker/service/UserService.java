package lk.ijse.notetaker.service;

import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.dto.UserDTO;

import java.util.List;

public interface UserService {
    String userData(UserDTO userDTO);
    boolean updateUser(String userId,UserDTO userDTO);
    boolean deleteUser( String userId );
    UserDTO getSelectedUser(String userId);
    List<NoteDTO> getAllUser();
}
