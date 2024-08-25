package lk.ijse.notetaker.controller;

import lk.ijse.notetaker.service.NoteService;
import lk.ijse.notetaker.dto.NoteDTO;
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
    public ResponseEntity<String> createNote(@RequestBody NoteDTO note){
        //To do Handle with BO
        var saveData = noteService.saveData(note);
        return ResponseEntity.ok(saveData);
    }

    @GetMapping(value = "allNotes",produces = MediaType.APPLICATION_JSON_VALUE)  /* */
    public List<NoteDTO> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO getNote(@PathVariable("noteId") String noteId){
        System.out.println(noteId);
        return noteService.getSelectedNote(noteId);
    }

    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateNote(@PathVariable("noteId") String noteId , @RequestBody NoteDTO note){

        boolean updateNote = noteService.updateNote(noteId,note);
        if(updateNote) System.out.println(noteId +" : Updated Successfully !!");

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{noteId}")
    public void deleteNote(@PathVariable ("noteId") String noteId) {
//        System.out.println(noteId + " Deleted");
         if (noteService.deleteNote(noteId)) System.out.println(noteId +" : is Deleted");
         else {
             System.out.println("Not Identfied this ID");
         }
    }

}
