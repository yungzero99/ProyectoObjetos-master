package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;
import org.openxava.model.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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