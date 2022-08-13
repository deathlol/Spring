package com.ejemplo1.ejemplo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "USER")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(name = "NOMBRE")
    @Getter @Setter
    private String nombre;
    @Column(name = "APELLIDO")
    @Getter @Setter
    private String apellido;
    @Column(name = "EMAIL")
    @Getter @Setter
    private String email;
    @Column(name = "TELEFONO")
    @Getter @Setter
    private String telefono;
    @Column(name = "FECHA_NACIMIENTO")
    @Getter @Setter
    private Date fechaNacimiento;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PASSWORD")
    @Getter @Setter
    private String password;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @Getter @Setter
    private Role role;

}
