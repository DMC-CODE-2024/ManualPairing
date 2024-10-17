package com.eirs.pairs.repository;

import com.eirs.pairs.repository.entity.Pairing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PairingRepository extends JpaRepository<Pairing, Long> {

    List<Pairing> findByImei(String imei);

    List<Pairing> findByActualImei(String actualImei);

    Pairing findByImeiAndMsisdn(String imei, String msisdn);

    Pairing findByActualImeiAndMsisdn(String imei, String msisdn);

    List<Pairing> findByMsisdn(String msisdn);
}
