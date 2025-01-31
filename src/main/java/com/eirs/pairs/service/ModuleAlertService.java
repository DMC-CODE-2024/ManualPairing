package com.eirs.pairs.service;

import com.eirs.pairs.alerts.AlertService;
import com.eirs.pairs.alerts.constants.AlertIds;
import com.eirs.pairs.alerts.constants.AlertMessagePlaceholders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ModuleAlertService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AlertService alertService;


    public void sendConfigurationMissingAlert(String configKey, String featureName) {
        Map<AlertMessagePlaceholders, String> map = new HashMap<>();
        map.put(AlertMessagePlaceholders.CONFIG_KEY, configKey);
        map.put(AlertMessagePlaceholders.FEATURE_NAME, featureName);
        alertService.sendAlert(AlertIds.CONFIGURATION_VALUE_MISSING, map);
    }

    public void sendSmsConfigMissingAlert(String configKey, String featureName, String language) {
        Map<AlertMessagePlaceholders, String> map = new HashMap<>();
        map.put(AlertMessagePlaceholders.CONFIG_KEY, configKey);
        map.put(AlertMessagePlaceholders.FEATURE_NAME, featureName);
        map.put(AlertMessagePlaceholders.LANGUAGE, language);
        alertService.sendAlert(AlertIds.SMS_VALUE_MISSING, map);
    }

    public void sendSmsNotSentAlert(String error, String sms) {
        Map<AlertMessagePlaceholders, String> map = new HashMap<>();
        map.put(AlertMessagePlaceholders.EXCEPTION, error);
        map.put(AlertMessagePlaceholders.SMS, sms);
        alertService.sendAlert(AlertIds.NOTIFICATION_SEND_EXCEPTION, map);
    }

    public void sendDatabaseAlert(String error, String featureName) {
        Map<AlertMessagePlaceholders, String> map = new HashMap<>();
        map.put(AlertMessagePlaceholders.EXCEPTION, error.length()>78 ? error.substring(0,78):error);
        map.put(AlertMessagePlaceholders.FEATURE_NAME, featureName);
        if (error.contains("doesn't exist")) {
            alertService.sendAlert(AlertIds.DATABASE_TABLE_EXCEPTION, map);
        } else {
            alertService.sendAlert(AlertIds.DATABASE_EXCEPTION, map);
        }
    }

    public void sendConfigurationWrongValueAlert(String configKey, String configValue, String featureName) {
        Map<AlertMessagePlaceholders, String> map = new HashMap<>();
        map.put(AlertMessagePlaceholders.CONFIG_KEY, configKey);
        map.put(AlertMessagePlaceholders.CONFIG_VALUE, configValue);
        alertService.sendAlert(AlertIds.CONFIGURATION_VALUE_WRONG, map);
    }

}
