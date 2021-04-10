package pt.learning.fundamentals.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pt.learning.fundamentals.commons.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Ticket extends BaseEntity {

    private String title;
    private String description;

    @ManyToOne
    private Application application;

    @ManyToOne
    private Release release;

}
