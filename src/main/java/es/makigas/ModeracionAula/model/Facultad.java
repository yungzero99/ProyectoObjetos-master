package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "Facultad",
        uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
@Views({
        @View(name = "simple", members = "nombre"),
        @View(name = "detalle", members = "nombre; descripcion; carreras { carreras }") // Corregido
        //
})
@Tab(properties = "nombre, descripcion")
public class Facultad extends Identifiable {

    @Column(length = 100, nullable = false)
    @Required
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @Column(length = 500)
    @Stereotype("TEXT_AREA")
    private String descripcion;

    @OneToMany(mappedBy = "facultad")
    @ListProperties("nombre")
    @ReadOnly
    private Collection<Carrera> carreras;

    @Transient
    public String getNombreYDescripcion() {
        return nombre + (descripcion != null ? " - " + descripcion.substring(0, Math.min(30, descripcion.length())) : "");
    }
}