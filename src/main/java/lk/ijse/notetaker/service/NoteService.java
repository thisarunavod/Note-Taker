package lk.ijse.notetaker.service;

import lk.ijse.notetaker.customObj.NoteResponse;
import lk.ijse.notetaker.dto.impl.NoteDTO;

import java.util.List;

public  interface NoteService  {

    void saveData(NoteDTO noteDTO);
    void updateNote(String noteId,NoteDTO noteDTO);
    void deleteNote( String noteId );
    NoteResponse getSelectedNote(String noteId);
    List<NoteDTO> getAllNotes();



}
