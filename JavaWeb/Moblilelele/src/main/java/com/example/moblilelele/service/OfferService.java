package com.example.moblilelele.service;

import com.example.moblilelele.model.dto.OfferDto;
import com.example.moblilelele.model.entity.OfferEntity;
import com.example.moblilelele.model.user.CurrentUser;
import com.example.moblilelele.repository.ModelRepository;
import com.example.moblilelele.repository.OfferRepository;
import com.example.moblilelele.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;

    public OfferService(ModelMapper modelMapper, CurrentUser currentUser, UserRepository userRepository, OfferRepository offerRepository, ModelRepository modelRepository) {
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
    }

    public void addOffer(OfferDto offerDto) {
        OfferEntity offerToBeAdded = modelMapper.map(offerDto, OfferEntity.class);

        //TODO Add user to the offer, Add model To The Offer,
        offerRepository.save(offerToBeAdded);
    }
}
