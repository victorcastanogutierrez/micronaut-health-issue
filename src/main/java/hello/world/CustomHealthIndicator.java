package hello.world;

import io.micronaut.context.annotation.Requires;
import io.micronaut.health.HealthStatus;
import io.micronaut.management.endpoint.health.HealthEndpoint;
import io.micronaut.management.health.indicator.AbstractHealthIndicator;
import io.micronaut.management.health.indicator.annotation.Liveness;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
@Liveness
@Requires(beans = HealthEndpoint.class)
public class CustomHealthIndicator extends AbstractHealthIndicator<Map<String, Object>> {

    @Override
    public String getName() {
        return "test-name";
    }

    @Override
    protected Map<String, Object> getHealthInformation() {
        healthStatus = HealthStatus.DOWN;
        Map<String, Object> detail = new HashMap<>(1);
        detail.put("error", "This will return 200 OK even when DOWN");
        return detail;
    }
}
