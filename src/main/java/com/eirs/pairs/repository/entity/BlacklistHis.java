package com.eirs.pairs.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "black_list_his")
public class BlacklistHis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer operation;

    private String actualImei;

    private String tac;

    private String imei;

    private String imsi;

    private String msisdn;

    private String operatorId;

    private String operatorName;

    private String source;

    private LocalDateTime createdOn;

}
