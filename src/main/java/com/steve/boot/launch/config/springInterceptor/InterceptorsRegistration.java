package com.steve.boot.launch.config.springInterceptor;

import com.steve.boot.launch.model.AccessLog;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class InterceptorsRegistration implements WebMvcConfigurer {
    @Resource
    CustomHandlerInterceptor customHandlerInterceptor;

    @Resource
    AccessLogInterceptor accessLogInterceptor;
    private final String[] excludePath = {"/static","/public","resource"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //the registration order is the execution order
        registry.addInterceptor(customHandlerInterceptor)
                .addPathPatterns("/thymeleaf/*");

        registry.addInterceptor(accessLogInterceptor).addPathPatterns("/**").excludePathPatterns(excludePath);
        /**
         * the interceptor have to point to a specific controller like we have done above
         * if setting like this down bellow, the interceptor is not going to work effectively:
         *
         * registry.addInterceptor(customHandlerInterceptor).addPathPatterns("/*");
         *
         *
         */

        //设置排除路径，spring boot 2.*，注意排除掉静态资源的路径，不然静态资源无法访问

    }
}
