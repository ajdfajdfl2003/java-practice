package lombok;

import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class Child extends Parent {
    private String name;
    private Integer age;
}
