package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TestSuite {
    String suiteName;
    String description;
    String preCondition;

}
