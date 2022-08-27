package fileSerializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class XmlPerson {
    private String name;
    private int age;
    private double height;
    private boolean married;
}
