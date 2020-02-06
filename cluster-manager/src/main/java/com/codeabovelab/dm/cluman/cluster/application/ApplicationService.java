

package com.codeabovelab.dm.cluman.cluster.application;

import com.codeabovelab.dm.cluman.cluster.compose.model.ComposeArg;
import com.codeabovelab.dm.cluman.model.Application;
import com.codeabovelab.dm.cluman.model.ApplicationSource;

import java.io.File;
import java.util.List;

public interface ApplicationService {

    String APP_LABEL = "appLabel";

    List<Application> getApplications(String cluster);

    //TODO move long term commands to jobs
    void startApplication(String cluster, String id) throws Exception;

    CreateApplicationResult deployCompose(ComposeArg composeArg) throws Exception;

    void stopApplication(String cluster, String id);

    Application getApplication(String cluster, String id) ;

    ApplicationSource getSource(String cluster, String id);

    File getInitComposeFile(String cluster, String appId);

    void addApplication(Application application);

    void removeApplication(String cluster, String id);
}
