package s3giorno4.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
 
@Entity
@Table(name = "locations")
@Data
@Getter
@Setter
public class Location {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String città;

}
