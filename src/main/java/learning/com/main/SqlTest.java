package learning.com.main;

import learning.com.enumeration.SexEnum;
import learning.com.mybatis.mapper.RoleMapper;
import learning.com.pojo.Role;
import learning.com.service.DeleteService;
import learning.com.service.RoleService;
import learning.com.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;


/**
 * Create by HuQiuYue on 2019-08-14
 */
public class SqlTest implements Serializable {

    @Autowired
    private static RoleService roleService;
    @Autowired private static UpdateService updateService;
    @Autowired private static DeleteService deleteService;
    private static Logger logger = Logger.getLogger(SqlTest.class);

    public static void main(String[] args) {



//        使用注解spring IoC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        System.out.println(applicationContext.getClass());
//        RoleMapper roleMapper = applicationContext.getBean(RoleMapper.class);

//        获取角色服务类
        roleService = applicationContext.getBean(RoleService.class);
        updateService = applicationContext.getBean(UpdateService.class);
        deleteService = applicationContext.getBean(DeleteService.class);

        Role role = new Role("Tony","123456",SexEnum.getSexById(0),"18800002222","tony@gmail.com","Tony looks handsome");
        Role role1 = new Role("Mary","1234567",SexEnum.getSexById(1),"18800001111","Mary@gmail.com","Mary is rich");
        Role role2 = new Role("Edith","1234567",SexEnum.getSexById(1),"18800003333","Edith@gmail.com","Edith is lucky");
        Role role3 = new Role("Sybil","1234567",SexEnum.getSexById(1),"18800004444","Sybil@gmail.com","Sybil is brave");
//        roleMapper.insertRole(role1);
//        roleMapper.insertRole(role);
//        roleService.insertRoleMembers(role2);
//        roleService.insertRoleMembers(role3);
//        roleService.selectOne(1);
//        role.setTel("0571-88880000");
//        role.setId(1);
//        updateService.updateTelNo(role);
//        deleteService.deleteById(5);



        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("classpath:spring-redis.xml");
        RedisTemplate redisTemplate = applicationContext1.getBean(RedisTemplate.class);
//        final Role role4 = new Role();
//        role4.setId(3);
//        role4.setUsername("MARY");
//        role4.setPassword("123456");
//
//        SessionCallback callback = new SessionCallback<Role>() {
//            @Override
//            public Role execute(RedisOperations ops) throws DataAccessException {
//                ops.boundValueOps("role_3").set(role4);
//                return (Role) ops.boundValueOps("role_3").get();
//            }
//        };
//        Role saveRole = (Role) redisTemplate.execute(callback);
//        System.out.println(saveRole.getUsername());

        // for test ping
//        Jedis jedis = new Jedis("127.0.0.1",6379);
//        System.out.println(jedis);
//        String ping = jedis.ping();
//        System.out.println(ping);

        // for test String
//        redisTemplate.opsForValue().set("key1","value1");
//        redisTemplate.opsForValue().set("key2","value2");
//        String value1 = (String) redisTemplate.opsForValue().get("key1");
//        System.out.println(value1);
//        redisTemplate.delete("key1");
//        Long length = redisTemplate.opsForValue().size("key2");
//        System.out.println(length);
//        String subValue2 = redisTemplate.opsForValue().get("key2",0,3);
//        System.out.println(subValue2);
//        int newValue2 = redisTemplate.opsForValue().append("key2","_add");
//        System.out.println(newValue2);
//        String newvalue = (String)redisTemplate.opsForValue().get("key2");
//        System.out.println(newvalue);

//        redis事务命令
//        SessionCallback callBack = (SessionCallback)(RedisOperations ops) ->{
//            ops.multi();
//            ops.boundValueOps("k1").set("v1");
//            String value = (String) ops.boundValueOps("k1").get();
//            System.out.println(value);
//            List list = ops.exec();
//            value = (String) redisTemplate.opsForValue().get("k1");
//            return value;
//        };
//
//        String value = (String)redisTemplate.execute(callBack);
//        System.out.println(value);

        Role role5 = new Role();
        role5.setUsername("Jenny");
        role5.setPassword("123456");
        role5.setSex(SexEnum.getSexById(1));
        role5.setEmail("Jenny@163.com");
        role5.setNote("Jenny is cute");
        role5.setMobile("18800005555");
//        roleService.insertRoleMembers(role5);
        role5.setTel("0571-88886666");


//        updateService.updateTelNo(role5);
        logger.info("role_" + role5.getId());
        roleService.selectOne(role5.getUsername());

//        Redis流水线
        Jedis jedis = new Jedis("127.0.0.1");
        Pipeline pipeline = jedis.pipelined();
        pipeline.set("hello","world");
        pipeline.incr("counter");
//        使用pipeline.syncAndReturnAll（）将 pipeline的命令进行返回
        List<Object> result = pipeline.syncAndReturnAll();
        for(Object object:result){
            System.out.println(object);
        }

    }
}
