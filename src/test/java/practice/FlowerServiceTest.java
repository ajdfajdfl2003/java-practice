package practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.argThat;

@RunWith(PowerMockRunner.class)
public class FlowerServiceTest {

    @Mock
    IPerson farmer;

    @Test
    public void when_run_then_farmer_should_doSomething() {
        FlowerService service = new FlowerService(farmer);
        service.run();

        Student student = new Student("angus", 123);
        Mockito.verify(farmer, Mockito.times(1))
                .doSomething(argThat(new StudentMatcher(student)));
    }
}