package lk.ijse.notetaker.controller;

import lk.ijse.notetaker.customObj.NoteResponse;
import lk.ijse.notetaker.exeption.DataPersistFailedException;
import lk.ijse.notetaker.exeption.NoteNotFoundException;
import lk.ijse.notetaker.service.NoteService;
import lk.ijse.notetaker.dto.impl.NoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/notes")
@RestController
public class DemoController {

    @Autowired
    private NoteService noteService;

    //To do CRUD Opertations
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNote(@RequestBody NoteDTO note){
        //To do Handle with BO
        if (note ==null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            noteService.saveData(note);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "allNotes",produces = MediaType.APPLICATION_JSON_VALUE)  /* jackson tmy object bind karanne */
    public List<NoteDTO> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)  /*  */
    public NoteResponse getNote(@PathVariable("noteId") String noteId){

        return noteService.getSelectedNote(noteId);
    }

    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateNote(@PathVariable("noteId") String noteId , @RequestBody NoteDTO note){

        try {

            if (note == null && (noteId == null || note.equals(""))){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            noteService.updateNote(noteId, note);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NoteNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable ("noteId") String noteId) {

        try {
            noteService.deleteNote(noteId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoteNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
