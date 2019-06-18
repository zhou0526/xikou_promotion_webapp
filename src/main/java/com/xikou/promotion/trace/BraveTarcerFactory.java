
package com.xikou.promotion.trace;

import brave.Tracing;
import brave.opentracing.BraveTracer;
import com.weibo.api.motan.filter.opentracing.TracerFactory;
import org.springframework.beans.factory.annotation.Value;
import io.opentracing.Tracer;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.okhttp3.OkHttpSender;

public class BraveTarcerFactory implements TracerFactory {

	@Value("${zipkin.url}")
	private static String zipkinUrl = "http://47.106.103.128:9411/api/v2/spans";

	private static Tracer braveTracer = BraveTracer.create(Tracing.newBuilder()
		// 设置当前服务的服务名
		.localServiceName("promotion-webapp")
		// 采用OkHttpSender通过HTTP请求的方式发送跟踪数据
		.spanReporter(AsyncReporter.create(OkHttpSender.create(zipkinUrl))).build());

	@SuppressWarnings("deprecation")
	@Override
	public Tracer getTracer() {

		return braveTracer;
	}

}
