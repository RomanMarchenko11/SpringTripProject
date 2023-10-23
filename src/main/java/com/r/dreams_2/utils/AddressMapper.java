package com.r.dreams_2.utils;

import com.r.dreams_2.dto.AddressDTO;
import com.r.dreams_2.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDTO toDTO(Address address) {
        AddressDTO dtoAddress = new AddressDTO();
        dtoAddress.setId (address.getId());
        dtoAddress.setCountry(address.getCountry());
        dtoAddress.setCity(address.getCity());
        dtoAddress.setStreet(address.getStreet());
        dtoAddress.setPoint(address.getPoint());
        dtoAddress.setTraveller(address.getTraveller());
        return dtoAddress;
    }

    public Address toEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setStreet(address.getStreet());
        address.setPoint(address.getPoint());
        address.setTraveller(address.getTraveller());
        return address;
    }
}
