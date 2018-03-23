package com.pos.posapp.services;

import com.pos.posapp.object.Sale;
import com.pos.posapp.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PosService {
    @Autowired
    SaleRepository saleRepository;

    public void add(Sale sale){
        saleRepository.save(sale);
    }
    public List<Sale> showSales(){
      return  saleRepository.findAll();
    }
    public void delete(int id){
        saleRepository.deleteById(id);
    }
}
