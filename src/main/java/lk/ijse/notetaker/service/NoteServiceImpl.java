package lk.ijse.notetaker.service;

import jakarta.transaction.Transactional;
import jdk.jshell.execution.Util;
import lk.ijse.notetaker.Util.AppUtil;
import lk.ijse.notetaker.Util.Mapping;
import lk.ijse.notetaker.dao.NoteDao;
import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.entity.NoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;


@Service               /*  <------  Spring ta baradenawa  */
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private Mapping mapping;


    @Override
    public String saveData(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteID());
        noteDao.save(mapping.convertToEntity(noteDTO));
        return "Note Save Successfully !!" ;
    }

    @Override
    public boolean updateNote(String noteId, NoteDTO noteDTO) {
        Optional<NoteEntity> tmpNoteEntity = noteDao.findById(noteId);  /* null point exeption natara karaganna tmy meka karanne*/

        if ( !tmpNoteEntity.isPresent() ) return false ;


        tmpNoteEntity.get().setNoteDesc(noteDTO.getNoteDesc());
        tmpNoteEntity.get().setNoteTitle(noteDTO.getNoteTitle());
        tmpNoteEntity.get().setCreatDate(noteDTO.getCreatDate());
        tmpNoteEntity.get().setPriorityLevel(noteDTO.getPriorityLevel());
        return true;

    }

    @Override
    public boolean deleteNote(String noteId) {

        if (noteDao.existsById(noteId)) {noteDao.deleteById(noteId); return true;}
        return false;

    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {

        return mapping.convertToDTO(noteDao.getReferenceById(noteId));

    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return mapping.convertToDTOList(noteDao.findAll());
    }

}
