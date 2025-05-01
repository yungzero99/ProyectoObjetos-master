package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@Table(name = "Aula")
@View(name = "simple", members = "nombre, edificio") // Vista básica con el nombre y el edificio
@Tab(properties = "nombre, edificio.nombreEdificio, capacidad") // Configuración para mostrar columnas en la tabla
public class Aula extends Identifiable {


    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "numero")
    // Nombre del aula
    private NumeroAula numeroAula; // Relación con NumeroAula

    @ManyToOne(optional = false) // Relación con Edificio, obligatorio
    @DescriptionsList(descriptionProperties = "nombreEdificio") // Usa 'nombreEdificio' como descripción
    private Edificio edificio;

    @Min(1) // Valida que la capacidad mínima sea 1
    private Integer capacidad; // Capacidad del aula

    // Opcional: Campo derivado para nombre completo (ej: "Edificio A-101")
    @Transient
    @DisplaySize(20)
    public String getNombreCompleto() {
        return edificio.getNombreEdificio() + "-" + numeroAula.getNumero();
    }
}
