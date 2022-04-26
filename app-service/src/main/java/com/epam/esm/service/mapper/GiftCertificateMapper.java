package com.epam.esm.service.mapper;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.model.GiftCertificateModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GiftCertificateMapper {
    GiftCertificateModel giftCertificateToGiftCertificateModel(GiftCertificate gift);
    GiftCertificate giftCertificateModelToGiftCertificate(GiftCertificateModel model);
    List<GiftCertificateModel> tagsToGiftCertificateModels(List<GiftCertificate> gifts);
    List<GiftCertificate> giftCertificateModelsToTags(List<GiftCertificateModel> models);
}
