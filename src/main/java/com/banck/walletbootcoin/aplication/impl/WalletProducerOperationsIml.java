package com.banck.walletbootcoin.aplication.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.banck.walletbootcoin.domain.Wallet;
import com.banck.walletbootcoin.aplication.model.WalletKafka;
import com.banck.walletbootcoin.aplication.WalletKafkaOperations;

@Service
@RequiredArgsConstructor
public class WalletProducerOperationsIml implements WalletKafkaOperations {

    Logger logger = LoggerFactory.getLogger(WalletProducerOperationsIml.class);
    private final WalletKafka walletKafka;

    @Override
    public void create(Wallet wallet) {
        walletKafka.create(wallet);
    }
}
