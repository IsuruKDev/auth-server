package io.microservices.auth.server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "role")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "desc")
    private String description;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role",joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "permission_id",referencedColumnName = "id")
    })
    private List<Permission> permissions;

}
