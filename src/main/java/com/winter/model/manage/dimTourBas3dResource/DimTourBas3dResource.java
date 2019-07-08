package com.winter.model.manage.dimTourBas3dResource;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @name DimTourBas3dResource
 * @Description DimTourBas3dResource实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DimTourBas3dResource")
public class DimTourBas3dResource extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * @name id
	 * @primarykey 主键,要求唯一
	 * @Length(max=32)
	 */
	private String id;
	/**
	 * @name name
	 * @NotBlank @Length(max=64)
	 */
	private String name;
	/**
	 * @name areaId
	 * @NotBlank @Length(max=32)
	 */
	private String areaId;
	/**
	 * @name typeId
	 * @NotBlank @Length(max=32)
	 */
	private String typeId;
	/**
	 * @name description
	 * @Length(max=65535)
	 */
	private String description;
	/**
	 * @name img
	 * @Length(max=255)
	 */
	private String img;
	/**
	 * @name imgHeight
	 * 
	 */
	private Integer imgHeight;
	/**
	 * @name imgWidth
	 * 
	 */
	private Integer imgWidth;
	/**
	 * @name address
	 * @Length(max=255)
	 */
	private String address;
	/**
	 * @name 精确到小数点后7位，精度就是1CM
	 * 
	 */
	private BigDecimal lon;
	/**
	 * @name lat
	 * 
	 */
	private BigDecimal lat;
	/**
	 * @name 局部坐标系，精确到16位
	 * 
	 */
	private BigDecimal x;
	/**
	 * @name 局部坐标系，精确到16位
	 * 
	 */
	private BigDecimal y;
	/**
	 * @name 局部坐标系，精确到16位
	 * 
	 */
	private BigDecimal z;
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
	public DimTourBas3dResource(){
	
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
 * @name 设置 typeId
 * @param typeId
 */
public void setTypeId(String value) {
	this.typeId = value;
}

/**
 * @name 获得 typeId
 * @return typeId
 */
public String getTypeId() {
	return this.typeId;
}
/**
 * @name 设置 description
 * @param description
 */
public void setDescription(String value) {
	this.description = value;
}

/**
 * @name 获得 description
 * @return description
 */
public String getDescription() {
	return this.description;
}
/**
 * @name 设置 img
 * @param img
 */
public void setImg(String value) {
	this.img = value;
}

/**
 * @name 获得 img
 * @return img
 */
public String getImg() {
	return this.img;
}
/**
 * @name 设置 imgHeight
 * @param imgHeight
 */
public void setImgHeight(Integer value) {
	this.imgHeight = value;
}

/**
 * @name 获得 imgHeight
 * @return imgHeight
 */
public Integer getImgHeight() {
	return this.imgHeight;
}
/**
 * @name 设置 imgWidth
 * @param imgWidth
 */
public void setImgWidth(Integer value) {
	this.imgWidth = value;
}

/**
 * @name 获得 imgWidth
 * @return imgWidth
 */
public Integer getImgWidth() {
	return this.imgWidth;
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
 * @name 设置 精确到小数点后7位，精度就是1CM
 * @param lon
 */
public void setLon(BigDecimal value) {
	this.lon = value;
}

/**
 * @name 获得 精确到小数点后7位，精度就是1CM
 * @return lon
 */
public BigDecimal getLon() {
	return this.lon;
}
/**
 * @name 设置 lat
 * @param lat
 */
public void setLat(BigDecimal value) {
	this.lat = value;
}

/**
 * @name 获得 lat
 * @return lat
 */
public BigDecimal getLat() {
	return this.lat;
}
/**
 * @name 设置 局部坐标系，精确到16位
 * @param x
 */
public void setX(BigDecimal value) {
	this.x = value;
}

/**
 * @name 获得 局部坐标系，精确到16位
 * @return x
 */
public BigDecimal getX() {
	return this.x;
}
/**
 * @name 设置 局部坐标系，精确到16位
 * @param y
 */
public void setY(BigDecimal value) {
	this.y = value;
}

/**
 * @name 获得 局部坐标系，精确到16位
 * @return y
 */
public BigDecimal getY() {
	return this.y;
}
/**
 * @name 设置 局部坐标系，精确到16位
 * @param z
 */
public void setZ(BigDecimal value) {
	this.z = value;
}

/**
 * @name 获得 局部坐标系，精确到16位
 * @return z
 */
public BigDecimal getZ() {
	return this.z;
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

