package com.winter.model.manage.dimParkBasEnterprise;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @name DimParkBasEnterprise
 * @Description DimParkBasEnterprise实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DimParkBasEnterprise")
public class DimParkBasEnterprise extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * @name 编号
	 * @primarykey 主键,要求唯一
	 * @Length(max=32)
	 */
	private String id;
	/**
	 * @name 单位名称
	 * @Length(max=255)
	 */
	private String name;
	/**
	 * @name 企业简称
	 * @Length(max=255)
	 */
	private String abbreviation;
	/**
	 * @name logo
	 * @Length(max=255)
	 */
	private String logo;
	/**
	 * @name 标识码
	 * @Length(max=64)
	 */
	private String code;
	/**
	 * @name 组织机构代码
	 * @Length(max=64)
	 */
	private String orgCode;
	/**
	 * @name 机构类型
	 * @Length(max=64)
	 */
	private String orgType;
	/**
	 * @name 主要业务活动
	 * @Length(max=255)
	 */
	private String primaryService;
	/**
	 * @name 行业代码
	 * @Length(max=64)
	 */
	private String industryCode;
	/**
	 * @name 单位详细地址
	 * @Length(max=255)
	 */
	private String detailAddress;
	/**
	 * @name 单位注册地址
	 * @Length(max=255)
	 */
	private String registerAddress;
	/**
	 * @name 区划代码
	 * @Length(max=64)
	 */
	private String areaCode;
	/**
	 * @name 单位负责人
	 * @Length(max=64)
	 */
	private String principal;
	/**
	 * @name 开业时间
	 * 
	 */
	private Date openingTime;
	/**
	 * @name 入驻时间
	 * 
	 */
	private Date enterTime;
	/**
	 * @name 工商注册号
	 * @Length(max=64)
	 */
	private String registeredNo;
	/**
	 * @name 国税注册号
	 * @Length(max=64)
	 */
	private String nationalRegNo;
	/**
	 * @name 地税注册号
	 * @Length(max=64)
	 */
	private String landRegNo;
	/**
	 * @name 企业出资来源地
	 * @Length(max=255)
	 */
	private String source;
	/**
	 * @name 经营状态
	 * @Length(max=64)
	 */
	private String operateStatus;
	/**
	 * @name 固定电话
	 * @Length(max=32)
	 */
	private String tel;
	/**
	 * @name 移动电话
	 * @Length(max=32)
	 */
	private String phone;
	/**
	 * @name 图片
	 * @Length(max=65535)
	 */
	private String pic;
	/**
	 * @name 创建时间
	 * 
	 */
	private Date createTime;
	/**
	 * @name 修改时间
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
	public DimParkBasEnterprise(){
	
	}
	
	


/**
 * @name 设置 编号
 * @param id
 */
public void setId(String value) {
	this.id = value;
}

/**
 * @name 获得 编号
 * @return id
 */
public String getId() {
	return this.id;
}
/**
 * @name 设置 单位名称
 * @param name
 */
public void setName(String value) {
	this.name = value;
}

/**
 * @name 获得 单位名称
 * @return name
 */
public String getName() {
	return this.name;
}
/**
 * @name 设置 企业简称
 * @param abbreviation
 */
public void setAbbreviation(String value) {
	this.abbreviation = value;
}

/**
 * @name 获得 企业简称
 * @return abbreviation
 */
public String getAbbreviation() {
	return this.abbreviation;
}
/**
 * @name 设置 logo
 * @param logo
 */
public void setLogo(String value) {
	this.logo = value;
}

/**
 * @name 获得 logo
 * @return logo
 */
public String getLogo() {
	return this.logo;
}
/**
 * @name 设置 标识码
 * @param code
 */
public void setCode(String value) {
	this.code = value;
}

/**
 * @name 获得 标识码
 * @return code
 */
public String getCode() {
	return this.code;
}
/**
 * @name 设置 组织机构代码
 * @param orgCode
 */
public void setOrgCode(String value) {
	this.orgCode = value;
}

/**
 * @name 获得 组织机构代码
 * @return orgCode
 */
public String getOrgCode() {
	return this.orgCode;
}
/**
 * @name 设置 机构类型
 * @param orgType
 */
public void setOrgType(String value) {
	this.orgType = value;
}

/**
 * @name 获得 机构类型
 * @return orgType
 */
public String getOrgType() {
	return this.orgType;
}
/**
 * @name 设置 主要业务活动
 * @param primaryService
 */
public void setPrimaryService(String value) {
	this.primaryService = value;
}

/**
 * @name 获得 主要业务活动
 * @return primaryService
 */
public String getPrimaryService() {
	return this.primaryService;
}
/**
 * @name 设置 行业代码
 * @param industryCode
 */
public void setIndustryCode(String value) {
	this.industryCode = value;
}

/**
 * @name 获得 行业代码
 * @return industryCode
 */
public String getIndustryCode() {
	return this.industryCode;
}
/**
 * @name 设置 单位详细地址
 * @param detailAddress
 */
public void setDetailAddress(String value) {
	this.detailAddress = value;
}

/**
 * @name 获得 单位详细地址
 * @return detailAddress
 */
public String getDetailAddress() {
	return this.detailAddress;
}
/**
 * @name 设置 单位注册地址
 * @param registerAddress
 */
public void setRegisterAddress(String value) {
	this.registerAddress = value;
}

/**
 * @name 获得 单位注册地址
 * @return registerAddress
 */
public String getRegisterAddress() {
	return this.registerAddress;
}
/**
 * @name 设置 区划代码
 * @param areaCode
 */
public void setAreaCode(String value) {
	this.areaCode = value;
}

/**
 * @name 获得 区划代码
 * @return areaCode
 */
public String getAreaCode() {
	return this.areaCode;
}
/**
 * @name 设置 单位负责人
 * @param principal
 */
public void setPrincipal(String value) {
	this.principal = value;
}

/**
 * @name 获得 单位负责人
 * @return principal
 */
public String getPrincipal() {
	return this.principal;
}
/**
 * @name 设置 开业时间
 * @param openingTime
 */
public void setOpeningTime(Date value) {
	this.openingTime = value;
}

/**
 * @name 获得 开业时间
 * @return openingTime
 */
public Date getOpeningTime() {
	return this.openingTime;
}
/**
 * @name 设置 入驻时间
 * @param enterTime
 */
public void setEnterTime(Date value) {
	this.enterTime = value;
}

/**
 * @name 获得 入驻时间
 * @return enterTime
 */
public Date getEnterTime() {
	return this.enterTime;
}
/**
 * @name 设置 工商注册号
 * @param registeredNo
 */
public void setRegisteredNo(String value) {
	this.registeredNo = value;
}

/**
 * @name 获得 工商注册号
 * @return registeredNo
 */
public String getRegisteredNo() {
	return this.registeredNo;
}
/**
 * @name 设置 国税注册号
 * @param nationalRegNo
 */
public void setNationalRegNo(String value) {
	this.nationalRegNo = value;
}

/**
 * @name 获得 国税注册号
 * @return nationalRegNo
 */
public String getNationalRegNo() {
	return this.nationalRegNo;
}
/**
 * @name 设置 地税注册号
 * @param landRegNo
 */
public void setLandRegNo(String value) {
	this.landRegNo = value;
}

/**
 * @name 获得 地税注册号
 * @return landRegNo
 */
public String getLandRegNo() {
	return this.landRegNo;
}
/**
 * @name 设置 企业出资来源地
 * @param source
 */
public void setSource(String value) {
	this.source = value;
}

/**
 * @name 获得 企业出资来源地
 * @return source
 */
public String getSource() {
	return this.source;
}
/**
 * @name 设置 经营状态
 * @param operateStatus
 */
public void setOperateStatus(String value) {
	this.operateStatus = value;
}

/**
 * @name 获得 经营状态
 * @return operateStatus
 */
public String getOperateStatus() {
	return this.operateStatus;
}
/**
 * @name 设置 固定电话
 * @param tel
 */
public void setTel(String value) {
	this.tel = value;
}

/**
 * @name 获得 固定电话
 * @return tel
 */
public String getTel() {
	return this.tel;
}
/**
 * @name 设置 移动电话
 * @param phone
 */
public void setPhone(String value) {
	this.phone = value;
}

/**
 * @name 获得 移动电话
 * @return phone
 */
public String getPhone() {
	return this.phone;
}
/**
 * @name 设置 图片
 * @param pic
 */
public void setPic(String value) {
	this.pic = value;
}

/**
 * @name 获得 图片
 * @return pic
 */
public String getPic() {
	return this.pic;
}
/**
 * @name 设置 创建时间
 * @param createTime
 */
public void setCreateTime(Date value) {
	this.createTime = value;
}

/**
 * @name 获得 创建时间
 * @return createTime
 */
public Date getCreateTime() {
	return this.createTime;
}
/**
 * @name 设置 修改时间
 * @param updateTime
 */
public void setUpdateTime(Date value) {
	this.updateTime = value;
}

/**
 * @name 获得 修改时间
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

