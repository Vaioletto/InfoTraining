package com.example.infotraining.entity;
/*
 * @author: Vu Ngoc Sang
 * @Date: 19/09/2020
 * @Role: Intern
 */
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long message_id;
    private String message_name;
    private String message_type;
    private String sender;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
}
