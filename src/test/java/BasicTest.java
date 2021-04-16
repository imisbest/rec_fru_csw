import com.csw.Application;
import com.csw.entity.User;
import com.csw.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by HIAPAD on 2019/10/30.
 */
//
@RunWith(SpringRunner.class)  //==@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BasicTest {
    @Autowired
    private UserService userService;


    @Test
    public void test0() {
        User uu = userService.queryByNameAndPassword("qqq", "qqq");
        System.out.println(uu);
    }


}

