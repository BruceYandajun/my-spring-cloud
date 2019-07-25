import com.github.bruce.rpc.UserFeign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeignTest {

    @Resource
    private UserFeign userFeign;

    @Test
    public void getUserById() {
        System.out.println(userFeign.getUserId());
        System.out.println(userFeign.getUserId());
        System.out.println(userFeign.getUserId());
    }
}
