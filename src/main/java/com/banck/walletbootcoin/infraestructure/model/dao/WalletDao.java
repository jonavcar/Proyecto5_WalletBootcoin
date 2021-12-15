package com.banck.walletbootcoin.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jonavcar
 */
@Data
@Document("wallet")
public class WalletDao {

    @Id
    public String wallet;
    public String document;
    public String documentType;
    public String telephone;
    public String mail;
    public String date;
    public boolean state;
}
