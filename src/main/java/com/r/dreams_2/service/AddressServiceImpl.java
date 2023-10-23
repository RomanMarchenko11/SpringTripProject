package com.r.dreams_2.service;

import com.r.dreams_2.dto.AddressDTO;
import com.r.dreams_2.entity.Address;
import com.r.dreams_2.exceptions.CustomException;
import com.r.dreams_2.repository.AddressRepository;
import com.r.dreams_2.utils.AddressMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<AddressDTO> getAddress(Long id) {
        return addressRepository.findById(id).map(addressMapper::toDTO);
    }

    @Transactional
    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = addressMapper.toEntity(addressDTO);
        address = addressRepository.save(address);
        return addressMapper.toDTO(address);
    }

    @Transactional
    @Override
    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        if (addressRepository.existsById(id)) {
            Address address = addressMapper.toEntity(addressDTO);
            address.setId(id);
            address = addressRepository.save(address);
            return addressMapper.toDTO(address);
        }
        return null;
    }

    @Transactional(rollbackFor = CustomException.class, propagation = Propagation.REQUIRED)
    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<AddressDTO> findAllAddress() {
        return addressRepository.findAll()
                .stream()
                .map(addressMapper::toDTO)
                .collect(Collectors.toList());
    }
}
