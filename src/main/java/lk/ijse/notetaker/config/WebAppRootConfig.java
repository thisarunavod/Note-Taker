package lk.ijse.notetaker.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "lk.ijse.notetaker")
@EnableWebMvc
@EnableJpaRepositories
@EnableTransactionManagement

public class WebAppRootConfig {
    /*@Bean   --> source code naaa eeky dala tyenne  */
    @Bean
    public DataSource dataSource() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {  /* entity manage eka hada gannawa */

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.acme.domain");
        factory.setDataSource(dataSource());
        return factory;

    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }


    /* main configuration 3 methana karala tiyanawa.OK

    ewa tmy  >>>
                    1* Data source
                    2* Entity Manager
                    3* Transaction

    Data source  ekak use karannee database ekka manage karanna.
    dsource ekak DB ekak wenna oonama naa.

            > web service ekak wennath pluwn
            > File system ekak wenna puluwn

    datasource types ---->>
                    * Basic data source (meke normally connection pool facility tynawa )

                                                                        connection pool
                                                                                |
                                                                                |
                                                   clent    ----->  data source  -----> RDB
                                                            <-----               <-----



                    * Driver manager  Data source  ( simple)

                    * ComboPooled data sources

                    * Hikari Data Source ( most usable industry and production level, performance wadi )

                    * JNDI Datasource ( lookup through JNDI )


        2. Entity Manager





    */



}
