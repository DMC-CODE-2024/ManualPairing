package com.eirs.pairs.service;

import com.eirs.pairs.repository.BlackListHisRepository;
import com.eirs.pairs.repository.BlackListRepository;
import com.eirs.pairs.repository.entity.Blacklist;
import com.eirs.pairs.repository.entity.BlacklistHis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlackListServiceImpl implements BlackListService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BlackListHisRepository blacklistHisRepository;

    @Autowired
    BlackListRepository blacklistRepository;

    private final String PAIRING = "PAIRING";

    public Blacklist save(Blacklist blacklist) {
        try {

            long start = System.currentTimeMillis();
            log.info("going to save in BlackList : {}", blacklist);
            blacklist = blacklistRepository.save(blacklist);
            log.info("Saved in to Blacklist:{} TimeTaken:{}", blacklist, (System.currentTimeMillis() - start));
        } catch (Exception e) {
            log.error("Exception while adding to BlackList blacklist:{} Error:{}", blacklist, e.getMessage(), e);
        }
        return blacklist;
    }

    @Override
    public List<Blacklist> findByImei(String imei) {
        long start = System.currentTimeMillis();
        log.info("going to find BlackList imei:{}", imei);
        List<Blacklist> blacklists = blacklistRepository.findByImei(imei);
        log.info("Found Blacklist for Imei:{} blacklists:{} TimeTaken:{}", imei, blacklists, (System.currentTimeMillis() - start));
        return blacklists;
    }

    @Override
    public List<Blacklist> findByImeiAndImsiAndMsisdn(String imei, String imsi, String msisdn) {
        long start = System.currentTimeMillis();
        log.info("Going to check Blacklist using imei : {} imsi : {} msisdn:{}", imei, imsi, msisdn);
        List<Blacklist> blacklists = blacklistRepository.findByImeiAndImsiAndMsisdn(imei, imsi, msisdn);
        log.info("Blacklist using imei : {} imsi : {}, msisdn:{}, is : {} TimeTaken:{}", imei, imsi, msisdn, blacklists, (System.currentTimeMillis() - start));
        return blacklists;
    }

    public BlacklistHis save(BlacklistHis blacklistHis) {
        try {
            long start = System.currentTimeMillis();
            log.info("going to save in BlackListHis : {}", blacklistHis);
            blacklistHis = blacklistHisRepository.save(blacklistHis);
            log.info("Saved in to BlacklistHis:{} TimeTaken:{}", blacklistHis, (System.currentTimeMillis() - start));
        } catch (Exception e) {
            log.error("Exception while adding to BlackListHis blacklistHis:{} Error:{}", blacklistHis, e.getMessage(), e);
        }
        return blacklistHis;
    }

}
