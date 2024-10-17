package com.eirs.pairs.service;

import com.eirs.pairs.repository.entity.Pairing;

import java.util.List;

public interface PairingService {

    Pairing save(Pairing pairing);

    List<Pairing> saveAll(List<Pairing> pairings);

    List<Pairing> getPairsByImei(String imei);

    List<Pairing> getPairsByActualImei(String actualImei);

    Pairing getPairsByMsisdn(String imei, String msisdn);

    Pairing getPairsActualImeiByMsisdn(String actualImei, String msisdn);

    List<Pairing> getPairsByMsisdn(String msisdn);

}
