package com.gdut;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

/**
 * Created by huang on 2017/1/5.
 */
@SpringBootApplication
@MapperScan("com.gdut.dao")//扫描:mybatis的xml
public class Main {


    //使用阿里的fastJSON来替换jsckson
    @Bean
    public HttpMessageConverters fasJsonHttpMessageConverters(){
        //定义convert转换对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();

        //添加fastjson的配置信息，
        FastJsonConfig fastJsonConfig=new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        //添加配置信息
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        //返回
        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }

    //程序入口
    public static void main(String args[]){
        SpringApplication.run(Main.class, args);
    }
}
