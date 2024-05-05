package io.abun.springbootikamers.SellerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public SellerEntity create(SellerEntity sellerEntity) {
        return repository.saveAndFlush(sellerEntity);
    }

    @Override
    public SellerEntity update(SellerEntity seller) {
        return repository.saveAndFlush(seller);
    }

    @Override
    public SellerEntity findById(UUID id) {
        Optional<SellerEntity> opt = repository.findById(id);
        return opt.get();
    }

    @Override
    public List<SellerEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public SellerEntity findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void remove(SellerEntity sellerEntity) {
        repository.delete(sellerEntity);
    }
}
