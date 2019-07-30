package com.winter.model.manage.dimTourDevcSmokeDetector;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @name DimTourDevcSmokeDetector
 * @Description DimTourDevcSmokeDetector实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DimTourDevcSmokeDetector")
public class DimTourDevcSmokeDetector extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * @name id
	 * @primarykey 主键,要求唯一
	 * @Length(max=32)
	 */
	private String id;
	/**
	 * @name resourceId
	 * @Length(max=32)
	 */
	private String resourceId;
	/**
	 * @name resourceId3d
	 * @Length(max=32)
	 */
	private String resourceId3d;
	/**
	 * @name rzProtectionDataId
	 * @NotBlank @Length(max=32)
	 */
	private String rzProtectionDataId;
	/**
	 * @name name
	 * @NotBlank @Length(max=64)
	 */
	private String name;
	/**
	 * @name code
	 * @Length(max=64)
	 */
	private String code;
	/**
	 * @name ip
	 * @Length(max=255)
	 */
	private String ip;
	/**
	 * @name port
	 * @Length(max=16)
	 */
	private String port;
	/**
	 * @name address
	 * @Length(max=255)
	 */
	private String address;
	/**
	 * @name status
	 * @NotNull 
	 */
	private Integer status;
	/**
	 * @name remark
	 * @Length(max=255)
	 */
	private String remark;
	/**
	 * @name sort
	 * @NotNull 
	 */
	private Integer sort;
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
	public DimTourDevcSmokeDetector(){
	
	}
	
	


/**
 * @name 设置 id
 * @param id
 */
public void setId(String value) {
	this.id = value;
}

/**
 * @name 获得 id
 * @return id
 */
public String getId() {
	return this.id;
}
/**
 * @name 设置 resourceId
 * @param resourceId
 */
public void setResourceId(String value) {
	this.resourceId = value;
}

/**
 * @name 获得 resourceId
 * @return resourceId
 */
public String getResourceId() {
	return this.resourceId;
}
/**
 * @name 设置 resourceId3d
 * @param resourceId3d
 */
public void setResourceId3d(String value) {
	this.resourceId3d = value;
}

/**
 * @name 获得 resourceId3d
 * @return resourceId3d
 */
public String getResourceId3d() {
	return this.resourceId3d;
}
/**
 * @name 设置 rzProtectionDataId
 * @param rzProtectionDataId
 */
public void setRzProtectionDataId(String value) {
	this.rzProtectionDataId = value;
}

/**
 * @name 获得 rzProtectionDataId
 * @return rzProtectionDataId
 */
public String getRzProtectionDataId() {
	return this.rzProtectionDataId;
}
/**
 * @name 设置 name
 * @param name
 */
public void setName(String value) {
	this.name = value;
}

/**
 * @name 获得 name
 * @return name
 */
public String getName() {
	return this.name;
}
/**
 * @name 设置 code
 * @param code
 */
public void setCode(String value) {
	this.code = value;
}

/**
 * @name 获得 code
 * @return code
 */
public String getCode() {
	return this.code;
}
/**
 * @name 设置 ip
 * @param ip
 */
public void setIp(String value) {
	this.ip = value;
}

/**
 * @name 获得 ip
 * @return ip
 */
public String getIp() {
	return this.ip;
}
/**
 * @name 设置 port
 * @param port
 */
public void setPort(String value) {
	this.port = value;
}

/**
 * @name 获得 port
 * @return port
 */
public String getPort() {
	return this.port;
}
/**
 * @name 设置 address
 * @param address
 */
public void setAddress(String value) {
	this.address = value;
}

/**
 * @name 获得 address
 * @return address
 */
public String getAddress() {
	return this.address;
}
/**
 * @name 设置 status
 * @param status
 */
public void setStatus(Integer value) {
	this.status = value;
}

/**
 * @name 获得 status
 * @return status
 */
public Integer getStatus() {
	return this.status;
}
/**
 * @name 设置 remark
 * @param remark
 */
public void setRemark(String value) {
	this.remark = value;
}

/**
 * @name 获得 remark
 * @return remark
 */
public String getRemark() {
	return this.remark;
}
/**
 * @name 设置 sort
 * @param sort
 */
public void setSort(Integer value) {
	this.sort = value;
}

/**
 * @name 获得 sort
 * @return sort
 */
public Integer getSort() {
	return this.sort;
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

