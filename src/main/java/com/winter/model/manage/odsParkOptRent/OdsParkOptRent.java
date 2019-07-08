package com.winter.model.manage.odsParkOptRent;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @name OdsParkOptRent
 * @Description OdsParkOptRent实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("OdsParkOptRent")
public class OdsParkOptRent extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * @name areaId
	 * @Length(max=32)
	 */
	private String areaId;
	/**
	 * @name monthReceivedMoney
	 * 
	 */
	private BigDecimal monthReceivedMoney;
	/**
	 * @name monthUnReceiveMoney
	 * 
	 */
	private BigDecimal monthUnReceiveMoney;
	/**
	 * @name yearReceiveMoney
	 * 
	 */
	private BigDecimal yearReceiveMoney;
	/**
	 * @name createDate
	 * 
	 */
	private Date createDate;

	/**
	 * @name 查询关键字
	 */
	private String keyWord;

    /**
     * @name 无参构造函数
     */
	public OdsParkOptRent(){
	
	}
	
	


/**
 * @name 设置 areaId
 * @param areaId
 */
public void setAreaId(String value) {
	this.areaId = value;
}

/**
 * @name 获得 areaId
 * @return areaId
 */
public String getAreaId() {
	return this.areaId;
}
/**
 * @name 设置 monthReceivedMoney
 * @param monthReceivedMoney
 */
public void setMonthReceivedMoney(BigDecimal value) {
	this.monthReceivedMoney = value;
}

/**
 * @name 获得 monthReceivedMoney
 * @return monthReceivedMoney
 */
public BigDecimal getMonthReceivedMoney() {
	return this.monthReceivedMoney;
}
/**
 * @name 设置 monthUnReceiveMoney
 * @param monthUnReceiveMoney
 */
public void setMonthUnReceiveMoney(BigDecimal value) {
	this.monthUnReceiveMoney = value;
}

/**
 * @name 获得 monthUnReceiveMoney
 * @return monthUnReceiveMoney
 */
public BigDecimal getMonthUnReceiveMoney() {
	return this.monthUnReceiveMoney;
}
/**
 * @name 设置 yearReceiveMoney
 * @param yearReceiveMoney
 */
public void setYearReceiveMoney(BigDecimal value) {
	this.yearReceiveMoney = value;
}

/**
 * @name 获得 yearReceiveMoney
 * @return yearReceiveMoney
 */
public BigDecimal getYearReceiveMoney() {
	return this.yearReceiveMoney;
}
/**
 * @name 设置 createDate
 * @param createDate
 */
public void setCreateDate(Date value) {
	this.createDate = value;
}

/**
 * @name 获得 createDate
 * @return createDate
 */
public Date getCreateDate() {
	return this.createDate;
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

