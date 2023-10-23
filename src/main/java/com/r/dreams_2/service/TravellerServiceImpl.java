package com.r.dreams_2.service;

import com.r.dreams_2.dto.TravellerDTO;
import com.r.dreams_2.entity.Traveller;
import com.r.dreams_2.exceptions.CustomException;
import com.r.dreams_2.repository.TravellerRepository;
import com.r.dreams_2.utils.TravellerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TravellerServiceImpl implements TravellerService {
    private final TravellerRepository travellerRepository;
    private final TravellerMapper travellerMapper;

    public TravellerServiceImpl(TravellerRepository travellerRepository, TravellerMapper travellerMapper) {
        this.travellerRepository = travellerRepository;
        this.travellerMapper = travellerMapper;
    }

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
//        Optional<Traveller> optionalTraveller = travellerRepository.findById(id);
//        if (optionalTraveller.isEmpty()) {
//            return null;
//        }
        Traveller traveller = travellerMapper.toEntity(travellerDTO);
        traveller.setId(id);
        travellerRepository.save(traveller);
        return travellerMapper.toDTO(traveller);
    }

    @Transactional(rollbackFor = CustomException.class, propagation = Propagation.REQUIRED)
    @Override
    public void deleteTraveller(Long id) {
        travellerRepository.deleteById(id);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<TravellerDTO> findAllTravellers() {
        return travellerRepository.findAll()
                .stream()
                .map(travellerMapper::toDTO)
                .collect(Collectors.toList());
    }
//
//    private final Map<String,TravellerDTO> travellers = new HashMap<String, TravellerDTO>();
//
//    @PostConstruct
//    public void init() {
//        TravellerDTO traveller1 = TravellerDTO.builder()
//                .id(1L)
//                .name("Roman")
//                .surname("Marchenko")
//                .email("R@gmail.com")
//                .build();
//
//        TravellerDTO traveller2 = TravellerDTO.builder()
//                .id(2L)
//                .name("Anton")
//                .surname("Storm")
//                .email("S@gmail.com")
//                .build();
//        travellers.put("1", traveller1);
//        travellers.put("2", traveller2);
//    }
}
