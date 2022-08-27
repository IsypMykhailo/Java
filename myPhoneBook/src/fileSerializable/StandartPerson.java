package fileSerializable;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandartPerson implements Serializable {
    private String name;
    private int age;
    private double height;
    private boolean married;
}
