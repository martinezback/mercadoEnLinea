package com.softlond.mercadoEnLinea.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Sales")
public class Sale {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    @NotEmpty
    private List<SaleDetail> saleDetails=new ArrayList<>();
    private LocalDate dateSale;
    private Double discount;
    private Double subtotal;
    private Double total;
    private Boolean applyDiscount;

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", client=" + client +
                ", saleDetails=" + saleDetails +
                ", dateSale=" + dateSale +
                ", discount=" + discount +
                ", subtotal=" + subtotal +
                ", total=" + total +
                ", applyDiscount=" + applyDiscount +
                '}';
    }
}
