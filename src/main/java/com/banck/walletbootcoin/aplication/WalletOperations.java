package com.banck.walletbootcoin.aplication;

import com.banck.walletbootcoin.domain.Wallet;
import com.banck.walletbootcoin.aplication.impl.ResponseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface WalletOperations {

    public Flux<Wallet> list();

    public Flux<Wallet> listByDocument(String document);

    public Mono<Wallet> get(String person);

    public Mono<ResponseService> create(Wallet person); 

    public Mono<Wallet> update(String id, Wallet person);

    public void delete(String id);

}
