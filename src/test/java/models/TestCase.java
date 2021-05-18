package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestCase {
    String title;
    String status;
    String description;
    String suite;
    String severity;
    String priority;
    String type;
    String behavior;
    String automationStatus;
    String preConditions;
    String postConditions;
}
