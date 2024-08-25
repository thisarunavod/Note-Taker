package lk.ijse.notetaker.service;

import lk.ijse.notetaker.Util.AppUtil;
import lk.ijse.notetaker.dto.NoteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


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

        /*for (NoteDTO dto: saveNoteTemp) {
            if (dto.getNoteId().equals(noteId)) {

                dto.setNoteTitle(noteDTO.getNoteTitle());
                dto.setNoteDesc(noteDTO.getNoteDesc());
                dto.setPriorityLevel(noteDTO.getPriorityLevel());
                dto.setCreatDate(noteDTO.getCreatDate());

                System.out.println(dto);
                return true;
            }
        }
        return false;*/

        /*This is a Safe Method*/
        ListIterator<NoteDTO> updatedList = saveNoteTemp.listIterator();
        while (updatedList.hasNext()) {
            NoteDTO dto = updatedList.next();
            if (noteId.equals(dto.getNoteId())) {
                noteDTO.setNoteId(dto.getNoteId());
                updatedList.set(noteDTO);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteNote(String noteId) {


        /*for (NoteDTO noteDTO : saveNoteTemp) {
            if (noteDTO.getNoteId().equals(noteId)) {
                saveNoteTemp.remove(noteDTO);
                System.out.println(saveNoteTemp.size());
                return true;
            }
        }
        return false;*/

        /* this is a Safe Method */
        ListIterator<NoteDTO> tmpList = saveNoteTemp.listIterator();
        while (tmpList.hasNext()) {
            NoteDTO noteDTO = tmpList.next();
            if (noteId.equals(noteDTO.getNoteId())) {
                tmpList.remove();
                return true;
            }
        }
         return false;
    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {

        NoteDTO noteDTO = new NoteDTO();
        for (int i = 0; i < saveNoteTemp.size(); i++) {
            if (saveNoteTemp.get(i).getNoteId().equals(noteId))  noteDTO = saveNoteTemp.get(i);
        }
        return noteDTO;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return saveNoteTemp ;
    }

}
