package com.eirs.pairs.service;

import com.eirs.pairs.repository.entity.Duplicate;

public interface DuplicateService {

    Duplicate get(String imei, String imsi);

    Duplicate save(Duplicate duplicate);

}
