package lk.ijse.notetaker.Util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AppUtil {

    public static String createNoteID(){
        return "NOTE "+UUID.randomUUID();
    }
    public static String createUserID(){
        return "USER "+UUID.randomUUID();
    }


}
