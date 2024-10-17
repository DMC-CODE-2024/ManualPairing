package com.eirs.pairs.service;

import com.eirs.pairs.constants.GSMAStatus;
import com.eirs.pairs.repository.PairingRepository;
import com.eirs.pairs.repository.entity.Pairing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class PairingServiceImpl implements PairingService {
    @Autowired
    private PairingRepository pairingRepository;

    @Override
    public Pairing save(Pairing pairing) {
        long start = System.currentTimeMillis();
        log.info("Going to Add for Pair : {} is saved ", pairing);
        Pairing pair = pairingRepository.save(pairing);
        log.info("Pair : {} is saved TimeTaken:{}", pair, (System.currentTimeMillis() - start));
        return pair;
    }


    @Override
    @Transactional
    public List<Pairing> saveAll(List<Pairing> pairings) {
        long start = System.currentTimeMillis();
        log.info("Going to Add for pairings : {} is saved ", pairings);
        pairings = pairingRepository.saveAll(pairings);
        log.info("Pair : {} is saved TimeTaken:{}", pairings, (System.currentTimeMillis() - start));
        return pairings;
    }

    @Override
    public List<Pairing> getPairsByImei(String imei) {
        long start = System.currentTimeMillis();
        log.info("Find in Pairing table imei : {}", imei);
        List<Pairing> pairs = pairingRepository.findByImei(imei);
        log.info("pairs found by IMEI : {} count : {} TimeTaken:{}", imei, pairs.size(), (System.currentTimeMillis() - start));
        return pairs;
    }

    @Override
    public List<Pairing> getPairsByActualImei(String actualImei) {
        long start = System.currentTimeMillis();
        log.info("Find in pairing table  actual imei : {}", actualImei);
        List<Pairing> pairs = pairingRepository.findByActualImei(actualImei);
        log.info("pairs found by actualImei : {} count : {} TimeTaken:{}", actualImei, pairs.size(), (System.currentTimeMillis() - start));
        return pairs;
    }

    @Override
    public Pairing getPairsByMsisdn(String imei, String msisdn) {
        long start = System.currentTimeMillis();
        log.info("Find in Pairing table imei : {}, msisdn : {}", imei, msisdn);
        Pairing pairing = pairingRepository.findByImeiAndMsisdn(imei, msisdn);
        if (pairing == null) {
            log.info("Pair not found by IMEI:{} msisdn:{} TimeTaken:{}", imei, msisdn, (System.currentTimeMillis() - start));
            return null;
        } else {
            log.info("Pair found by IMEI:{} msisdn:{} pairing:{} TimeTaken:{}", imei, msisdn, pairing, (System.currentTimeMillis() - start));
            return pairing;
        }
    }

    @Override
    public Pairing getPairsActualImeiByMsisdn(String actualImei, String msisdn) {
        log.info("Find in Pairing table actual imei : {}, msisdn : {}", actualImei, msisdn);
        Pairing pairing = pairingRepository.findByActualImeiAndMsisdn(actualImei, msisdn);
        if (pairing == null) {
            log.info("Pair not found by actualImei:{} msisdn:{}", actualImei, msisdn);
            return null;
        } else {
            log.info("Pair found by actualImei:{} msisdn:{}", actualImei, msisdn);
            return pairing;
        }
    }

    @Override
    public List<Pairing> getPairsByMsisdn(String msisdn) {
        long start = System.currentTimeMillis();
        log.info("Find in Pairing table msisdn : {}", msisdn);
        List<Pairing> pairs = pairingRepository.findByMsisdn(msisdn);
        log.info("pairs found by msisdn : {} count : {} TimeTaken:{}", msisdn, pairs.size(), (System.currentTimeMillis() - start));
        return pairs;
    }

}
