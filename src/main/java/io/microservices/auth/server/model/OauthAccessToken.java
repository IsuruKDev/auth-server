package io.microservices.auth.server.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "oauth_access_token")
public class OauthAccessToken {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authentication_id")
    private String authenticationId;
    @Column(name = "token")
    private Long token;
    @Column(name = "token_id")
    private String tokenId;
    @Column(name = "user_name")
    private String username;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "expiresAt")
    private Long authentication;
    @Column(name = "refresh_token")
    private String refreshToken;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;


    public OauthAccessToken() {
    }

    public OauthAccessToken(OauthAccessToken accessToken) {
        this.authenticationId = accessToken.getAuthenticationId();
        this.token = accessToken.getToken();
        this.tokenId = accessToken.getTokenId();
        this.username = accessToken.getUsername();
        this.clientId = accessToken.getClientId();
        this.authentication = accessToken.getAuthentication();
        this.refreshToken = accessToken.getRefreshToken();

    }
}
