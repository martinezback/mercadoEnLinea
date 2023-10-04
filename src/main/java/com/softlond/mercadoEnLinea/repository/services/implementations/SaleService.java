package com.softlond.mercadoEnLinea.repository.services.implementations;

import com.softlond.mercadoEnLinea.entities.Sale;
import com.softlond.mercadoEnLinea.entities.SaleDetail;
import com.softlond.mercadoEnLinea.repository.ISaleDetailRepository;
import com.softlond.mercadoEnLinea.repository.ISaleRepository;
import com.softlond.mercadoEnLinea.repository.services.contracts.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class SaleService implements ISaleService {

    private static final Double DISCOUNT = 0.1;

    @Autowired
    private ISaleRepository iSaleRepository;

    @Autowired
    private ISaleDetailRepository iSaleDetailRepository;

    @Override
    public ResponseEntity<?> create(Sale sale) {
        Sale saleSaved= saleOperations(sale);
        return new ResponseEntity<>(saleSaved, HttpStatus.OK);
    }

    private Sale saleOperations(Sale sale){

        Sale updatedSale1=iSaleRepository.save(sale);
        List<SaleDetail>saleDetails=saleDetailOperations(updatedSale1);

        updatedSale1.setSubtotal(0.0);

        for(SaleDetail saleDetail: updatedSale1.getSaleDetails()){
            updatedSale1.setSubtotal(updatedSale1.getSubtotal()+ saleDetail.getPricexUnits());
        }

        updatedSale1.setDateSale(LocalDate.now());
        Long customerId= updatedSale1.getClient().getId();
        LocalDate startDate= updatedSale1.getDateSale().minusDays(31);
        LocalDate endDate = updatedSale1.getDateSale();

        Sale updatedSale2=iSaleRepository.save(updatedSale1);
        List<Sale>sales= iSaleRepository.findByClientIdAndDateBetween(customerId,startDate,endDate);

        Double sumatoria=0.0;
        for(Sale saleRepo: sales){
            sumatoria+=saleRepo.getSubtotal();
        }
        if(sumatoria>100.0){
            updatedSale2.setDiscount(updatedSale2.getSubtotal()*DISCOUNT);
            updatedSale2.setTotal(updatedSale2.getSubtotal()-updatedSale2.getDiscount());
            updatedSale2.setApplyDiscount(true);
        }else{
            updatedSale2.setDiscount(0.0);
            updatedSale2.setTotal(updatedSale2.getSubtotal());
            updatedSale2.setApplyDiscount(false);
        }
        return iSaleRepository.save(updatedSale2);
    }

    private List<SaleDetail> saleDetailOperations(Sale sale){

        for(SaleDetail saleDetail:sale.getSaleDetails()){
            int units= saleDetail.getUnits();
            Double price = saleDetail.getPrice();
            Double pricexunits= units*price;

            saleDetail.setSale(sale);
            saleDetail.setPricexUnits(pricexunits);
        }
        return  sale.getSaleDetails();
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Sale> saleFind= iSaleRepository.findById(id);
        return new ResponseEntity<>(saleFind, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Sale>> getAll() {
        List<Sale> sales = iSaleRepository.findAll();
        return new ResponseEntity<>(sales,HttpStatus.OK);
    }
}
