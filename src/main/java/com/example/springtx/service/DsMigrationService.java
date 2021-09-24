package com.example.springtx.service;

import com.example.springtx.model.Test;
import com.example.springtx.repository.DsMigrationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class DsMigrationService {

    final DsMigrationRepository dsMigrationRepository;

    public DsMigrationService(DsMigrationRepository dsMigrationRepository) {
        this.dsMigrationRepository = dsMigrationRepository;
    }

    @Transactional(transactionManager = "dsMigrationTxManager", rollbackFor = Exception.class)
    public void testWithError() {
        System.out.println("1 Transactional open?" + TransactionSynchronizationManager.isActualTransactionActive());
        for (int i = 0; i < 5; i++) {
            dsMigrationRepository.save(new Test(null, "qwe" + i));
        }
        System.out.println("2 Transactional open?" + TransactionSynchronizationManager.isActualTransactionActive());
        throw new RuntimeException("Test exception");
    }

    @Transactional(transactionManager = "dsMigrationTxManager", rollbackFor = Exception.class)
    public void testWithoutError() {
        System.out.println("1 Transactional open?" + TransactionSynchronizationManager.isActualTransactionActive());
        for (int i = 0; i < 5; i++) {
            dsMigrationRepository.save(new Test(null, "qwe" + i));
        }
        System.out.println("2 Transactional open?" + TransactionSynchronizationManager.isActualTransactionActive());
    }
}
