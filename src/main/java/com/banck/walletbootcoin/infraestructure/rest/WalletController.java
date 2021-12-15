package com.banck.walletbootcoin.infraestructure.rest;

import com.banck.walletbootcoin.domain.Wallet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import com.banck.walletbootcoin.utils.Status;
import org.springframework.http.HttpStatus;
import com.banck.walletbootcoin.aplication.WalletOperations;

/**
 *
 * @author jonavcar
 */
@RestController
@RequestMapping("/walletbootcoin")
@RequiredArgsConstructor
public class WalletController {

    Logger logger = LoggerFactory.getLogger(WalletController.class);
    private final WalletOperations operations;

    @GetMapping
    public Flux<Wallet> listAll() {
        return operations.list();
    }

    @GetMapping("/{id}")
    public Mono<Wallet> get(@PathVariable("id") String id) {
        return operations.get(id);
    }

    @PostMapping
    public Mono<ResponseEntity> create(@RequestBody Wallet wallet) {
        return operations.create(wallet).flatMap(pR -> {
            if (pR.getStatus() == Status.OK) {
                return Mono.just(new ResponseEntity(pR.getData(), HttpStatus.OK));
            } else {
                return Mono.just(new ResponseEntity(pR.getMessage(), HttpStatus.BAD_REQUEST));
            }
        });
    }

    @PutMapping("/{id}")
    public Mono<Wallet> update(@PathVariable("id") String id, @RequestBody Wallet wallet) {
        return operations.update(id, wallet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        operations.delete(id);
    }

}
