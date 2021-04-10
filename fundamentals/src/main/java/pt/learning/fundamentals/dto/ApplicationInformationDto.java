package pt.learning.fundamentals.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class ApplicationInformationDto {
    String name;
    String description;
    String owner;
}
