

package com.codeabovelab.dm.cluman.ui;

import com.codeabovelab.dm.cluman.job.JobInstance;
import com.codeabovelab.dm.cluman.job.JobsManager;
import com.codeabovelab.dm.cluman.model.RootSource;
import com.codeabovelab.dm.cluman.reconfig.AppConfigService;
import com.codeabovelab.dm.cluman.source.DeployOptions;
import com.codeabovelab.dm.cluman.source.SourceService;
import com.codeabovelab.dm.cluman.ui.model.UiApplicationInfo;
import com.codeabovelab.dm.cluman.ui.model.UiJob;
import com.codeabovelab.dm.cluman.yaml.YamlUtils;
import com.codeabovelab.dm.common.security.Authorities;
import com.codeabovelab.dm.common.utils.AppInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.InputStream;

/**
 */
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(value = "/ui/api/", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
@RestController
public class ConfigurationApi {

    private final Environment environment;
    private final AppConfigService appConfigService;
    private final SourceService sourceService;
    private final JobsManager jobsManager;

    @RequestMapping(path = "config", method = RequestMethod.GET)
    public ResponseEntity<StreamingResponseBody> getConfig() {
        HttpHeaders headers = new HttpHeaders();
        // 'produces' in annotation does not work with stream
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"cluman_config.json\"");
        return new ResponseEntity<>((os) -> {
            appConfigService.write(MimeTypeUtils.APPLICATION_JSON_VALUE, os);
        }, headers, HttpStatus.OK);
    }

    @Secured(Authorities.ADMIN_ROLE)
    @RequestMapping(path = "config", method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public void setConfig(InputStream is) throws IOException {
        appConfigService.read(MimeTypeUtils.APPLICATION_JSON_VALUE, is);
    }

    @RequestMapping(path = "source", method = RequestMethod.GET, produces = YamlUtils.MIME_TYPE_VALUE)
    public ResponseEntity<RootSource> getSource() {
        RootSource source = sourceService.getRootSource();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"cluman_source.yaml\"");
        return new ResponseEntity<>(source, headers, HttpStatus.OK);
    }

    @Secured(Authorities.ADMIN_ROLE)
    @RequestMapping(path = "source", method = RequestMethod.POST, consumes = YamlUtils.MIME_TYPE_VALUE)
    public UiJob setSource(@RequestBody RootSource root,
                           DeployOptions.Builder options) {
        JobInstance jobInstance = sourceService.setRootSource(root, options.build());
        return UiJob.toUi(jobInstance);
    }

    @Secured(Authorities.ADMIN_ROLE)
    @RequestMapping(path = "source-upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UiJob uploadSource(@RequestPart("file") RootSource root,
                              DeployOptions.Builder options) {
        JobInstance jobInstance = sourceService.setRootSource(root, options.build());
        return UiJob.toUi(jobInstance);
    }

    // strange that getAppInfo has 'version' mapping
    @RequestMapping(path = {"version", "info"}, method = RequestMethod.GET)
    public UiApplicationInfo getAppInfo() {
        return UiApplicationInfo.builder()
                .version(AppInfo.getApplicationVersion())
                .buildTime(AppInfo.getBuildTime())
                .buildRevision(AppInfo.getBuildRevision())
                .address(UiUtils.getAppAddress(environment))
          .build();

    }
}
