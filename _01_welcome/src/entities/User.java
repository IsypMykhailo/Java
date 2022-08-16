package entities;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    @Setter
    private String Name;
    private String Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
