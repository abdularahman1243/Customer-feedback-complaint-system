package spring.developer.gsms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "service_requests",
        indexes = {
                @Index(name = "idx_requests_status", columnList = "status"),
                @Index(name = "idx_requests_citizen", columnList = "citizen_id"),
                @Index(name = "idx_requests_service", columnList = "service_id")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String requestNo; // GSMS-2025-00001

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    @ManyToOne(optional = false)
    @JoinColumn(name = "citizen_id")
    private UserModel citizen;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private RequestStatus status;

    @Column(length = 20)
    private String priority; // LOW / MEDIUM / HIGH

    @Column(length = 2000)
    private String details;

    private LocalDateTime submittedAt;
    private LocalDateTime lastUpdatedAt;

    @PrePersist
    void onCreate() {
        this.status = RequestStatus.SUBMITTED;
        this.submittedAt = LocalDateTime.now();
        this.lastUpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        this.lastUpdatedAt = LocalDateTime.now();
    }

    public enum RequestStatus {
        DRAFT,
        SUBMITTED,
        IN_REVIEW,
        APPROVED,
        REJECTED,
        CLOSED
    }
}
