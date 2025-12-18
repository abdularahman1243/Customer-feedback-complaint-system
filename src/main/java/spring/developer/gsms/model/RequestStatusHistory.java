package spring.developer.gsms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "request_status_history",
        indexes = {
                @Index(name = "idx_status_history_request", columnList = "request_id")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id")
    private ServiceRequest request;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceRequest.RequestStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceRequest.RequestStatus toStatus;

    @ManyToOne(optional = false)
    @JoinColumn(name = "changed_by")
    private UserModel changedBy;

    @Column(nullable = false)
    private LocalDateTime changedAt;

    @Column(length = 1000)
    private String comment;

    @PrePersist
    void onChange() {
        this.changedAt = LocalDateTime.now();
    }
}
