package com.xikou.promotion.listener;

import com.weibo.api.motan.filter.opentracing.OpenTracingContext;
import com.xikou.promotion.mq.MessagePushConsumerServer;
import com.xikou.promotion.trace.BraveTarcerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.weibo.api.motan.closable.ShutDownHook;

@WebListener
public class WebAppServletContextListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(WebAppServletContextListener.class);

	public void contextInitialized(ServletContextEvent sce) {

		logger.error("容器初始化...,开始开启依赖服务!");
		try {
			MessagePushConsumerServer.start();
			logger.info("启动MQ服务成功!", WebAppServletContextListener.class);
		} catch (Exception e) {
			logger.error("启动MQ服务异常!", e);
			throw new RuntimeException("启动MQ服务异常!");
		}

		try {
			OpenTracingContext.tracerFactory = new BraveTarcerFactory();
		} catch (Exception e) {
			logger.error("实例化BraveTarcerFactory异常!", e);
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {

		if (logger.isDebugEnabled()) {
			logger.debug("容器销毁.....");
		}
		// web容器销毁时 优雅关闭客户端链接
		ShutDownHook.runHook(true);
		// 退出当前jvm进程
		Runtime.getRuntime().exit(0);
		try {
			MessagePushConsumerServer.destroy();
		} catch (Exception e) {
			logger.error("销毁MQ服务异常!", e);
		}
	}
}
