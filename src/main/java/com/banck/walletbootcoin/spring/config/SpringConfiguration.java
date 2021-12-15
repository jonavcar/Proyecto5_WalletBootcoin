package com.banck.walletbootcoin.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.banck.walletbootcoin.infraestructure.repository.WalletCrudRepository;
import com.banck.walletbootcoin.aplication.model.WalletRepository;

/**
 *
 * @author jonavcar
 */
@Configuration
public class SpringConfiguration {

    @Bean
    public WalletRepository walletRepository() {
        return new WalletCrudRepository();
    }
}
