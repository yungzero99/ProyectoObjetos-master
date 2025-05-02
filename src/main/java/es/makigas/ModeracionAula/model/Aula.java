package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@Table(name = "Aula",
        uniqueConstraints = @UniqueConstraint(columnNames = {"edificio_id", "numeroAula_id"})
)
@Views({
        @View(name = "simple", members = "edificio, numeroAula, capacidad"),
        @View(name = "detalle", members =
                "nombreCompleto;" +
                        "edificio, numeroAula;" +
                        "capacidad;" +
                        "caracteristicas;" +
                        "clases { clases }")
})
@Tab(properties = "nombreCompleto, capacidad, edificio.nombreEdificio")
public class Aula extends Identifiable {

    // --------------- RELACIONES OBLIGATORIAS ---------------
    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreEdificio")
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "numero")
    @JoinColumn(name = "numeroAula_id")
    private NumeroAula numeroAula;

    // --------------- CAMPOS PRINCIPALES ---------------
    @Min(1)
    @Max(200)
    @Required
    private Integer capacidad;

    public String toString() {
        return edificio.getNombreEdificio() + "-" + numeroAula.getNumero();
    }
    // --------------- CAMPOS CALCULADOS ---------------
    @Transient
    @DisplaySize(30)
    public String getNombreCompleto() {
        return edificio.getNombreEdificio() + "-" + numeroAula.getNumero();
    }


/*
    // --------------- RELACIONES INVERTIDAS ---------------
    @OneToMany(mappedBy = "aula")
    @ListProperties("nombreClase, turno, profesor.nombreCompleto")
    private Collection<Clase> clases;

    // --------------- CARACTERÍSTICAS (CHECKBOXES) ---------------
    @ManyToMany
    @JoinTable(name = "aula_caracteristicas")
    @Editor("Checkbox")
    private Collection<CaracteristicaAula> caracteristicas;

*/
}