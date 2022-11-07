package com.aninfo.repository;

import com.aninfo.model.Transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Optional<Transaction> findById(Long id);

    List<Transaction> findByAccountCbu(Long accountCbu);

    @Override
    List<Transaction> findAll();
}