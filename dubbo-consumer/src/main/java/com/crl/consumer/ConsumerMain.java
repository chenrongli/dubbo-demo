package com.crl.consumer;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crl.api.DemoService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@ImportResource("classpath:dubbo.xml")
public class ConsumerMain 
{
    @Resource
    private DemoService demoService ;
    public static void main( String[] args )
    {
        SpringApplication.run(ConsumerMain.class, args);
    }


    /**
     * 1
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        
        return demoService.hello("hahha");

    }
    
}
