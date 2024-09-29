package lk.ijse.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.notetaker.Util.AppUtil;
import lk.ijse.notetaker.Util.Mapping;
import lk.ijse.notetaker.customObj.NoteErrorResponse;
import lk.ijse.notetaker.customObj.NoteResponse;
import lk.ijse.notetaker.customObj.UserErrorResponse;
import lk.ijse.notetaker.dao.NoteDao;
import lk.ijse.notetaker.dto.impl.NoteDTO;
import lk.ijse.notetaker.entity.NoteEntity;
import lk.ijse.notetaker.exeption.DataPersistFailedException;
import lk.ijse.notetaker.exeption.NoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service               /*  <------  Spring ta baradenawa  */
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private Mapping mapping;


    @Override
    public void saveData(NoteDTO noteDTO) {

        noteDTO.setNoteId(AppUtil.createNoteID());
        var noteEntity = noteDao.save(mapping.convertToEntity(noteDTO));
        if (noteEntity == null) throw new DataPersistFailedException("Cannot Saved Note");

    }

    @Override
    public void updateNote(String noteId, NoteDTO noteDTO) {
        Optional<NoteEntity> tmpNoteEntity = noteDao.findById(noteId);  /* null point exeption natara karaganna tmy meka karanne*/

        if ( !tmpNoteEntity.isPresent() )  throw new NoteNotFoundException("Note Not found Exeption");

        tmpNoteEntity.get().setNoteDesc(noteDTO.getNoteDesc());
        tmpNoteEntity.get().setNoteTitle(noteDTO.getNoteTitle());
        tmpNoteEntity.get().setCreatDate(noteDTO.getCreatDate());
        tmpNoteEntity.get().setPriorityLevel(noteDTO.getPriorityLevel());

    }

    @Override
    public void deleteNote(String noteId) {

        Optional<NoteEntity> findId = noteDao.findById(noteId);
        if (!findId.isPresent()) throw new NoteNotFoundException("Note Not found Exeption");
        noteDao.deleteById(noteId);

    }

    @Override
    public NoteResponse getSelectedNote(String noteId) {

        if (noteDao.existsById(noteId)) return mapping.convertToDTO(noteDao.getReferenceById(noteId));
        return new NoteErrorResponse(0, "Note not found");

    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return mapping.convertToDTOList(noteDao.findAll());
    }

}
