package lk.ijse.notetaker.service;

import jakarta.transaction.Transactional;
import jdk.jshell.execution.Util;
import lk.ijse.notetaker.Util.AppUtil;
import lk.ijse.notetaker.Util.Mapping;
import lk.ijse.notetaker.dao.NoteDao;
import lk.ijse.notetaker.dto.NoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


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

        return true;

    }

    @Override
    public boolean deleteNote(String noteId) {

        return true;

    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {
        return null;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return null;
    }

}
