package com.shinzul.blog.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;
import com.mongodb.Mongo;
import com.shinzul.blog.configuration.DatabaseConfig;
import com.shinzul.blog.dao.UserRepository;
import com.shinzul.blog.entity.User;
import com.shinzul.blog.test.configuration.TestPropertyConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestPropertyConfig.class, DatabaseConfig.class})
public class UserRepositoryTest {
	
	/**
     * Spring Data Repository
     */
    @Autowired
    UserRepository userRepository;
 
    /**
     * MongoDB Java client
     */
    @Autowired
    Mongo mongo;
    
    /**
     * MongoDb Database name determined by test resource {@link TestPropertyConfig}
     */
    @Value("${datasource.dbname}")
    String databaseName;
    
    /**
     * Initialize MongoDB with Java client
     */
    @Before
    public void setUp() throws Exception {
        // Drop database
        mongo.dropDatabase(databaseName);
        // Create database
        mongo.getDB(databaseName);
    }
    
    /**
     * Spring Data : Create and search Category in MongoDB
     */
    @Test
    public void testInsert() {
 
        User user = new User();
        user.setUsername("Test");
        user.setPassword("test");
        
        userRepository.save(user);
 
        Iterable<User> iterable = userRepository.findAll();
 
        List<User> categories = Lists.newArrayList(iterable);
        
        assertNotNull(user.getId());
        assertEquals(1, categories.size());
 
    }
    
    /**
     * Clean MongoDB with Java client
     */
    @After
    public void after() {
        mongo.dropDatabase(databaseName);
    }

}
