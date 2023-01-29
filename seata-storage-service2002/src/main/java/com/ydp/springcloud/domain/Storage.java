package com.ydp.springcloud.domain;

import lombok.Data;

/**
 * @author YDP
 * @version 1.0
 * @date 2023/1/29 22:49
 */
@Data
public class Storage {


    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;

}
