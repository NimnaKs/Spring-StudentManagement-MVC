package lk.ijse.springstudentmanagementmvc.util;

import java.util.UUID;

public class UtilMatters {

    public  static String generateId(){
        return UUID.randomUUID().toString();
    }
}
