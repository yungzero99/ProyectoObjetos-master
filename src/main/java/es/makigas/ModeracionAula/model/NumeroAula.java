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
@Table(name = "NumeroAula")
@View(name = "simple", members = "numero")
@Tab(properties = "numero")
public class NumeroAula extends Identifiable {

    @Column(unique = true, nullable = false, length = 10)
    @Required
    private String numero; // Ej: "101", "201", "301"...
}