package com.winter.model.manage.dimTourDevcEntranceGuard;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @name DimTourDevcEntranceGuard
 * @Description DimTourDevcEntranceGuard实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DimTourDevcEntranceGuard")
public class DimTourDevcEntranceGuard extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * @name 主键，门禁设备唯一标识acsDevIndexCode
	 * @primarykey 主键,要求唯一
	 * @Length(max=64)
	 */
	private String id;
	/**
	 * @name 二维资源id
	 * @Length(max=32)
	 */
	private String resourceId;
	/**
	 * @name 三维资源id
	 * @Length(max=32)
	 */
	private String resourceId3d;
	/**
	 * @name 门禁设备名称acsDevName
	 * @NotBlank @Length(max=32)
	 */
	private String name;
	/**
	 * @name 门禁设备类型描述
	 * @Length(max=32)
	 */
	private String typeDesc;
	/**
	 * @name 门禁设备类型编号
	 * @Length(max=32)
	 */
	private String typeCode;
	/**
	 * @name 门禁设备类型名称
	 * @Length(max=32)
	 */
	private String typeName;
	/**
	 * @name 门禁设备IP
	 * @Length(max=255)
	 */
	private String ip;
	/**
	 * @name 门禁设备port
	 * @Length(max=16)
	 */
	private String port;
	/**
	 * @name 门禁设备编号
	 * @Length(max=64)
	 */
	private String code;
	/**
	 * @name 设备所属区域唯一标识
	 * @Length(max=64)
	 */
	private String regionIndexCode;
	/**
	 * @name 接入协议
	 * @Length(max=64)
	 */
	private String treatyType;
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
	public DimTourDevcEntranceGuard(){
	
	}
/**
 * @name 设置 主键，门禁设备唯一标识acsDevIndexCode
 * @param id
 */
public void setId(String value) {
	this.id = value;
}

/**
 * @name 获得 主键，门禁设备唯一标识acsDevIndexCode
 * @return id
 */
public String getId() {
	return this.id;
}
/**
 * @name 设置 二维资源id
 * @param resourceId
 */
public void setResourceId(String value) {
	this.resourceId = value;
}

/**
 * @name 获得 二维资源id
 * @return resourceId
 */
public String getResourceId() {
	return this.resourceId;
}
/**
 * @name 设置 三维资源id
 * @param resourceId3d
 */
public void setResourceId3d(String value) {
	this.resourceId3d = value;
}

/**
 * @name 获得 三维资源id
 * @return resourceId3d
 */
public String getResourceId3d() {
	return this.resourceId3d;
}
/**
 * @name 设置 门禁设备名称acsDevName
 * @param name
 */
public void setName(String value) {
	this.name = value;
}

/**
 * @name 获得 门禁设备名称acsDevName
 * @return name
 */
public String getName() {
	return this.name;
}
/**
 * @name 设置 门禁设备类型描述
 * @param typeDesc
 */
public void setTypeDesc(String value) {
	this.typeDesc = value;
}

/**
 * @name 获得 门禁设备类型描述
 * @return typeDesc
 */
public String getTypeDesc() {
	return this.typeDesc;
}
/**
 * @name 设置 门禁设备类型编号
 * @param typeCode
 */
public void setTypeCode(String value) {
	this.typeCode = value;
}

/**
 * @name 获得 门禁设备类型编号
 * @return typeCode
 */
public String getTypeCode() {
	return this.typeCode;
}
/**
 * @name 设置 门禁设备类型名称
 * @param typeName
 */
public void setTypeName(String value) {
	this.typeName = value;
}

/**
 * @name 获得 门禁设备类型名称
 * @return typeName
 */
public String getTypeName() {
	return this.typeName;
}
/**
 * @name 设置 门禁设备IP
 * @param ip
 */
public void setIp(String value) {
	this.ip = value;
}

/**
 * @name 获得 门禁设备IP
 * @return ip
 */
public String getIp() {
	return this.ip;
}
/**
 * @name 设置 门禁设备port
 * @param port
 */
public void setPort(String value) {
	this.port = value;
}

/**
 * @name 获得 门禁设备port
 * @return port
 */
public String getPort() {
	return this.port;
}
/**
 * @name 设置 门禁设备编号
 * @param code
 */
public void setCode(String value) {
	this.code = value;
}

/**
 * @name 获得 门禁设备编号
 * @return code
 */
public String getCode() {
	return this.code;
}
/**
 * @name 设置 设备所属区域唯一标识
 * @param regionIndexCode
 */
public void setRegionIndexCode(String value) {
	this.regionIndexCode = value;
}

/**
 * @name 获得 设备所属区域唯一标识
 * @return regionIndexCode
 */
public String getRegionIndexCode() {
	return this.regionIndexCode;
}
/**
 * @name 设置 接入协议
 * @param treatyType
 */
public void setTreatyType(String value) {
	this.treatyType = value;
}

/**
 * @name 获得 接入协议
 * @return treatyType
 */
public String getTreatyType() {
	return this.treatyType;
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

