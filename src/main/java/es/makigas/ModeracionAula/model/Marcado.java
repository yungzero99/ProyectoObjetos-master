package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Marcado")

@Views({
        @View(name = "simple", members =
                "Información Principal {" +
                        "   matricula;" +
                        "   turno, asistencia;" +
                        "   fecha;" +
                        "};"
        ),
        @View(name = "completa", members =
                "Información General {" +
                        "   matricula;" +
                        "   turno, asistencia;" +
                        "   fecha;" +
                        "};" +
                        "Detalle Matrícula {" +
                        "   matricula.profesor.nombreCompleto;" +
                        "   matricula.aula.nombreCompleto;" +
                        "   matricula.horarios;" +
                        "}"
        )
})
public class Marcado extends Identifiable {

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "descripcionCompletaConHorarios")
    private Matricula matricula;

    @Column(nullable = false)
    private boolean asistencia;

    @Column(nullable = false)
    @ReadOnly
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    @Required
    private Turno turno;

    @PrePersist
    public void establecerFecha() {
        this.fecha = LocalDate.now();
    }
}