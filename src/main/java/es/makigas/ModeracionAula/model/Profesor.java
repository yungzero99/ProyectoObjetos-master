package es.makigas.ModeracionAula.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Profesor")
@View(name = "simple", members = "nombreCompleto, tipoDocente, cif")
@Tab(properties = "nombre1, nombre2, apellido, apellido2, tipoDocente, cif")
public class Profesor extends Identifiable {

	@Required
	@Column(length = 30)
	private String nombre1;

	@Column(length = 30)
	private String nombre2;

	@Required
	@Column(length = 30)
	private String apellido;

	@Required
	@Column(length = 30)
	private String apellido2;

	@Column(unique = true, nullable = false, length = 20)
	private String cif;

	@Enumerated(EnumType.STRING)
	@Required
	private TipoDocente tipoDocente;

	@Transient
	public String getNombreCompleto() {
		return nombre1 + " " + (nombre2 != null ? nombre2 + " " : "") + apellido + " " + apellido2;
	}

	@Override
	public String toString() {
		return getNombreCompleto();
	}
}

