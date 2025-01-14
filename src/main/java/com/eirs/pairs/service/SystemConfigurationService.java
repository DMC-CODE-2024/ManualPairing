package com.eirs.pairs.service;

import com.eirs.pairs.constants.NotificationLanguage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public interface SystemConfigurationService {

    Set<String> getAllowedDeviceTypes();

    NotificationLanguage getDefaultLanguage();

    LocalTime getNotificationSmsStartTime();

    LocalTime getNotificationSmsEndTime();

    Integer getPairingAllowDays();

    Integer getPairingAllowCount();

    Integer getMsisdnMinLength();

    Integer getMsisdnMaxLength();

    Integer getMaxOtpValidRetries();

}
