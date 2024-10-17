package com.eirs.pairs.service;

import com.eirs.pairs.repository.InvalidImeiRepository;
import com.eirs.pairs.repository.entity.InvalidImei;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvalidImeiServiceImpl implements InvalidImeiService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    InvalidImeiRepository invalidImeiRepository;

    private Set<String> cache = new HashSet<>();

    public Boolean isPresent(String imei) {
        long start = System.currentTimeMillis();
        log.info("Checking in InvalidImei for imei:{}", imei);
        Optional<InvalidImei> invalidImei = invalidImeiRepository.findByImei(imei);
        log.info("Found in InvalidImei for imei:{} found:{} TimeTaken:{}", imei, invalidImei.isPresent(), (System.currentTimeMillis() - start));
        return invalidImei.isPresent();
    }

}
