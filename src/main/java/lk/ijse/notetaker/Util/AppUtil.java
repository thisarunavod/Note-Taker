package lk.ijse.notetaker.Util;

import java.util.UUID;

public class AppUtil {
    public static String createNoteID(){
        return "NOTE "+UUID.randomUUID();
    }
}
