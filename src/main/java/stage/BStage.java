package stage;

public class BStage implements Stage {
    private final Module module;

    public BStage(Module module) {
        this.module = module;
    }

    @Override
    public void changed() {
        module.nextStage(2000);
    }

    @Override
    public void beforeDestroy() {
        //預期這個會做很久，怕影響到 CStage change 裡在做的事情
        //所n以要等他做完才能繼續往下
        new ProcessTask().run();
    }

    @Override
    public String getNextStage() {
        return CStage.class.getSimpleName();
    }
}
