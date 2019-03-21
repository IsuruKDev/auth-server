package io.microservices.auth.server.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "oauth_client_details")
public class OauthClientDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "oauth_client_name")
    private String oauthClientName;
    @Column(name = "client_secret")
    private String clientSecret;
    @Column(name = "web_server_redirect_uri")
    private String webServerRedirectUri;
    @Column(name = "username")
    private String scope;
    @Column(name = "access_token_validity")
    private int accessTokenValidity;
    @Column(name = "refresh_token_validity")
    private int refreshTokenValidity;
    @Column(name = "resource_ids")
    private String resourceIds;
    @Column(name = "authorized_grant_types")
    private String authorizedGrantTypes;
    @Column(name = "authorities")
    private String authorities;
    @Column(name = "additional_information")
    private String additionalInformation;
    @Column(name = "autoapprove")
    private String autoApprove;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public OauthClientDetails() {
    }

    public OauthClientDetails(OauthClientDetails clientDetails) {
        this.clientId = clientDetails.getClientId();
        this.oauthClientName = clientDetails.getOauthClientName();
        this.clientSecret = clientDetails.getClientSecret();
        this.webServerRedirectUri = clientDetails.getWebServerRedirectUri();
        this.scope = clientDetails.getScope();
        this.accessTokenValidity = clientDetails.getAccessTokenValidity();
        this.refreshTokenValidity = clientDetails.getRefreshTokenValidity();
        this.resourceIds = clientDetails.getResourceIds();
        this.authorizedGrantTypes = clientDetails.getAuthorizedGrantTypes();
        this.authorities = clientDetails.getAuthorities();
        this.additionalInformation = clientDetails.getAdditionalInformation();
        this.autoApprove = clientDetails.getAutoApprove();

    }
}
