package com.example.studyspringboot.commont;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能：
 * 作者：熊奎
 * 日期：2023/11/11 23:27
 */
    @Configuration
    @MapperScan("com.example.springboot.mapper")
    public class MybatisPlusConfig {

        /**
         * 添加分页插件
         */
        @Bean
        public MybatisPlusInterceptor mybatisPlusInterceptor() {
            MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
            //如果配置多个插件,切记分页最后添加
            interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
            return interceptor;
        }
    }
