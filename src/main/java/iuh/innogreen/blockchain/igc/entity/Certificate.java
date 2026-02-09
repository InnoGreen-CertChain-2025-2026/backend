package iuh.innogreen.blockchain.igc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "certificates")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "certificate_id", unique = true, nullable = false)
    private String certificateId;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "major")
    private String major;

    @Column(name = "graduation_year")
    private Integer graduationYear;

    @Column(name = "gpa")
    private Double gpa;

    @Column(name = "certificate_type")
    private String certificateType;

    @Column(name = "issuer", nullable = false)
    private String issuer;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "document_hash", nullable = false, unique = true, length = 66)
    private String documentHash;

    @Column(name = "blockchain_tx_hash", length = 66)
    private String blockchainTxHash;

    @Column(name = "blockchain_block_number")
    private Long blockchainBlockNumber;

    @Column(name = "blockchain_timestamp")
    private Long blockchainTimestamp;

    @Column(name = "is_valid")
    private Boolean isValid = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
