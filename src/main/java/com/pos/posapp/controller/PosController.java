package com.pos.posapp.controller;

import com.pos.posapp.object.Sale;
import com.pos.posapp.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Controller
public class PosController {
    Sale sale;
    Set<Sale> list = new HashSet<>();
    SaleRepository saleRepository;

    @Autowired
    public PosController(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    /*
        Add sale method to render add sale view
         */
    @RequestMapping(value = "/new_sale", method = RequestMethod.GET)
    public String showSaleForm(){

        return "addsale";
    }
    @RequestMapping(value = "/new_sale", method = RequestMethod.POST)
    public String addSale(HttpServletRequest request, @Valid Sale sale, BindingResult result){
      /*  if (result.hasErrors()) {
            System.out.println("HAS ERROR :"+result.getFieldError());
            return "addsale";
        }else {*/
            int id = Integer.parseInt(request.getParameter("item_id"));
            String name = request.getParameter("item_name");
            double amount = Double.parseDouble(request.getParameter("item_amount"));

            // creating an object Sale with Post values

            if(id == 0 || name.isEmpty() || amount == 0){
                System.out.println("ERROR THROWN:");
                return "addsale";
            }
            sale = new Sale(id, name, amount);
            saleRepository.save(sale);
     //   }
        return "addsale";

    }
    @RequestMapping("/show")
    public String showsales(Model model){
        model.addAttribute("sales",saleRepository.findAll());
        return "sales_list";
    }
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String deleteSale(Model model){
        model.addAttribute("sales",saleRepository.findAll());
        return "delete_sale";
    }
    @RequestMapping(value = "/remove_sale",method = RequestMethod.POST)
    public String delete(HttpServletRequest request){
        String sale_id = request.getParameter("sale_id");
        int id = Integer.parseInt(sale_id);
     //   list.removeIf(sale -> sale.getId() == id);
        saleRepository.deleteById(id);
        return "redirect:/remove";
    }
}
