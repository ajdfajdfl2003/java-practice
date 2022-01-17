package stage;

import com.google.common.collect.ImmutableMap;
import lombok.extern.log4j.Log4j2;

import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Log4j2
public class Module {
    private final ScheduledExecutorService executor =
            new ScheduledThreadPoolExecutor(1);
    private final Map<String, Stage> stages = ImmutableMap.of(
            BStage.class.getSimpleName(), new BStage(this),
            CStage.class.getSimpleName(), new CStage(this)
    );
    private Stage currentStage = stages.get(BStage.class.getSimpleName());

    public void nextStage(long delayMilliSeconds) {
        executor.schedule(() -> {
            try {
                Stage oldStage = currentStage;
                Stage newStage = stages.get(currentStage.getNextStage());

                oldStage.beforeDestroy();

                currentStage = newStage;
                newStage.changed();
            } catch (Throwable e) {
                log.error(e);
            }
        }, delayMilliSeconds, TimeUnit.MILLISECONDS);
    }
}
