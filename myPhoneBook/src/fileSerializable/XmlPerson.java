package fileSerializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XmlPerson {
    private String name;
    private int age;
    private double height;
    private boolean married;
}
