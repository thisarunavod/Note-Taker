package lk.ijse.notetaker.controller;

import lk.ijse.notetaker.Util.AppUtil;
import lk.ijse.notetaker.dto.Note;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/v1/notes")
@RestController
public class DemoController {

    //To do CRUD Opertations
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody Note note){
        //To do Handle with BO
        note.setNoteId(AppUtil.createNoteID());
        System.out.println(note);
        return ResponseEntity.ok("Note Created Successfully");
    }

}
