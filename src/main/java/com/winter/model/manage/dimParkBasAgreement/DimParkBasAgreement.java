package com.winter.model.manage.dimParkBasAgreement;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @name DimParkBasAgreement
 * @Description DimParkBasAgreement实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DimParkBasAgreement")
public class DimParkBasAgreement extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * @name 协议id
	 * @primarykey 主键,要求唯一
	 * @Length(max=32)
	 */
	private String id;
	/**
	 * @name 企业id
	 * @Length(max=32)
	 */
	private String enterpriseId;
	/**
	 * @name 租金单价（平均）/平米
	 * 
	 */
	private BigDecimal rentPrice;
	/**
	 * @name 租金-年
	 * 
	 */
	private BigDecimal rentY;
	/**
	 * @name 物业单价（平均）/平米
	 * 
	 */
	private BigDecimal propertyPrice;
	/**
	 * @name 物业-年
	 * 
	 */
	private BigDecimal propertyY;
	/**
	 * @name 所占总面积
	 * 
	 */
	private BigDecimal area;
	/**
	 * @name 协议开始时间
	 * 
	 */
	private Date startDate;
	/**
	 * @name 协议到期时间
	 * 
	 */
	private Date endDate;
	/**
	 * @name 交款方式 0年交 1半年交 2季交 3月交
	 * 
	 */
	private Integer payment;
	/**
	 * @name 首次缴款截至时间可推算二次三次..
	 * 
	 */
	private Date payEndtime;
	/**
	 * @name 状态 0 正常 1已到期  2已清退 
	 * 
	 */
	private Integer status;
	/**
	 * @name 备注
	 * @Length(max=255)
	 */
	private String remark;
	/**
	 * @name createTime
	 * 
	 */
	private Date createTime;
	/**
	 * @name updateTime
	 * 
	 */
	private Date updateTime;

	/**
	 * @name 查询关键字
	 */
	private String keyWord;

    /**
     * @name 无参构造函数
     */
	public DimParkBasAgreement(){
	
	}
	
	


/**
 * @name 设置 协议id
 * @param id
 */
public void setId(String value) {
	this.id = value;
}

/**
 * @name 获得 协议id
 * @return id
 */
public String getId() {
	return this.id;
}
/**
 * @name 设置 企业id
 * @param enterpriseId
 */
public void setEnterpriseId(String value) {
	this.enterpriseId = value;
}

/**
 * @name 获得 企业id
 * @return enterpriseId
 */
public String getEnterpriseId() {
	return this.enterpriseId;
}
/**
 * @name 设置 租金单价（平均）/平米
 * @param rentPrice
 */
public void setRentPrice(BigDecimal value) {
	this.rentPrice = value;
}

/**
 * @name 获得 租金单价（平均）/平米
 * @return rentPrice
 */
public BigDecimal getRentPrice() {
	return this.rentPrice;
}
/**
 * @name 设置 租金-年
 * @param rentY
 */
public void setRentY(BigDecimal value) {
	this.rentY = value;
}

/**
 * @name 获得 租金-年
 * @return rentY
 */
public BigDecimal getRentY() {
	return this.rentY;
}
/**
 * @name 设置 物业单价（平均）/平米
 * @param propertyPrice
 */
public void setPropertyPrice(BigDecimal value) {
	this.propertyPrice = value;
}

/**
 * @name 获得 物业单价（平均）/平米
 * @return propertyPrice
 */
public BigDecimal getPropertyPrice() {
	return this.propertyPrice;
}
/**
 * @name 设置 物业-年
 * @param propertyY
 */
public void setPropertyY(BigDecimal value) {
	this.propertyY = value;
}

/**
 * @name 获得 物业-年
 * @return propertyY
 */
public BigDecimal getPropertyY() {
	return this.propertyY;
}
/**
 * @name 设置 所占总面积
 * @param area
 */
public void setArea(BigDecimal value) {
	this.area = value;
}

/**
 * @name 获得 所占总面积
 * @return area
 */
public BigDecimal getArea() {
	return this.area;
}
/**
 * @name 设置 协议开始时间
 * @param startDate
 */
public void setStartDate(Date value) {
	this.startDate = value;
}

/**
 * @name 获得 协议开始时间
 * @return startDate
 */
public Date getStartDate() {
	return this.startDate;
}
/**
 * @name 设置 协议到期时间
 * @param endDate
 */
public void setEndDate(Date value) {
	this.endDate = value;
}

/**
 * @name 获得 协议到期时间
 * @return endDate
 */
public Date getEndDate() {
	return this.endDate;
}
/**
 * @name 设置 交款方式 0年交 1半年交 2季交 3月交
 * @param payment
 */
public void setPayment(Integer value) {
	this.payment = value;
}

/**
 * @name 获得 交款方式 0年交 1半年交 2季交 3月交
 * @return payment
 */
public Integer getPayment() {
	return this.payment;
}
/**
 * @name 设置 首次缴款截至时间可推算二次三次..
 * @param payEndtime
 */
public void setPayEndtime(Date value) {
	this.payEndtime = value;
}

/**
 * @name 获得 首次缴款截至时间可推算二次三次..
 * @return payEndtime
 */
public Date getPayEndtime() {
	return this.payEndtime;
}
/**
 * @name 设置 状态 0 正常 1已到期  2已清退 
 * @param status
 */
public void setStatus(Integer value) {
	this.status = value;
}

/**
 * @name 获得 状态 0 正常 1已到期  2已清退 
 * @return status
 */
public Integer getStatus() {
	return this.status;
}
/**
 * @name 设置 备注
 * @param remark
 */
public void setRemark(String value) {
	this.remark = value;
}

/**
 * @name 获得 备注
 * @return remark
 */
public String getRemark() {
	return this.remark;
}
/**
 * @name 设置 createTime
 * @param createTime
 */
public void setCreateTime(Date value) {
	this.createTime = value;
}

/**
 * @name 获得 createTime
 * @return createTime
 */
public Date getCreateTime() {
	return this.createTime;
}
/**
 * @name 设置 updateTime
 * @param updateTime
 */
public void setUpdateTime(Date value) {
	this.updateTime = value;
}

/**
 * @name 获得 updateTime
 * @return updateTime
 */
public Date getUpdateTime() {
	return this.updateTime;
}

	/**
	 * @name 设置 keyWord
	 * @param keyWord
	 */
	public String getKeyWord() {
		return keyWord;
	}

	/**
	 * @name 获得 keyWord
	 * @return keyWord
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

}

