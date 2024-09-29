package lk.ijse.notetaker.Util;

import lk.ijse.notetaker.dto.impl.NoteDTO;
import lk.ijse.notetaker.dto.impl.UserDTO;
import lk.ijse.notetaker.entity.NoteEntity;
import lk.ijse.notetaker.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    /*spring ta kiayala  dto >> entity   &  entity  >> dto  */

    @Autowired
    private ModelMapper modelMapper;

    public NoteDTO convertToDTO(NoteEntity noteEntity){
        return modelMapper.map(noteEntity,NoteDTO.class);  /* meya auto karala denawa */
    }

    public NoteEntity convertToEntity(NoteDTO dto){
        return modelMapper.map(dto,NoteEntity.class);  /* meya auto karala denawa */
    }

    public List<NoteDTO> convertToDTOList(List<NoteEntity> notes){
        return modelMapper.map(notes,List.class);  /* meya auto karala denawa */
    }


    public UserDTO convertToUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity,UserDTO.class);
    }

    public UserEntity convertToUserEntity(UserDTO dto){
        return modelMapper.map(dto,UserEntity.class);
    }

    public List<UserDTO> convertToUserDTOList(List<UserEntity> users){
        return modelMapper.map(users,new TypeToken<List<UserDTO>>() {}.getType());
    }

}
