package com.ejemplo1.ejemplo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
    private Date fechaCreacion;

    @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
    private Date fechaUltimaActualizacion;

    @PrePersist
    protected void onCreate() {
        fechaUltimaActualizacion = new Date();
        if (fechaCreacion == null) {
            fechaCreacion = new Date();
        }
    }
}
