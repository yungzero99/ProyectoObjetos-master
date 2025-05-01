package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Edificio")
@View(name = "simple", members = "nombreEdificio")
@Tab(properties = "nombreEdificio")
public class Edificio extends Identifiable {

    @Required
    @Column(length = 100)
    private String nombreEdificio;

    @Override
    public String toString() {
        return nombreEdificio;
    }
}