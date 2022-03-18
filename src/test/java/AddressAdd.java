import com.github.pagehelper.PageHelper;
import com.tledu.mybatis.demo.dao.IPaging;
import com.tledu.mybatis.demo.entity.Address;
import com.tledu.mybatis.demo.entity.PageInfos;
import com.tledu.mybatis.demo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AddressAdd {
    private SqlSession session;
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }
    @Test
    public void pageU(){
        User user =new User("123","456");
        int count = session.getMapper(IPaging.class).countU(user);
        PageInfos<User> pageInfo = new PageInfos<User>(2,1);
        List<User> userList = session.getMapper(IPaging.class).pageUser(pageInfo.getStart(),pageInfo.getPageSize(),user);
        pageInfo.setList(userList);
        pageInfo.setTotal(count);
        System.out.println(pageInfo);
    }
    @Test
    public void pageA(){
        Address address=new Address();
        address.setAddr("龙龙");
        address.setPostcode("312");
        PageInfos<Address> pageInfo = new PageInfos<Address>(5,1);
        List<Address> addressList = session.getMapper(IPaging.class).pageAddress(pageInfo.getStart(),pageInfo.getPageSize(),address);
        int count = session.getMapper(IPaging.class).countA(address);
        pageInfo.setList(addressList);
        pageInfo.setTotal(count);
        System.out.println(pageInfo);
    }
    @Test
    public void pageA1(){
        PageHelper.startPage(1,5);
        List<User> list = session.getMapper(IPaging.class).listU();
    }
    @Test
    public void pageU1(){
        PageHelper.startPage(1,2);
        List<Address> list = session.getMapper(IPaging.class).listA();
    }
    @After
    public void after(){
        session.commit();
        session.close();
    }
}
