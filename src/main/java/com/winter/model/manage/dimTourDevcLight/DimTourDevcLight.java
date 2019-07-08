package com.winter.model.manage.dimTourDevcLight;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @name DimTourDevcLight
 * @Description DimTourDevcLight实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DimTourDevcLight")
public class DimTourDevcLight extends BaseEntity {

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
	 * @name name
	 * @NotBlank @Length(max=64)
	 */
	private String name;
	/**
	 * @name 设备id
	 * @Length(max=64)
	 */
	private String eqid;
	/**
	 * @name 设备 DTU 号码
	 * @Length(max=64)
	 */
	private String eqno;
	/**
	 * @name 用户编号
	 * @Length(max=64)
	 */
	private String eqcode;
	/**
	 * @name type
	 * @Length(max=16)
	 */
	private String type;
	/**
	 * @name addr
	 * @Length(max=255)
	 */
	private String addr;
	/**
	 * @name status
	 * @NotNull 
	 */
	private Integer status;
	/**
	 * @name group
	 * @Length(max=255)
	 */
	private String group;
	/**
	 * @name lon
	 * @Length(max=32)
	 */
	private String lon;
	/**
	 * @name lat
	 * @Length(max=32)
	 */
	private String lat;
	/**
	 * @name hlStatus
	 * @Length(max=16)
	 */
	private String hlStatus;
	/**
	 * @name remark
	 * @Length(max=255)
	 */
	private String remark;
	/**
	 * @name 单灯一般不需要用到所以不解析用text存储即可
	 * @Length(max=65535)
	 */
	private String lights;
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
	public DimTourDevcLight(){
	
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
 * @name 设置 设备id
 * @param eqid
 */
public void setEqid(String value) {
	this.eqid = value;
}

/**
 * @name 获得 设备id
 * @return eqid
 */
public String getEqid() {
	return this.eqid;
}
/**
 * @name 设置 设备 DTU 号码
 * @param eqno
 */
public void setEqno(String value) {
	this.eqno = value;
}

/**
 * @name 获得 设备 DTU 号码
 * @return eqno
 */
public String getEqno() {
	return this.eqno;
}
/**
 * @name 设置 用户编号
 * @param eqcode
 */
public void setEqcode(String value) {
	this.eqcode = value;
}

/**
 * @name 获得 用户编号
 * @return eqcode
 */
public String getEqcode() {
	return this.eqcode;
}
/**
 * @name 设置 type
 * @param type
 */
public void setType(String value) {
	this.type = value;
}

/**
 * @name 获得 type
 * @return type
 */
public String getType() {
	return this.type;
}
/**
 * @name 设置 addr
 * @param addr
 */
public void setAddr(String value) {
	this.addr = value;
}

/**
 * @name 获得 addr
 * @return addr
 */
public String getAddr() {
	return this.addr;
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
 * @name 设置 group
 * @param group
 */
public void setGroup(String value) {
	this.group = value;
}

/**
 * @name 获得 group
 * @return group
 */
public String getGroup() {
	return this.group;
}
/**
 * @name 设置 lon
 * @param lon
 */
public void setLon(String value) {
	this.lon = value;
}

/**
 * @name 获得 lon
 * @return lon
 */
public String getLon() {
	return this.lon;
}
/**
 * @name 设置 lat
 * @param lat
 */
public void setLat(String value) {
	this.lat = value;
}

/**
 * @name 获得 lat
 * @return lat
 */
public String getLat() {
	return this.lat;
}
/**
 * @name 设置 hlStatus
 * @param hlStatus
 */
public void setHlStatus(String value) {
	this.hlStatus = value;
}

/**
 * @name 获得 hlStatus
 * @return hlStatus
 */
public String getHlStatus() {
	return this.hlStatus;
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
 * @name 设置 单灯一般不需要用到所以不解析用text存储即可
 * @param lights
 */
public void setLights(String value) {
	this.lights = value;
}

/**
 * @name 获得 单灯一般不需要用到所以不解析用text存储即可
 * @return lights
 */
public String getLights() {
	return this.lights;
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

