package model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class User {
    private String ID;
    private String Password;
    private boolean isSuper;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isSuper() {
        return isSuper;
    }

    public void setSuper(boolean aSuper) {
        isSuper = aSuper;
    }
}
