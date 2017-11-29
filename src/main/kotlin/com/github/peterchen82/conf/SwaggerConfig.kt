package com.github.peterchen82.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.service.ApiInfo
import org.springframework.web.context.request.async.DeferredResult
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
open class SwaggerConfig {

    @Bean
    open fun ProductApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult::class.java)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .build()
                .apiInfo(productApiInfo())
    }

    private fun productApiInfo(): ApiInfo {
        return ApiInfo("kotlin-in-springboot",
                "kotlin-in-springboot接口文档",
                "1.0",
                "https://github.com/peterchen82",
                "peterchen82@vip.qq.com",
                "apache-2.0",
                "http://www.apache.org/licenses/")
    }
}