package pt.learning.fundamentals.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pt.learning.fundamentals.commons.BaseEntity;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Release extends BaseEntity {

    private String releaseDate;
    private String description;
}
