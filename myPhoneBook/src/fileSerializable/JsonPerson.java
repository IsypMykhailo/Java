package fileSerializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonAutoDetect
public class JsonPerson {
    private String name;
    private int age;
    private double height;
    private boolean married;
}
