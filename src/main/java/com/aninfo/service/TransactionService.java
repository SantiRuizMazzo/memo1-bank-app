package com.aninfo.service;

import com.aninfo.exceptions.InvalidTransactionTypeException;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction){
        if (!transaction.isWithdrawal() && !transaction.isDeposit())
            throw new InvalidTransactionTypeException("Invalid type of transaction");
        
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public Collection<Transaction> getTransactionsByAccountCbu(Long accountCbu) {
        return transactionRepository.findByAccountCbu(accountCbu);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}
