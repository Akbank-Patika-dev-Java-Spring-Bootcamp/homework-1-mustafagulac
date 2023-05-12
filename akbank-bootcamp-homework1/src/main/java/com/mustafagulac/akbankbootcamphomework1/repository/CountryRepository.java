package com.mustafagulac.akbankbootcamphomework1.repository;

import com.mustafagulac.akbankbootcamphomework1.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
