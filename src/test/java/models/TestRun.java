package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestRun {
    String title;
    String description;
    String defaultAssignee;
}
