package com.epam.esm.repository;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.repository.custom.GiftCertificateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GiftCertificateRepositoryImpl implements GiftCertificateRepository {


    public GiftCertificateRepositoryImpl() {
    }

    @Override
    public List<GiftCertificate> findAll() {
     return null;
    }

    @Override
    public Optional<GiftCertificate> findById(Long id) {
        return null;
    }

    @Override
    public GiftCertificate save(GiftCertificate value) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return true;
    }
}
