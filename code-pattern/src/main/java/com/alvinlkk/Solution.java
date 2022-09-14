/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/8/30
 * @since 1.0
 **/
public class Solution {

    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            nums[2 * i] |= (nums[i] & 1023) << 10;
            nums[2 * i + 1] |= (nums[i + n] & 1023) << 10;
        }
        // 高10位右移
        for (int i = 0; i < 2 * n; i++) {
            nums[i] >>= 10;
        }
        return nums;
    }
}
