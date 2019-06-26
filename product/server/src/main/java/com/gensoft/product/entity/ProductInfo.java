package com.gensoft.product.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 19:51 2019/6/5
 */
@Data
@Entity
//@Table(name = "")
public class ProductInfo {
	@Id
	private String productId;

	/** 名字. */
	private String productName;

	/** 单价. */
	private BigDecimal productPrice;

	/** 库存. */
	private Integer productStock;

	/** 描述. */
	private String productDescription;

	/** 小图. */
	private String productIcon;

	/** 状态, 0正常1下架. */
	private Integer productStatus;

	/** 类目编号. */
	private Integer categoryType;

	private Date createTime;

	private Date updateTime;
}
