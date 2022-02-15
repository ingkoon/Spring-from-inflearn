package Koon.sDiary.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
//import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //private DataSource dataSource;
    private EntityManager em;

    @Autowired
    public SpringConfig() {
      //  this.dataSource = dataSource;
        this.em = em;
    }
}
