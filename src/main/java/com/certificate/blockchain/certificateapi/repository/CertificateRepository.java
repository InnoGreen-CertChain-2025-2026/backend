package com.certificate.blockchain.certificateapi.repository;

import com.certificate.blockchain.certificateapi.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    Optional<Certificate> findByCertificateId(String certificateId);

    Optional<Certificate> findByDocumentHash(String documentHash);

    boolean existsByCertificateId(String certificateId);
}
