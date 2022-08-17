package phoneBook;

import lombok.Data;

@Data

public class Contact implements Cloneable {
    String name;
    String number;

//    @Override
//    public Contact clone() throws CloneNotSupportedException {
//        return (Contact) super.clone();
//    }
}
