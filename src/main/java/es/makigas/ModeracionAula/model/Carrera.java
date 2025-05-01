package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Carrera")
@View(name = "simple", members = "nombre, facultad")
@Tab(properties = "nombre, facultad.nombre")
public class Carrera extends Identifiable {

    @Required
    @Column(length = 50)
    private String nombre;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombre")
    private Facultad facultad;

    @Override
    public String toString() {
        return nombre;
    }
}