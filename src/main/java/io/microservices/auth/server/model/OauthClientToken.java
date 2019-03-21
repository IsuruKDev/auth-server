package io.microservices.auth.server.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "oauth_client_token")
public class OauthClientToken {

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
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;



    public OauthClientToken() {
    }

    public OauthClientToken(OauthAccessToken accessToken) {
        this.authenticationId = accessToken.getAuthenticationId();
        this.token = accessToken.getToken();
        this.tokenId = accessToken.getTokenId();
        this.username = accessToken.getUsername();
        this.clientId = accessToken.getClientId();

    }
}
