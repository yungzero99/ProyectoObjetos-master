package es.makigas.ModeracionAula.model;

import javax.persistence.*;

@Table(name = "TipoDocente")
public enum TipoDocente {
    CONTRATADO,
    SUSTITUTO
}
