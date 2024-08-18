package lk.ijse.notetaker.controller;

import lk.ijse.notetaker.Util.AppUtil;
import lk.ijse.notetaker.bo.NoteBO;
import lk.ijse.notetaker.dto.NoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("api/v1/notes")
@RestController
public class DemoController {

    @Autowired
    private NoteBO noteBO;

    //To do CRUD Opertations
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO note){
        //To do Handle with BO
        var saveData = noteBO.saveData(note);
        return ResponseEntity.ok(saveData);
    }

    @GetMapping(value = "allNotes",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes(){
        return null;
    }

    @GetMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO getNote(@PathVariable("noteId") String noteId){
        System.out.println(noteId);
        return null;
    }

    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateNote(@PathVariable("noteId") String noteId , @RequestBody NoteDTO note){
        System.out.println(noteId);
        System.out.println(note+ " Updated");
    }
    @DeleteMapping(value = "/{noteId}")
    public void deleteNote(@PathVariable ("noteId") String noteId) {
        System.out.println(noteId + " Deleted");
    }

}
