package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Getter
@Setter
@Table(name = "Clase")
@View(name = "simple", members = "nombreClase, carrera") // Solo datos universales
public class Clase extends Identifiable {

    @Required
    @Column(length = 100, unique = false) // Ej: "Cálculo I", "Física Cuántica"
    private String nombreClase;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombre")
    private Carrera carrera;

    @OneToMany(mappedBy = "clase")
    @ListProperties("profesor.nombreCompleto, aula.nombreCompleto, grupo")
    private Collection<Matricula> matriculas; // Todos los grupos asociados
}