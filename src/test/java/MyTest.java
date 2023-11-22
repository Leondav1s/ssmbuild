import com.davis.pojo.Books;
import com.davis.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: Leondav1s
 * @Date: 11/22/23 9:30 AM
 */
public class MyTest {

    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl=context.getBean("BookServiceImpl",BookService.class);
        List<Books> booklist= bookServiceImpl.queryAllBook();
        for(Books books:booklist){
            System.out.println(books);
        }
    }

}
