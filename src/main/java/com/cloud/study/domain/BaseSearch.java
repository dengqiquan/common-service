package com.cloud.study.domain;

import com.cloud.study.enums.DataStatusEnum;
import lombok.Data;

/**
 * @description:
 * @author: dqq
 * @date: 2020/9/29 8:34
 */
@Data
public class BaseSearch {
    /**
     * 页数
     */
    private Integer pageNum;

    /**
     * 每页大小
     */
    private Integer pageSize;
    /**
     * 排序字段
     */
    private String orderByClause;

    /**
     * 数据状态
     */
    private String dataStatus = DataStatusEnum.NORMAL.getCode();
}
