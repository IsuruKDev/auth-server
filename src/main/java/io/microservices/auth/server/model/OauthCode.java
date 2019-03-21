package io.microservices.auth.server.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "oauth_code")
public class OauthCode {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private String code_id;
    @Column(name = "code")
    private String code;
    @Column(name = "authentication")
    private Long authentication;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;


    public OauthCode() {
    }

    public OauthCode(OauthCode oauthCode) {
        this.code = oauthCode.getCode();
        this.authentication = oauthCode.getAuthentication();

    }
}
