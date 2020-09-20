package com.example.infotraining.entity;/*
 * Author: Vu Ngoc Sang
 * Date: 19/09/2020
 * Role: Intern
 */

import lombok.Data;

import java.util.List;

@Data
public class TransferMoney {
    private String message_name;
    private String message_type;
    private List<Transaction> transaction;
}
