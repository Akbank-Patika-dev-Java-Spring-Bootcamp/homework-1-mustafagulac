package com.mustafagulac.akbankbootcamphomework1.controller;

import com.mustafagulac.akbankbootcamphomework1.dto.CountryDto;
import com.mustafagulac.akbankbootcamphomework1.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@AllArgsConstructor

public class CountryController {
    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryDto> save(@RequestBody CountryDto dto) {
        CountryDto savedDto = countryService.save(dto);
        return ResponseEntity.created(URI.create("/countries/" + savedDto.getId()))
                .body(savedDto);
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> findAll() {
        List<CountryDto> dtos = countryService.findAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> findById(@PathVariable Long id) {
        CountryDto dto = countryService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDto> updatePresident(@PathVariable Long id,
                                                      @RequestBody String president) {
        CountryDto updatedDto = countryService.updatePresident(id, president);
        return ResponseEntity.ok(updatedDto);
    }
}
