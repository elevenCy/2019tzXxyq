package com.winter.model.manage.dimTourBas3dRoom;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @name DimTourBas3dRoom
 * @Description DimTourBas3dRoom实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DimTourBas3dRoom")
public class DimTourBas3dRoom extends BaseEntity{

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
	 * @name code
	 * @NotBlank @Length(max=64)
	 */
	private String code;
	/**
	 * @name areaId
	 * @NotBlank @Length(max=32)
	 */
	private String areaId;
	/**
	 * @name 所入住企业id
	 * @Length(max=32)
	 */
	private String enterpriseId;
	/**
	 * @name description
	 * @Length(max=65535)
	 */
	private String description;
	/**
	 * @name imgurl预留字段可展示房间照片什么的
	 * @Length(max=65535)
	 */
	private String img;
	/**
	 * @name 范围
	 * @Length(max=65535)
	 */
	private String range;
	/**
	 * @name 高度
	 * @Length(max=16)
	 */
	private String height;
	/**
	 * @name color
	 * @Length(max=64)
	 */
	private String color;
	/**
	 * @name 总面积
	 * 
	 */
	private BigDecimal totalArea;
	/**
	 * @name 总价：物业+租金
	 * 
	 */
	private BigDecimal totalPrice;
	/**
	 * @name 单价:元/米/月
	 * 
	 */
	private BigDecimal rentPrice;
	/**
	 * @name 年总价 12*单价*面积
	 * 
	 */
	private BigDecimal rentY;
	/**
	 * @name 物业单价:元/米/月
	 * 
	 */
	private BigDecimal propertyPrice;
	/**
	 * @name 年总价
	 * 
	 */
	private BigDecimal propertyY;
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
	 * @name 世界坐标系，精确到16位
	 * 
	 */
	private BigDecimal x;
	/**
	 * @name 世界坐标系，精确到16位
	 * 
	 */
	private BigDecimal y;
	/**
	 * @name 世界坐标系，精确到16位
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
	public DimTourBas3dRoom(){
	
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
 * @name 设置 所入住企业id
 * @param enterpriseId
 */
public void setEnterpriseId(String value) {
	this.enterpriseId = value;
}

/**
 * @name 获得 所入住企业id
 * @return enterpriseId
 */
public String getEnterpriseId() {
	return this.enterpriseId;
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
 * @name 设置 imgurl预留字段可展示房间照片什么的
 * @param img
 */
public void setImg(String value) {
	this.img = value;
}

/**
 * @name 获得 imgurl预留字段可展示房间照片什么的
 * @return img
 */
public String getImg() {
	return this.img;
}
/**
 * @name 设置 范围
 * @param range
 */
public void setRange(String value) {
	this.range = value;
}

/**
 * @name 获得 范围
 * @return range
 */
public String getRange() {
	return this.range;
}
/**
 * @name 设置 高度
 * @param height
 */
public void setHeight(String value) {
	this.height = value;
}

/**
 * @name 获得 高度
 * @return height
 */
public String getHeight() {
	return this.height;
}
/**
 * @name 设置 color
 * @param color
 */
public void setColor(String value) {
	this.color = value;
}

/**
 * @name 获得 color
 * @return color
 */
public String getColor() {
	return this.color;
}
/**
 * @name 设置 总面积
 * @param totalArea
 */
public void setTotalArea(BigDecimal value) {
	this.totalArea = value;
}

/**
 * @name 获得 总面积
 * @return totalArea
 */
public BigDecimal getTotalArea() {
	return this.totalArea;
}
/**
 * @name 设置 总价：物业+租金
 * @param totalPrice
 */
public void setTotalPrice(BigDecimal value) {
	this.totalPrice = value;
}

/**
 * @name 获得 总价：物业+租金
 * @return totalPrice
 */
public BigDecimal getTotalPrice() {
	return this.totalPrice;
}
/**
 * @name 设置 单价:元/米/月
 * @param rentPrice
 */
public void setRentPrice(BigDecimal value) {
	this.rentPrice = value;
}

/**
 * @name 获得 单价:元/米/月
 * @return rentPrice
 */
public BigDecimal getRentPrice() {
	return this.rentPrice;
}
/**
 * @name 设置 年总价 12*单价*面积
 * @param rentY
 */
public void setRentY(BigDecimal value) {
	this.rentY = value;
}

/**
 * @name 获得 年总价 12*单价*面积
 * @return rentY
 */
public BigDecimal getRentY() {
	return this.rentY;
}
/**
 * @name 设置 物业单价:元/米/月
 * @param propertyPrice
 */
public void setPropertyPrice(BigDecimal value) {
	this.propertyPrice = value;
}

/**
 * @name 获得 物业单价:元/米/月
 * @return propertyPrice
 */
public BigDecimal getPropertyPrice() {
	return this.propertyPrice;
}
/**
 * @name 设置 年总价
 * @param propertyY
 */
public void setPropertyY(BigDecimal value) {
	this.propertyY = value;
}

/**
 * @name 获得 年总价
 * @return propertyY
 */
public BigDecimal getPropertyY() {
	return this.propertyY;
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
 * @name 设置 世界坐标系，精确到16位
 * @param x
 */
public void setX(BigDecimal value) {
	this.x = value;
}

/**
 * @name 获得 世界坐标系，精确到16位
 * @return x
 */
public BigDecimal getX() {
	return this.x;
}
/**
 * @name 设置 世界坐标系，精确到16位
 * @param y
 */
public void setY(BigDecimal value) {
	this.y = value;
}

/**
 * @name 获得 世界坐标系，精确到16位
 * @return y
 */
public BigDecimal getY() {
	return this.y;
}
/**
 * @name 设置 世界坐标系，精确到16位
 * @param z
 */
public void setZ(BigDecimal value) {
	this.z = value;
}

/**
 * @name 获得 世界坐标系，精确到16位
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

