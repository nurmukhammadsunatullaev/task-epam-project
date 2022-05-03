package com.epam.esm.service;

import com.epam.esm.entity.Tag;
import com.epam.esm.model.GiftCertificateModel;
import com.epam.esm.repository.custom.GiftCertificateRepository;
import com.epam.esm.repository.custom.TagRepository;
import com.epam.esm.service.custom.GiftCertificateService;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.service.mapper.GiftCertificateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GiftCertificateServiceImpl implements GiftCertificateService {

    private final GiftCertificateRepository repository;
    private final TagRepository tagRepository;
    private final GiftCertificateMapper mapper;

    @Override
    public List<GiftCertificateModel> getAll() {
        List<GiftCertificate> gifts = repository.findAll();
        return mapper.tagsToGiftCertificateModels(gifts);
    }

    @Override
    public Optional<GiftCertificateModel> getById(Long id) {
        Optional<GiftCertificate> tag = repository.findById(id);
        return tag.map(mapper::giftCertificateToGiftCertificateModel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GiftCertificateModel save(GiftCertificateModel value) {
        GiftCertificate gift = mapper.giftCertificateModelToGiftCertificate(value);
        List<Tag> tags = gift.getTags();
        tags.forEach(tagRepository::save);
        gift = repository.save(gift);
        return mapper.giftCertificateToGiftCertificateModel(gift);
    }

    @Override
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}
