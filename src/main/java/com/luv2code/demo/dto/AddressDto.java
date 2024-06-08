package com.luv2code.demo.dto;

import com.luv2code.demo.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private Integer id ;
    private String city;
    private String street;
    private String country;
    private String postalCode;

/*-------------------------------------------- mapping ***************************************************/
    public static AddressDto fromEntity(Address address){
        return AddressDto.builder()
                .id(address.getId())
                .city(address.getCity())
                .country(address.getCountry())
                .postalCode(address.getPostalCode())
                .build();
    }

    public static Address toEntity(AddressDto addressDto){
        return Address.builder()
                .id(addressDto.getId())
                .city(addressDto.getCity())
                .country(addressDto.getCountry())
                .postalCode(addressDto.getPostalCode())
                .build();
    }
}
