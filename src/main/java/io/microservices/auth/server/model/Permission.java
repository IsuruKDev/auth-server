package io.microservices.auth.server.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "permission")
public class Permission {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
}
