package stage;

public interface Stage {
    void changed();

    void beforeDestroy();

    String getNextStage();
}
