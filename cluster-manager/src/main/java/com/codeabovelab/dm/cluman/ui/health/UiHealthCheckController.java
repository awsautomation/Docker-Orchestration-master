
package com.codeabovelab.dm.cluman.ui.health;

import com.codeabovelab.dm.common.healthcheck.ServiceHealthCheckResult;
import com.codeabovelab.dm.common.healthcheck.ServiceHealthCheckResultImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller which invoke health check
 */
@RestController
@RequestMapping("/ui/api/")
public class UiHealthCheckController {

    private final HealthCheckService service;

    @Autowired
    public UiHealthCheckController(HealthCheckService service) {
        this.service = service;
    }

    @RequestMapping(value = "/clusters/{cluster}/containers/{id}/check", method = RequestMethod.GET)
    public ServiceHealthCheckResult checkContainer(@PathVariable("cluster") String cluster, @PathVariable("id") String id) {
        //TODO use timeout from parameters
        ServiceHealthCheckResult result = service.checkContainer(cluster, id, 10_000L);
        if(result == null) {
            ServiceHealthCheckResultImpl.Builder b = new ServiceHealthCheckResultImpl.Builder();
            b.setHealthy(false);
            result = b;
        }
        return result;
    }

    @RequestMapping(value = "/healthcheck/check", method = RequestMethod.GET)
    public List<ServiceHealthCheckResult> check() {
        List<ServiceHealthCheckResult> list = new ArrayList<>();
        service.checkAll(list::add);
        return list;
    }


}
