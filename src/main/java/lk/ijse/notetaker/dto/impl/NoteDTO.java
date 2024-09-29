package lk.ijse.notetaker.dto.impl;

import lk.ijse.notetaker.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteDTO implements SuperDTO {

    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private String creatDate;
    private String userId;

}
