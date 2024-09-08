package lk.ijse.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.notetaker.Util.AppUtil;
import lk.ijse.notetaker.Util.Mapping;
import lk.ijse.notetaker.dao.UserDao;
import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.dto.UserDTO;
import lk.ijse.notetaker.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserDao userDao;

    @Autowired
    private Mapping mapping;

    @Override
    public String saveUser(UserDTO userDTO) {
        userDTO.setUserId(AppUtil.createUserID());
        userDao.save(mapping.convertToUserEntity(userDTO));
        return "User Saved Successfully !! ";
    }

    @Override
    public boolean updateUser(String userId, UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        /*if (noteDao.existsById(noteId)) {noteDao.deleteById(noteId); return true;}
        return false;*/

        if ( userDao.existsById(userId)) { userDao.deleteById(userId); return true;} return false;
    }

    @Override
    public UserDTO getSelectedUser(String userId) {
        return null;
    }

    @Override
    public List<NoteDTO> getAllUser() {
        return null;
    }
}
