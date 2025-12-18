package spring.developer.gsms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "request_assignments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id")
    private ServiceRequest request;

    @ManyToOne(optional = false)
    @JoinColumn(name = "officer_id")
    private UserModel officer;

    @Column(nullable = false)
    private LocalDateTime assignedAt;

    private LocalDateTime unassignedAt;

    @Column(length = 1000)
    private String note;

    @PrePersist
    void onAssign() {
        this.assignedAt = LocalDateTime.now();
    }
}
