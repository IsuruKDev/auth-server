package io.microservices.auth.server.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "oauth_approvals")
public class OauthApproval {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oauth_approvals_id")
    private int oauthApprovalsId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "scope")
    private String scope;
    @Column(name = "status")
    private String status;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "expires_at")
    private Date expiresAt;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date lastModifiedAt;


    public OauthApproval() {
    }

    public OauthApproval(OauthApproval oauthApproval) {
        this.userId = oauthApproval.getUserId();
        this.scope = oauthApproval.getScope();
        this.status = oauthApproval.getStatus();
        this.clientId = oauthApproval.getClientId();
        this.expiresAt = oauthApproval.getExpiresAt();

    }
}
