package io.microservices.auth.server.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;
    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;
    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;

    public User(){}

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
        this.accountNonExpired = user.isAccountNonExpired();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.roles = user.getRoles();
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="role_user",joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
        inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
}
