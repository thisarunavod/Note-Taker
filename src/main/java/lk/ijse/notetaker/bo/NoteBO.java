package lk.ijse.notetaker.bo;

import lk.ijse.notetaker.dto.NoteDTO;

import java.util.List;

public sealed interface NoteBO permits NoteBOImpl{

    String saveData(NoteDTO noteDTO);
    boolean updateNote(String noteId,NoteDTO noteDTO);
    boolean deleteNote( String noteId );

    NoteDTO getSelectedNote(String noteId);

    List<NoteDTO> getAllNotes();



}
