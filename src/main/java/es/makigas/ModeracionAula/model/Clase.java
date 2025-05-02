package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalTime;
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
    @ListProperties("profesor.nombreCompleto, aula.nombreCompleto, grupo, turno")
    private Collection<Matricula> matriculas; // Todos los grupos asociados
}