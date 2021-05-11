package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestSuite {
    String suiteName;
    String description;
    String preCondition;
}
