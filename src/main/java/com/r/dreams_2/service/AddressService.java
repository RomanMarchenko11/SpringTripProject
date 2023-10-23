package com.r.dreams_2.service;

import com.r.dreams_2.dto.AddressDTO;
import java.util.List;
import java.util.Optional;

public interface AddressService {
    Optional<AddressDTO> getAddress (Long id);
    AddressDTO createAddress (AddressDTO addressDTO);
    AddressDTO updateAddress(Long id, AddressDTO addressDTO);
    void deleteAddress(Long id);
    List<AddressDTO> findAllAddress();
}
