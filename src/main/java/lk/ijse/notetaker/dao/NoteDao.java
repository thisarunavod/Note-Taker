package lk.ijse.notetaker.dao;

import lk.ijse.notetaker.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository  /* spring wisin manage karanawaa*/
public interface NoteDao  extends JpaRepository<NoteEntity,String /*<---  primary key eke data type eka */> {

}
