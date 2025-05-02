package es.makigas.ModeracionAula.model;

import javax.persistence.Table;

@Table(name = "TipoDocente")
public enum TipoDocente {
    CONTRATADO,
    SUSTITUTO
}
