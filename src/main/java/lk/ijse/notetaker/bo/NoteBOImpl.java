package lk.ijse.notetaker.bo;

import lk.ijse.notetaker.Util.AppUtil;
import lk.ijse.notetaker.dto.NoteDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service               /*  <------  Spring ta baradenawa  */
public final class NoteBOImpl implements NoteBO {
    @Override
    public String saveData(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteID());
        System.out.println(noteDTO);
        return "Save Note on BO Layer";
    }

    @Override
    public boolean updateNote(String noteId, NoteDTO noteDTO) {
        /*return false;*/
        return noteDTO == null;

    }

    @Override
    public boolean deleteNote(String noteId) {
        return false;
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
