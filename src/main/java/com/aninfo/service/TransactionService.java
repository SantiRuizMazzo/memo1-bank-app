package com.aninfo.service;

import com.aninfo.exceptions.InvalidTransactionTypeException;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction){
        if (!transaction.getType().equals("withdrawal") && !transaction.getType().equals("deposit"))
            throw new InvalidTransactionTypeException("Invalid type of transaction");
        
        return transactionRepository.save(transaction);
    }

    public Collection<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public List<Transaction> getTransactionsByAccountCbu(Long accountCbu) {
        return transactionRepository.findByAccountCbu(accountCbu);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}
