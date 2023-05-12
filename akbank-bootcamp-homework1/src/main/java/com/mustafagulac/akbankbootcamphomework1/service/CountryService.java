package com.mustafagulac.akbankbootcamphomework1.service;

import com.mustafagulac.akbankbootcamphomework1.dto.CountryDto;
import com.mustafagulac.akbankbootcamphomework1.entity.Country;
import com.mustafagulac.akbankbootcamphomework1.mapper.CountryMapper;
import com.mustafagulac.akbankbootcamphomework1.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryDto save(CountryDto dto) {
        Country country = countryMapper.toEntity(dto);
        Country savedCountry = countryRepository.save(country);
        return countryMapper.toDto(savedCountry);
    }

    public List<CountryDto> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(countryMapper::toDto)
                .collect(Collectors.toList());
    }

    public CountryDto findById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        return countryMapper.toDto(country);
    }

    public CountryDto updatePresident(Long id, String president) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        country.setPresident(president);

        Country updatedCountry = countryRepository.save(country);

        return countryMapper.toDto(updatedCountry);
    }



}
