package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@Table(name = "Horario")
@View(name = "simple", members = "matricula, dia, inicio, fin")
@Tab(properties = "matricula.descripcionCompleta, dia, inicio, fin")
public class Horario extends Identifiable {

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "descripcionCompleta")
    private Matricula matricula;

    @Enumerated(EnumType.STRING)
    @Required
    private Semana dia;

    // Usamos String con formato validado HH:mm
    @Stereotype("TIME")
    @Required
    @Pattern(regexp = "^\\d{2}:\\d{2}$", message = "Formato inválido (HH:mm)")
    private String inicio;

    @Stereotype("TIME")
    @Required
    @Pattern(regexp = "^\\d{2}:\\d{2}$", message = "Formato inválido (HH:mm)")
    private String fin;

    // Validación extra opcional al guardar
    @PrePersist
    @PreUpdate
    private void validarTiempos() {
        try {
            java.time.LocalTime.parse(inicio);
            java.time.LocalTime.parse(fin);
        } catch (Exception e) {
            throw new RuntimeException("El formato de hora debe ser HH:mm (por ejemplo, 08:30)");
        }
    }
    @Transient
    public String getHorarioFormateado()
    {
        return dia.toString().substring(0, 3) + " " + inicio + "-" + fin;
    }
}
