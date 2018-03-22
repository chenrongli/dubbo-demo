package com.crl.provider;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@ImportResource("classpath:dubbo.xml")
public class ProviderMain 
{
    
    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }
    
    public static void main( String[] args ) throws Exception
    {
        
        /* dubbo官方例子启动
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"classpath:dubbo.xml"});
        context.start();
        // press any key to exit
        System.in.read();*/
        
//        正常启动spring boot 带web功能
//        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
//      屏蔽web功能（不打开容器？）
        ApplicationContext ctx = new SpringApplicationBuilder()
        .sources(ProviderMain.class)
        .web(false)
        .run(args);

        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
        closeLatch.await();
    }

    /**
     * 2
     * @return
     */
    @RequestMapping("/test")
    public String test(){
        
        return "provider test";
    }
    
}
