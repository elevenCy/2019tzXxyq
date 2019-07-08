package com.winter.model.manage.dimTourDevcSensor;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @name DimTourDevcSensor
 * @Description DimTourDevcSensor实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DimTourDevcSensor")
public class DimTourDevcSensor extends BaseEntity {

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
	 * @name 设备ID
	 * @NotBlank @Length(max=64)
	 */
	private String deviceId;
	/**
	 * @name 设备序列号
	 * @NotBlank @Length(max=64)
	 */
	private String deviceNo;
	/**
	 * @name 设备名称
	 * @NotBlank @Length(max=64)
	 */
	private String deviceName;
	/**
	 * @name 设备纬度
	 * @NotBlank @Length(max=64)
	 */
	private String deviceLat;
	/**
	 * @name 设备经度
	 * @NotBlank @Length(max=64)
	 */
	private String deviceLng;
	/**
	 * @name 掉线延迟时间
	 * @NotBlank @Length(max=64)
	 */
	private String faultDelay;
	/**
	 * @name 设备图标
	 * @NotBlank @Length(max=64)
	 */
	private String deviceIco;
	/**
	 * @name 记录间隔时间
	 * @NotBlank @Length(max=64)
	 */
	private String defaultTimescale;
	/**
	 * @name 创建时间在他们平台
	 * @NotBlank @Length(max=64)
	 */
	private String createDateTime;
	/**
	 * @name 传感器id
	 * @Length(max=64)
	 */
	private String sensorId;
	/**
	 * @name 传感器名称
	 * @Length(max=64)
	 */
	private String sensorName;
	/**
	 * @name 传感器id（1数值型;2开关型(可操作);3定位型;5开关型(不可操作);6挡位型）;7视频型;8字符串
	 * @Length(max=64)
	 */
	private String sensorType;
	/**
	 * @name 传感器图标地址
	 * @NotBlank @Length(max=64)
	 */
	private String iocUrl;
	/**
	 * @name 1在线0离线；isline
	 * @NotNull 
	 */
	private Integer status;
	/**
	 * @name 设备纬度
	 * @NotBlank @Length(max=64)
	 */
	private String lat;
	/**
	 * @name 设备经度
	 * @NotBlank @Length(max=64)
	 */
	private String lng;
	/**
	 * @name 挡位
	 * @NotBlank @Length(max=64)
	 */
	private String switcher;
	/**
	 * @name 最新数值
	 * @NotBlank @Length(max=64)
	 */
	private String value;
	/**
	 * @name 单位
	 * @NotBlank @Length(max=64)
	 */
	private String unit;
	/**
	 * @name 最后更新时间
	 * @NotBlank @Length(max=64)
	 */
	private String updateDateTime;
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
	public DimTourDevcSensor(){
	
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
 * @name 设置 设备序列号
 * @param deviceNo
 */
public void setDeviceNo(String value) {
	this.deviceNo = value;
}

/**
 * @name 获得 设备序列号
 * @return deviceNo
 */
public String getDeviceNo() {
	return this.deviceNo;
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
 * @name 设置 设备纬度
 * @param deviceLat
 */
public void setDeviceLat(String value) {
	this.deviceLat = value;
}

/**
 * @name 获得 设备纬度
 * @return deviceLat
 */
public String getDeviceLat() {
	return this.deviceLat;
}
/**
 * @name 设置 设备经度
 * @param deviceLng
 */
public void setDeviceLng(String value) {
	this.deviceLng = value;
}

/**
 * @name 获得 设备经度
 * @return deviceLng
 */
public String getDeviceLng() {
	return this.deviceLng;
}
/**
 * @name 设置 掉线延迟时间
 * @param faultDelay
 */
public void setFaultDelay(String value) {
	this.faultDelay = value;
}

/**
 * @name 获得 掉线延迟时间
 * @return faultDelay
 */
public String getFaultDelay() {
	return this.faultDelay;
}
/**
 * @name 设置 设备图标
 * @param deviceIco
 */
public void setDeviceIco(String value) {
	this.deviceIco = value;
}

/**
 * @name 获得 设备图标
 * @return deviceIco
 */
public String getDeviceIco() {
	return this.deviceIco;
}
/**
 * @name 设置 记录间隔时间
 * @param defaultTimescale
 */
public void setDefaultTimescale(String value) {
	this.defaultTimescale = value;
}

/**
 * @name 获得 记录间隔时间
 * @return defaultTimescale
 */
public String getDefaultTimescale() {
	return this.defaultTimescale;
}
/**
 * @name 设置 创建时间在他们平台
 * @param createDateTime
 */
public void setCreateDateTime(String value) {
	this.createDateTime = value;
}

/**
 * @name 获得 创建时间在他们平台
 * @return createDateTime
 */
public String getCreateDateTime() {
	return this.createDateTime;
}
/**
 * @name 设置 传感器id
 * @param sensorId
 */
public void setSensorId(String value) {
	this.sensorId = value;
}

/**
 * @name 获得 传感器id
 * @return sensorId
 */
public String getSensorId() {
	return this.sensorId;
}
/**
 * @name 设置 传感器名称
 * @param sensorName
 */
public void setSensorName(String value) {
	this.sensorName = value;
}

/**
 * @name 获得 传感器名称
 * @return sensorName
 */
public String getSensorName() {
	return this.sensorName;
}
/**
 * @name 设置 传感器id（1数值型;2开关型(可操作);3定位型;5开关型(不可操作);6挡位型）;7视频型;8字符串
 * @param sensorType
 */
public void setSensorType(String value) {
	this.sensorType = value;
}

/**
 * @name 获得 传感器id（1数值型;2开关型(可操作);3定位型;5开关型(不可操作);6挡位型）;7视频型;8字符串
 * @return sensorType
 */
public String getSensorType() {
	return this.sensorType;
}
/**
 * @name 设置 传感器图标地址
 * @param iocUrl
 */
public void setIocUrl(String value) {
	this.iocUrl = value;
}

/**
 * @name 获得 传感器图标地址
 * @return iocUrl
 */
public String getIocUrl() {
	return this.iocUrl;
}
/**
 * @name 设置 1在线0离线；isline
 * @param status
 */
public void setStatus(Integer value) {
	this.status = value;
}

/**
 * @name 获得 1在线0离线；isline
 * @return status
 */
public Integer getStatus() {
	return this.status;
}
/**
 * @name 设置 设备纬度
 * @param lat
 */
public void setLat(String value) {
	this.lat = value;
}

/**
 * @name 获得 设备纬度
 * @return lat
 */
public String getLat() {
	return this.lat;
}
/**
 * @name 设置 设备经度
 * @param lng
 */
public void setLng(String value) {
	this.lng = value;
}

/**
 * @name 获得 设备经度
 * @return lng
 */
public String getLng() {
	return this.lng;
}
/**
 * @name 设置 挡位
 * @param switcher
 */
public void setSwitcher(String value) {
	this.switcher = value;
}

/**
 * @name 获得 挡位
 * @return switcher
 */
public String getSwitcher() {
	return this.switcher;
}
/**
 * @name 设置 最新数值
 * @param value
 */
public void setValue(String value) {
	this.value = value;
}

/**
 * @name 获得 最新数值
 * @return value
 */
public String getValue() {
	return this.value;
}
/**
 * @name 设置 单位
 * @param unit
 */
public void setUnit(String value) {
	this.unit = value;
}

/**
 * @name 获得 单位
 * @return unit
 */
public String getUnit() {
	return this.unit;
}
/**
 * @name 设置 最后更新时间
 * @param updateDateTime
 */
public void setUpdateDateTime(String value) {
	this.updateDateTime = value;
}

/**
 * @name 获得 最后更新时间
 * @return updateDateTime
 */
public String getUpdateDateTime() {
	return this.updateDateTime;
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

