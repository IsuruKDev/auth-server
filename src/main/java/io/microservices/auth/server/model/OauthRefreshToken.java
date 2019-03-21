package io.microservices.auth.server.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken {


    @Column(name = "token")
    private Long token;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private String tokenId;
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



    public OauthRefreshToken() {
    }

    public OauthRefreshToken(OauthRefreshToken refreshToken) {
        this.token = refreshToken.getToken();
        this.tokenId = refreshToken.getTokenId();
        this.authentication = refreshToken.getAuthentication();
    }
}
