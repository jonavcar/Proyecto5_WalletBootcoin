package com.banck.walletbootcoin.infraestructure.repository;

import com.banck.walletbootcoin.domain.Wallet;
import com.banck.walletbootcoin.infraestructure.model.dao.WalletDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.walletbootcoin.aplication.model.WalletRepository;

/**
 *
 * @author jonavcar
 */
@Component
public class WalletCrudRepository implements WalletRepository {

    @Autowired
    IWalletCrudRepository crudRepository;

    @Override
    public Mono<Wallet> get(String debitcardaccount) {
        return crudRepository.findById(debitcardaccount).map(this::WalletDaoToWallet);
    }

    @Override
    public Flux<Wallet> list() {
        return crudRepository.findAll().map(this::WalletDaoToWallet);
    }

    @Override
    public Mono<Wallet> create(Wallet debitcardaccount) {
        return crudRepository.save(PersonToWalletDao(debitcardaccount)).map(this::WalletDaoToWallet);
    }

    @Override
    public Mono<Wallet> update(String debitcardaccount, Wallet c) {
        return crudRepository.save(PersonToWalletDao(c)).map(this::WalletDaoToWallet);
    }

    @Override
    public void delete(String debitcardaccount) {
        crudRepository.deleteById(debitcardaccount).subscribe();
    }

    public Wallet WalletDaoToWallet(WalletDao md) {
        Wallet m = new Wallet();
        m.setWallet(md.getWallet());
        m.setDocument(md.getDocument());
        m.setDocumentType(md.getDocumentType());
        m.setTelephone(md.getTelephone());
        m.setMail(md.getMail());
        m.setDate(md.getDate());
        m.setState(md.isState());
        return m;
    }

    public WalletDao PersonToWalletDao(Wallet p) {
        WalletDao pd = new WalletDao();
        pd.setWallet(p.getWallet());
        pd.setDocument(p.getDocument());
        pd.setDocumentType(p.getDocumentType());
        pd.setTelephone(p.getTelephone());
        pd.setMail(p.getMail());
        pd.setDate(p.getDate());
        pd.setState(p.isState());
        return pd;
    }

    @Override
    public Flux<Wallet> listByDocument(String document) {
        return crudRepository.findAllByDocument(document).map(this::WalletDaoToWallet);
    }

}
