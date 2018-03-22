package com.pos.posapp.repository;

import com.pos.posapp.object.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
