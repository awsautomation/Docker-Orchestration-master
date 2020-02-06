

package com.codeabovelab.dm.common.log;

import lombok.Data;

import java.util.Date;

/**
 * basic record of log message which can be transferred into logstash
 *
 */
@Data
public class BasicLogRecord implements ApplicationInfo {
    private String host;
    /**
     * @see com.codeabovelab.dm.common.utils.AppInfo#getApplicationName()
     */
    private String application;
    /**
     * @see com.codeabovelab.dm.common.utils.AppInfo#getApplicationVersion()
     */
    private String applicationVersion;
    /**
     * Type of record (like 'log' or 'metric'), it used
     * in analyzing software (like kibana or zabbix) for grouping messages.
     */
    private String type;
    private String message;
    /**
     * Additional description of log entry
     */
    private String description;
    /**
     * Timestamp of event
     */
    private Date date;

}
