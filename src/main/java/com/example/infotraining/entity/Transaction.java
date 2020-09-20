package com.example.infotraining.entity;
/*
 * @author: Vu Ngoc Sang
 * @Date: 19/09/2020
 * @Role: Intern
 */
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostLoad;

@Data
@Entity
public class Transaction {
    @Id
    private String transaction_id;
    private long message_id;
    private String sender_acct;
    private String receiver_acct;
    private float amount;
    private String currency;
}
