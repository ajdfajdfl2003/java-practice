package lombok;

import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Parent {
    private Long createTime;
    private Boolean delete;
}
