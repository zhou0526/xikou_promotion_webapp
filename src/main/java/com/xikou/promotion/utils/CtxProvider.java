package com.xikou.promotion.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取全局的applicationContent上下文对象,可在项目任何地方引用
 * 
 * @author hunagqiang
 *
 */
// @Component注解定义的Bean，默认的名称（id）是小写开头的非限定类名(applicationContextProvider)
@Component
public class CtxProvider implements ApplicationContextAware {

	private static ApplicationContext context;

	public static ApplicationContext getContext() {

		return context;
	}

	public void setApplicationContext(ApplicationContext ctx) {

		context = ctx;
	}
}
