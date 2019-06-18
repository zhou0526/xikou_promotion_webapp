package com.xikou.promotion.mq;

import java.util.List;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class MessagePushConsumerServer {

	private static final Logger logger = LoggerFactory.getLogger(MessagePushConsumerServer.class);

	public static void start() throws Exception {

	}

	public static void destroy() throws Exception {

	}

	/**
	 * 是否处理堆积消息
	 *
	 * @param msgs
	 */
	private static boolean isProcessedDiffMessage(List<MessageExt> msgs) {

		boolean flag = false;
		if (msgs == null || msgs.isEmpty()) {
			return false;
		}
		long offset = msgs.get(0).getQueueOffset();
		String maxOffset = msgs.get(0).getProperty(MessageConst.PROPERTY_MAX_OFFSET);
		if (!StringUtils.isEmpty(maxOffset)) {
			long diff = Long.parseLong(maxOffset) - offset;
			if (diff > 50000) { // 消息堆积了超过5W的情况特殊处理,直接返回消费成功并记录error日志
				flag = true;
				logger.error("promotion-webapp中MQ的broker消息堆积过多,超过阀值50000,系统自动过滤消费.");
			}
		}
		return flag;
	}

}
