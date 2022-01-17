package stage;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CStage implements Stage {
    private final Module module;

    public CStage(Module module) {
        this.module = module;
    }

    @Override
    public void changed() {
        log.info("[CStage] must after than [BStage Process]");
        module.nextStage(2000);
    }

    @Override
    public void beforeDestroy() {
    }

    @Override
    public String getNextStage() {
        return BStage.class.getSimpleName();
    }
}
