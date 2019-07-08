package com.winter.model.manage.dimTourDevcWaterMeter;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @name DimTourDevcWaterMeter
 * @Description DimTourDevcWaterMeter实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DimTourDevcWaterMeter")
public class DimTourDevcWaterMeter extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * @name 数据库内的唯一主键
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
	 * @name 测点ID
	 * @NotBlank @Length(max=64)
	 */
	private String measId;
	/**
	 * @name 测点名称
	 * @NotBlank @Length(max=64)
	 */
	private String measName;
	/**
	 * @name 设备ID
	 * @NotBlank @Length(max=64)
	 */
	private String deviceId;
	/**
	 * @name 设备名称
	 * @NotBlank @Length(max=64)
	 */
	private String deviceName;
	/**
	 * @name 通道
	 * @NotBlank @Length(max=64)
	 */
	private String channelName;
	/**
	 * @name 测点对应的dataId用于查看记录数据和间隔数据
	 * @Length(max=64)
	 */
	private String dataId;
	/**
	 * @name 数值
	 * @NotBlank @Length(max=64)
	 */
	private String value;
	/**
	 * @name 开关量数值，大于1000，0000的是开关量
	 * @NotBlank @Length(max=64)
	 */
	private String switchValue;
	/**
	 * @name 状态位能获取到数据即是在线，否则离线
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
	 * 
	 */
	private Integer sort;
	/**
	 * @name createTime
	 * 
	 */
	private Date createTime;
	/**
	 * @name 更新时间即数据时间
	 * @NotNull 
	 */
	private Date updateTime;

	/**
	 * @name 查询关键字
	 */
	private String keyWord;

    /**
     * @name 无参构造函数
     */
	public DimTourDevcWaterMeter(){
	
	}
	
	


/**
 * @name 设置 数据库内的唯一主键
 * @param id
 */
public void setId(String value) {
	this.id = value;
}

/**
 * @name 获得 数据库内的唯一主键
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
 * @name 设置 测点ID
 * @param measId
 */
public void setMeasId(String value) {
	this.measId = value;
}

/**
 * @name 获得 测点ID
 * @return measId
 */
public String getMeasId() {
	return this.measId;
}
/**
 * @name 设置 测点名称
 * @param measName
 */
public void setMeasName(String value) {
	this.measName = value;
}

/**
 * @name 获得 测点名称
 * @return measName
 */
public String getMeasName() {
	return this.measName;
}
/**
 * @name 设置 设备ID
 * @param deviceId
 */
public void setDeviceId(String value) {
	this.deviceId = value;
}

/**
 * @name 获得 设备ID
 * @return deviceId
 */
public String getDeviceId() {
	return this.deviceId;
}
/**
 * @name 设置 设备名称
 * @param deviceName
 */
public void setDeviceName(String value) {
	this.deviceName = value;
}

/**
 * @name 获得 设备名称
 * @return deviceName
 */
public String getDeviceName() {
	return this.deviceName;
}
/**
 * @name 设置 通道
 * @param channelName
 */
public void setChannelName(String value) {
	this.channelName = value;
}

/**
 * @name 获得 通道
 * @return channelName
 */
public String getChannelName() {
	return this.channelName;
}
/**
 * @name 设置 测点对应的dataId用于查看记录数据和间隔数据
 * @param dataId
 */
public void setDataId(String value) {
	this.dataId = value;
}

/**
 * @name 获得 测点对应的dataId用于查看记录数据和间隔数据
 * @return dataId
 */
public String getDataId() {
	return this.dataId;
}
/**
 * @name 设置 数值
 * @param value
 */
public void setValue(String value) {
	this.value = value;
}

/**
 * @name 获得 数值
 * @return value
 */
public String getValue() {
	return this.value;
}
/**
 * @name 设置 开关量数值，大于1000，0000的是开关量
 * @param switchValue
 */
public void setSwitchValue(String value) {
	this.switchValue = value;
}

/**
 * @name 获得 开关量数值，大于1000，0000的是开关量
 * @return switchValue
 */
public String getSwitchValue() {
	return this.switchValue;
}
/**
 * @name 设置 状态位能获取到数据即是在线，否则离线
 * @param status
 */
public void setStatus(Integer value) {
	this.status = value;
}

/**
 * @name 获得 状态位能获取到数据即是在线，否则离线
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
 * @name 设置 更新时间即数据时间
 * @param updateTime
 */
public void setUpdateTime(Date value) {
	this.updateTime = value;
}

/**
 * @name 获得 更新时间即数据时间
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

