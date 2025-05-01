package es.makigas.ModeracionAula.model;
import org.openxava.annotations.*;
import lombok.Getter;
import lombok.Setter;
import org.openxava.model.Identifiable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

// Cambiado de java.util.Date a LocalTime
@Entity
@Getter
@Setter
@Table(name = "Marcado")
public class Marcado extends Identifiable {

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreCompleto") // ¡Corregido!
    private Aula aula; // Ahora usará el método getNombreCompleto() de Aula

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    private Profesor profesor;

    @Column(nullable = false)
    private boolean asistencia;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreClase")
    private Clase clase;

    @Column(nullable = false)
    @Stereotype("DATETIME")
    private LocalDateTime horaInicio;

    @Column(nullable = true)
    @Stereotype("DATETIME")
    private LocalDateTime horaFinal;

    @Enumerated(EnumType.STRING)
    @Required
    private Turno turno;
}