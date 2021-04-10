package pt.learning.fundamentals.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pt.learning.fundamentals.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Application extends BaseEntity {

    private String name;
    @Column(length = 2000)
    private String description;
    private String owner;
}
