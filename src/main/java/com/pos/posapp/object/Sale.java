package com.pos.posapp.object;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Sale {

  //  @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

 //   @NotEmpty
    private String name;

 //   @NotNull
    private double amount;

    public Sale() {
    }

    public Sale(int id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        return id == sale.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
