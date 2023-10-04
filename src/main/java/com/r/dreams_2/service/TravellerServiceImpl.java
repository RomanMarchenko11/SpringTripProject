package com.r.dreams_2.service;

import com.r.dreams_2.dto.TravellerDTO;
import com.r.dreams_2.entity.Traveller;
import com.r.dreams_2.exceptions.CustomException;
import com.r.dreams_2.repository.TravellerRepository;
import com.r.dreams_2.utils.TravellerMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TravellerServiceImpl implements TravellerService {
    private TravellerRepository travellerRepository;
    private TravellerMapper travellerMapper;
    private Map<String,TravellerDTO> travellers;

    @Transactional(readOnly = true)
    @Override
    public Optional<TravellerDTO> getTraveller(Long id) {
        return travellerRepository.findById(id).map(travellerMapper::toDTO);
    }

    @Transactional
    @Override
    public TravellerDTO createTraveller(TravellerDTO travellerDTO) {
        Traveller traveller = travellerMapper.toEntity(travellerDTO);
        traveller = travellerRepository.save(traveller);
        return travellerMapper.toDTO(traveller);
    }
    @Transactional
    @Override
    public TravellerDTO updateTraveller(Long id, TravellerDTO travellerDTO) {
        if (travellerRepository.existsById(id)) {
            Traveller traveller = travellerMapper.toEntity(travellerDTO);
            traveller.setId(id);
            traveller = travellerRepository.save(traveller);
            return travellerMapper.toDTO(traveller);
        }
        return null;
    }


    @Transactional(rollbackFor = CustomException.class, propagation = Propagation.REQUIRED)
    @Override
    public TravellerDTO deleteTraveller(Long id) {
        travellerRepository.deleteById(id);
        throw new CustomException("Deleted wrong", 500);
    }


    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<TravellerDTO> findAllTravellers() {
        return travellerRepository.findAll()
                .stream()
                .map(travellerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void init() {
        TravellerDTO traveller1 = TravellerDTO.builder()
                .id(1L)
                .name("Roman")
                .surname("Marchenko")
                .email("R@gmail.com")
                .build();

        TravellerDTO traveller2 = TravellerDTO.builder()
                .id(2L)
                .name("Anton")
                .surname("Storm")
                .email("S@gmail.com")
                .build();
        travellers.put("1", traveller1);
        travellers.put("2", traveller2);
    }
}
