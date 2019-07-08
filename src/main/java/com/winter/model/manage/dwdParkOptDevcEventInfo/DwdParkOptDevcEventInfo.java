package com.winter.model.manage.dwdParkOptDevcEventInfo;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @name DwdParkOptDevcEventInfo
 * @Description DwdParkOptDevcEventInfo实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DwdParkOptDevcEventInfo")
public class DwdParkOptDevcEventInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * @name id
	 * @primarykey 主键,要求唯一
	 * @Length(max=32)
	 */
	private String id;
	/**
	 * @name 事件名称
	 * @Length(max=64)
	 */
	private String name;
	/**
	 * @name 事件信息
	 * @Length(max=128)
	 */
	private String info;
	/**
	 * @name 事件告警
	 * @Length(max=64)
	 */
	private String warning;
	
	private String warningName;
	
	private String warningIcon;
	public String getWarningName() {
		return warningName;
	}

	public void setWarningName(String warningName) {
		this.warningName = warningName;
	}

	public String getWarningIcon() {
		return warningIcon;
	}

	public void setWarningIcon(String warningIcon) {
		this.warningIcon = warningIcon;
	}

	/**
	 * @name 事件内容
	 * @Length(max=65535)
	 */
	private String content;
	/**
	 * @name 事件类型
	 * @Length(max=64)
	 */
	private String type;
	
	private String typeName;

	/**
	 * @name 事件级别
	 * @Length(max=64)
	 */
	private String level;
	
	private String levelName;
	/**
	 * @name 事件状态
	 * @Length(max=64)
	 */
	private String status;
	
	private String statusName;
	/**
	 * @name 关联id
	 * @Length(max=32)
	 */
	private String relevanceId;
	/**
	 * @name 创建时间
	 * 
	 */
	private Date createTime;
	/**
	 * @name 发生时间
	 * 
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date happenTime;
	/**
	 * @name 处理时间
	 * 
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date resolveTime;
	/**
	 * @name 解决时间
	 * 
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date solutionTime;

	/**
	 * @name 查询关键字
	 */
	private String keyWord;

    /**
     * @name 无参构造函数
     */
	public DwdParkOptDevcEventInfo(){
	
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
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
 * @name 设置 事件名称
 * @param name
 */
public void setName(String value) {
	this.name = value;
}

/**
 * @name 获得 事件名称
 * @return name
 */
public String getName() {
	return this.name;
}
/**
 * @name 设置 事件信息
 * @param info
 */
public void setInfo(String value) {
	this.info = value;
}

/**
 * @name 获得 事件信息
 * @return info
 */
public String getInfo() {
	return this.info;
}
/**
 * @name 设置 事件告警
 * @param warning
 */
public void setWarning(String value) {
	this.warning = value;
}

/**
 * @name 获得 事件告警
 * @return warning
 */
public String getWarning() {
	return this.warning;
}
/**
 * @name 设置 事件内容
 * @param content
 */
public void setContent(String value) {
	this.content = value;
}

/**
 * @name 获得 事件内容
 * @return content
 */
public String getContent() {
	return this.content;
}
/**
 * @name 设置 事件类型
 * @param type
 */
public void setType(String value) {
	this.type = value;
}

/**
 * @name 获得 事件类型
 * @return type
 */
public String getType() {
	return this.type;
}
/**
 * @name 设置 事件级别
 * @param level
 */
public void setLevel(String value) {
	this.level = value;
}

/**
 * @name 获得 事件级别
 * @return level
 */
public String getLevel() {
	return this.level;
}
/**
 * @name 设置 事件状态
 * @param status
 */
public void setStatus(String value) {
	this.status = value;
}

/**
 * @name 获得 事件状态
 * @return status
 */
public String getStatus() {
	return this.status;
}
/**
 * @name 设置 关联id
 * @param relevanceId
 */
public void setRelevanceId(String value) {
	this.relevanceId = value;
}

/**
 * @name 获得 关联id
 * @return relevanceId
 */
public String getRelevanceId() {
	return this.relevanceId;
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
 * @name 设置 发生时间
 * @param happenTime
 */
public void setHappenTime(Date value) {
	this.happenTime = value;
}

/**
 * @name 获得 发生时间
 * @return happenTime
 */
public Date getHappenTime() {
	return this.happenTime;
}
/**
 * @name 设置 处理时间
 * @param resolveTime
 */
public void setResolveTime(Date value) {
	this.resolveTime = value;
}

/**
 * @name 获得 处理时间
 * @return resolveTime
 */
public Date getResolveTime() {
	return this.resolveTime;
}
/**
 * @name 设置 解决时间
 * @param solutionTime
 */
public void setSolutionTime(Date value) {
	this.solutionTime = value;
}

/**
 * @name 获得 解决时间
 * @return solutionTime
 */
public Date getSolutionTime() {
	return this.solutionTime;
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

