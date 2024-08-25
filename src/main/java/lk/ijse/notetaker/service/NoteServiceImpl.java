package lk.ijse.notetaker.service;

import lk.ijse.notetaker.Util.AppUtil;
import lk.ijse.notetaker.dto.NoteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service               /*  <------  Spring ta baradenawa  */
public final class NoteServiceImpl implements NoteService {

    List<NoteDTO> saveNoteTemp = new ArrayList();
    public NoteServiceImpl( ){
        saveNoteTemp.add(new NoteDTO("NOTE 323524023r", "Sport", "Injury", "Advanced", "2024-8-25"));
        saveNoteTemp.add(new NoteDTO("NOTE 323524024r", "Sport", "Injury", "Advanced", "2024-8-26"));
        saveNoteTemp.add(new NoteDTO("NOTE 323524025r", "Sport", "Injury", "Advanced", "2024-8-27"));
        saveNoteTemp.add(new NoteDTO("NOTE 323524026r", "Sport", "Injury", "Advanced", "2024-8-28"));
    }

    @Override
    public String saveData(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteID());
        saveNoteTemp.add(noteDTO);
        System.out.println(noteDTO);
        return "Save Note on BO Layer Successfully !!";
    }

    @Override
    public boolean updateNote(String noteId, NoteDTO noteDTO) {
        /*return false;*/
        return noteDTO != null;

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

        return saveNoteTemp ;
    }
}
