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
    public SellerEntity createSeller(SellerEntity sellerEntity) {
        return repository.saveAndFlush(sellerEntity);
    }

    @Override
    public SellerEntity findSellerById(UUID id) {
        Optional<SellerEntity> opt = repository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void removeSeller(SellerEntity sellerEntity) {
        repository.delete(sellerEntity);
    }
}
