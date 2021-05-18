package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestProject {
    String name;
    String code;
    String description;
    String accessType;
}
