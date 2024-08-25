package lk.ijse.notetaker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "notes")
public class NoteEntity {

    @Id
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private String creatDate;
}
