package com.banck.walletbootcoin.domain;

import lombok.Data;

/**
 *
 * @author jonavcar
 */
@Data
public class Wallet {

    public String wallet;
    public String document;
    public String documentType;
    public String telephone;
    public String mail;
    public String date;
    public boolean state;
}
