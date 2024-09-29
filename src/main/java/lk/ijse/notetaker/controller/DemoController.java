package lk.ijse.notetaker.controller;

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

    @GetMapping("health")   /* Application eka run completely run wenawada kiyala balanawaa*/
    public String healthCheck(){
        return "note taker is running";
    }

    //To do CRUD Opertations
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO note){
        //To do Handle with BO
        var saveData = noteService.saveData(note);
        return ResponseEntity.ok(saveData);
    }

    @GetMapping(value = "allNotes",produces = MediaType.APPLICATION_JSON_VALUE)  /* jackson tmy object bind karanne */
    public List<NoteDTO> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)  /*  */
    public NoteDTO getNote(@PathVariable("noteId") String noteId){
        System.out.println(noteId);
        return noteService.getSelectedNote(noteId);
    }

    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateNote(@PathVariable("noteId") String noteId , @RequestBody NoteDTO note){

        /*return noteService.updateNote(noteId,note) ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
        try {
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
    public ResponseEntity<String> deleteNote(@PathVariable ("noteId") String noteId) {
//        System.out.println(noteId + " Deleted");
         /*if (noteService.deleteNote(noteId)) return ResponseEntity.ok(noteId + " is Deleted !! ");
         else {
             return ResponseEntity.ok(noteId+ "  is not registered ");
         }*/

        return noteService.deleteNote(noteId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
