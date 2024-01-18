package world.It.academy.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {
    public static String hash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String dbPassword, String userPassword){
        return BCrypt.checkpw(dbPassword, userPassword);
    }
}
