package com.banck.walletbootcoin.infraestructure.repository;

import com.banck.walletbootcoin.infraestructure.model.dao.WalletDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 *
 * @author jonavcar
 */
public interface IWalletCrudRepository extends ReactiveCrudRepository<WalletDao, String> {

    Flux<WalletDao> findAllByDocument(String document);
}
