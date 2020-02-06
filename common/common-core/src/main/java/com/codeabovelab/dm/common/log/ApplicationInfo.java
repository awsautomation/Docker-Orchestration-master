

package com.codeabovelab.dm.common.log;

/**
 * Information which helps to identify instance: contains host, app name and version
 */
public interface ApplicationInfo {
    /**
     * @see com.codeabovelab.dm.common.utils.OSUtils#getHostName()
     * @return
     */
    String getHost();

    /**
     * @see com.codeabovelab.dm.common.utils.AppInfo#getApplicationName()
     * @return
     */
    String getApplication();
    /**
     *
     * @see com.codeabovelab.dm.common.utils.AppInfo#getApplicationVersion()
     * @return
     */
    String getApplicationVersion();
}
