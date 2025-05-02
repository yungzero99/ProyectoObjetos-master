package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;
import org.openxava.model.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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