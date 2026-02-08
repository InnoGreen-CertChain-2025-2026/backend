package com.certificate.blockchain.certificateapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateResponse {

    private Long id;
    private String certificateId;
    private String studentName;
    private String studentId;
    private LocalDate dateOfBirth;
    private String major;
    private Integer graduationYear;
    private Double gpa;
    private String certificateType;
    private String issuer;
    private LocalDate issueDate;
    private String documentHash;
    private String blockchainTxHash;
    private Long blockchainBlockNumber;
    private Long blockchainTimestamp;
    private Boolean isValid;
    private LocalDateTime createdAt;
}