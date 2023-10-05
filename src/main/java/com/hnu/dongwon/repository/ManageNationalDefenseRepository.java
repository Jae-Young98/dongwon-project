package com.hnu.dongwon.repository;

import com.hnu.dongwon.entity.NationalDefense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManageNationalDefenseRepository extends JpaRepository<NationalDefense, Long> {
    NationalDefense findByName(String name);
}
