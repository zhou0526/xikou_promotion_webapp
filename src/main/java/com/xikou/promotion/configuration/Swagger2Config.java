package com.xikou.promotion.configuration;

import static springfox.documentation.schema.AlternateTypeRules.newRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import com.fasterxml.classmate.TypeResolver;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2Config {

	@Autowired
	private TypeResolver typeResolver;

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()//
			.apis(RequestHandlerSelectors.basePackage("com.xikou.promotion.controller"))//
			.paths(PathSelectors.any()).build().apiInfo(apiInfo()).alternateTypeRules( // 自定义规则,如果遇到DeferredResult,则把泛型类转成json
				newRule(typeResolver.resolve(DeferredResult.class, typeResolver//
					.resolve(ResponseEntity.class, WildcardType.class)), typeResolver.resolve(WildcardType.class)));
	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder().title("促销系统接口文档").description("促销相关接口").//
			termsOfServiceUrl("http://localhost:8081/").contact(new Contact("大强", "", "XXXX.com"))//
			.version("1.0").build();
	}

	@Bean
	public UiConfiguration getUiConfig() {

		return new UiConfiguration(null, // url,暂不用
			"list", // docExpansion => none | list
			"alpha", // apiSorter => alpha
			"schema", // defaultModelRendering => schema
			null, false, // enableJsonEditor => true | false
			true, 5000L); // showRequestHeaders => true | false
	}
}
