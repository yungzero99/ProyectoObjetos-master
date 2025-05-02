package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "Matricula")
@View(name = "simple", members =
        "clase, profesor, aula, grupo, turno, aula.capacidad;" +
                "horarios { horarios }")
@Tab(properties = "clase.nombreClase, grupo, turno, profesor.nombreCompleto, aula.nombreCompleto")
public class Matricula extends Identifiable {

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreClase")
    private Clase clase;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    private Profesor profesor;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    private Aula aula;

    @Min(1)
    @Column(nullable = false)
    private Integer grupo;

    @Enumerated(EnumType.STRING)
    @Required
    private Turno turno;


    @OneToMany(mappedBy = "matricula")
    @ListProperties("dia, inicio, fin")
    private Collection<Horario> horarios;

    // ----- Campos calculados -----
    @Transient
    public String getDescripcionCompleta() {
        return clase.getNombreClase() + " - Grupo " + grupo + " (" + turno + ")";
    }

    @Transient
    @DisplaySize(50)
    public String getDescripcionCompletaConHorarios() {
        return this.getDescripcionCompleta() + " | Docente: " +
                profesor.getNombreCompleto() + " | Horarios: " +
                this.getHorariosFormateados();
    }

    @Transient
    public String getHorariosFormateados() {
        StringBuilder sb = new StringBuilder();
        horarios.forEach(h -> sb.append(h.getHorarioFormateado()).append(", "));
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
    }
}