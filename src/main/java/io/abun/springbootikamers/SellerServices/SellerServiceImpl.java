package io.abun.springbootikamers.SellerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SellerServiceImpl implements SellerService{
    @Autowired
    SellerRepository repository;

    public SellerServiceImpl() {
    }

    public SellerServiceImpl(SellerRepository repository) {
        this.repository = repository;
    }

    public SellerRepository getRepository() {
        return repository;
    }

    public void setRepository(SellerRepository repository) {
        this.repository = repository;
    }


    // METHODS --- METHODS --- METHODS --- METHODS --- METHODS --- METHODS --- METHODS
    @Override
    public Seller createSeller(Seller seller) {
        return repository.saveAndFlush(seller);
    }

    @Override
    public Seller findSellerById(UUID id) {
        Optional<Seller> opt = repository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void removeSeller(Seller seller) {
        repository.delete(seller);
    }
}
