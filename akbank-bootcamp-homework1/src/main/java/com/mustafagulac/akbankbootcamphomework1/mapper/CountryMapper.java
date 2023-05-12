package com.mustafagulac.akbankbootcamphomework1.mapper;

import com.mustafagulac.akbankbootcamphomework1.dto.CountryDto;
import com.mustafagulac.akbankbootcamphomework1.entity.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto toDto(Country country);

    Country toEntity(CountryDto dto);
}
