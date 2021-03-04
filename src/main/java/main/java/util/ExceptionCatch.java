package main.java.util;

import java.sql.SQLException;

public class ExceptionCatch {
    public static void huntException(Exception exception) {
        if (exception instanceof SQLException) {
            SQLException sqlException = (SQLException) exception;
            System.out.println("Error Code :" + sqlException.getErrorCode());
            System.out.println("SQL state :" + sqlException.getSQLState());
        }
        System.out.println("SQLException message" + exception.getMessage());
        System.out.println("Stactrace :");
        exception.printStackTrace();
    }

}
