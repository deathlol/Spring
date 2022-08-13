package com.ejemplo1.ejemplo.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PERMISOS")
@NoArgsConstructor
@AllArgsConstructor
public class Permiso extends BaseEntity {

    @Column(name = "NOMBRE")
    @Getter
    @Setter
    private String nombre;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("role_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    @Getter @Setter
    private Role role;

}
