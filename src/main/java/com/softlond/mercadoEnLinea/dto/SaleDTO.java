package com.softlond.mercadoEnLinea.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softlond.mercadoEnLinea.entities.Client;
import com.softlond.mercadoEnLinea.entities.SaleDetail;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SaleDTO {

    private Client client;
    private List<SaleDetail> saleDetails;
    private LocalDate dateSale;
    private Double discount;
    private Double total;
    private Boolean applyDiscount;

}
