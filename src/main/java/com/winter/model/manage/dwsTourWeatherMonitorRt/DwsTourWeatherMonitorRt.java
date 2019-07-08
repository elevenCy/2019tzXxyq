package com.winter.model.manage.dwsTourWeatherMonitorRt;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @name DwsTourWeatherMonitorRt
 * @Description DwsTourWeatherMonitorRt实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DwsTourWeatherMonitorRt")
public class DwsTourWeatherMonitorRt extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * @name 编号
	 * @primarykey 主键,要求唯一
	 * @Length(max=80)
	 */
	private String code;
	/**
	 * @name 天气图片代码
	 * @Length(max=8)
	 */
	private String imgCode;
	/**
	 * @name 地区
	 * @Length(max=64)
	 */
	private String name;
	/**
	 * @name 实时温度
	 * 
	 */
	private Integer temperature;
	/**
	 * @name 最高温度
	 * 
	 */
	private Integer highTemperature;
	/**
	 * @name 最低温度
	 * 
	 */
	private Integer lowTemperature;
	/**
	 * @name 风向描述
	 * @Length(max=64)
	 */
	private String windDir;
	/**
	 * @name 风速
	 * @Length(max=64)
	 */
	private String windSpeed;
	/**
	 * @name 类型(多云、晴)
	 * @Length(max=64)
	 */
	private String type;
	/**
	 * @name 空气质量
	 * @Length(max=64)
	 */
	private String qlty;
	/**
	 * @name pm2.5值
	 * @Length(max=64)
	 */
	private String pm25;
	/**
	 * @name 创建时间
	 * 
	 */
	private Date createdate;

	/**
	 * @name 查询关键字
	 */
	private String keyWord;

	
	private String hum;
	
    public String getHum() {
		return hum;
	}




	public void setHum(String hum) {
		this.hum = hum;
	}




	/**
     * @name 无参构造函数
     */
	public DwsTourWeatherMonitorRt(){
	
	}
	
	


/**
 * @name 设置 编号
 * @param code
 */
public void setCode(String value) {
	this.code = value;
}

/**
 * @name 获得 编号
 * @return code
 */
public String getCode() {
	return this.code;
}
/**
 * @name 设置 天气图片代码
 * @param imgCode
 */
public void setImgCode(String value) {
	this.imgCode = value;
}

/**
 * @name 获得 天气图片代码
 * @return imgCode
 */
public String getImgCode() {
	return this.imgCode;
}
/**
 * @name 设置 地区
 * @param name
 */
public void setName(String value) {
	this.name = value;
}

/**
 * @name 获得 地区
 * @return name
 */
public String getName() {
	return this.name;
}
/**
 * @name 设置 实时温度
 * @param temperature
 */
public void setTemperature(Integer value) {
	this.temperature = value;
}

/**
 * @name 获得 实时温度
 * @return temperature
 */
public Integer getTemperature() {
	return this.temperature;
}
/**
 * @name 设置 最高温度
 * @param highTemperature
 */
public void setHighTemperature(Integer value) {
	this.highTemperature = value;
}

/**
 * @name 获得 最高温度
 * @return highTemperature
 */
public Integer getHighTemperature() {
	return this.highTemperature;
}
/**
 * @name 设置 最低温度
 * @param lowTemperature
 */
public void setLowTemperature(Integer value) {
	this.lowTemperature = value;
}

/**
 * @name 获得 最低温度
 * @return lowTemperature
 */
public Integer getLowTemperature() {
	return this.lowTemperature;
}
/**
 * @name 设置 风向描述
 * @param windDir
 */
public void setWindDir(String value) {
	this.windDir = value;
}

/**
 * @name 获得 风向描述
 * @return windDir
 */
public String getWindDir() {
	return this.windDir;
}
/**
 * @name 设置 风速
 * @param windSpeed
 */
public void setWindSpeed(String value) {
	this.windSpeed = value;
}

/**
 * @name 获得 风速
 * @return windSpeed
 */
public String getWindSpeed() {
	return this.windSpeed;
}
/**
 * @name 设置 类型(多云、晴)
 * @param type
 */
public void setType(String value) {
	this.type = value;
}

/**
 * @name 获得 类型(多云、晴)
 * @return type
 */
public String getType() {
	return this.type;
}
/**
 * @name 设置 空气质量
 * @param qlty
 */
public void setQlty(String value) {
	this.qlty = value;
}

/**
 * @name 获得 空气质量
 * @return qlty
 */
public String getQlty() {
	return this.qlty;
}
/**
 * @name 设置 pm2.5值
 * @param pm25
 */
public void setPm25(String value) {
	this.pm25 = value;
}

/**
 * @name 获得 pm2.5值
 * @return pm25
 */
public String getPm25() {
	return this.pm25;
}
/**
 * @name 设置 创建时间
 * @param createdate
 */
public void setCreatedate(Date value) {
	this.createdate = value;
}

/**
 * @name 获得 创建时间
 * @return createdate
 */
public Date getCreatedate() {
	return this.createdate;
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

