package com.example.moblilelele.service;

import com.example.moblilelele.model.dto.OfferDto;
import com.example.moblilelele.model.entity.OfferEntity;
import com.example.moblilelele.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;

    public OfferService(ModelMapper modelMapper, OfferRepository offerRepository) {
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
    }

    public void addOffer(OfferDto offerDto) {
        offerRepository.save(modelMapper.map(offerDto, OfferEntity.class));
    }
}
