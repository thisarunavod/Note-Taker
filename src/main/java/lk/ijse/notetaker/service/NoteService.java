package lk.ijse.notetaker.service;

import lk.ijse.notetaker.dto.NoteDTO;

import java.util.List;

public sealed interface NoteService permits NoteServiceImpl {

    String saveData(NoteDTO noteDTO);
    boolean updateNote(String noteId,NoteDTO noteDTO);
    boolean deleteNote( String noteId );

    NoteDTO getSelectedNote(String noteId);

    List<NoteDTO> getAllNotes();



}
