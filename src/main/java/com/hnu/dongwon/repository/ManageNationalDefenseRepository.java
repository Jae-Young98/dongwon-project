package com.hnu.dongwon.repository;

import com.hnu.dongwon.entity.NationalDefense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManageNationalDefenseRepository extends JpaRepository<NationalDefense, Long> {
    @Query("SELECT n FROM NationalDefense n ORDER BY n.category ASC, n.orderCost ASC")
    List<NationalDefense> findAllAsc();

    NationalDefense findByName(String name);
}
