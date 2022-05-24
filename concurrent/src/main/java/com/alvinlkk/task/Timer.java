/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk.task;

import java.util.concurrent.TimeUnit;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/5/24
 * @since 1.0
 **/
public interface Timer {

    void createTimerTask(TimerTask task, long delay, TimeUnit unit);
}
