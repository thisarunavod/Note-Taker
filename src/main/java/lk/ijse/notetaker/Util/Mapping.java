package lk.ijse.notetaker.Util;

import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.entity.NoteEntity;
import org.modelmapper.ModelMapper;
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

    /*public List<NoteEntity> convertToEntityList(List<NoteDTO> list){
        return modelMapper.map(list,List.class);  *//* meya auto karala denawa *//*
    }*/
}
