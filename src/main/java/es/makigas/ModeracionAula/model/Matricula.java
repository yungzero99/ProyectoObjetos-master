package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "Matricula")
@View(name = "simple", members =
        "clase, profesor, aula, grupo, turno, capacidad, horarioInicio, horarioFin")
public class Matricula extends Identifiable {

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreClase")
    private Clase clase; // Asignatura base (ej: "Matemáticas 101")

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    private Profesor profesor; // Docente del grupo

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    private Aula aula; // Ubicación física

    @Min(1)
    @Column(nullable = false)
    private Integer grupo; // Número de grupo (1, 2, 3...)

    @Enumerated(EnumType.STRING)
    @Required
    private Turno turno; // Mañana, tarde, noche

    @Min(1)
    private Integer capacidad; // Cupo máximo

    private LocalTime horarioInicio; // Hora de inicio
    private LocalTime horarioFin;    // Hora de fin

    // Descripción amigable para UI
    @Transient
    public String getDescripcionCompleta() {
        return clase.getNombreClase() + " - Grupo " + grupo + " (" + turno + ")";
    }
}