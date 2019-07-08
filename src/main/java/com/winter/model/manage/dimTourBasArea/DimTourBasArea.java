package com.winter.model.manage.dimTourBasArea;

import com.winter.model.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @name DimTourBasArea
 * @Description DimTourBasArea实体对象
 * @author tujing
 * @date 2016-07-01
 */
@Alias("DimTourBasArea")
public class DimTourBasArea extends BaseEntity{

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
	 * @NotBlank @Length(max=6)
	 */
	private String code;
	/**
	 * @name pid
	 * @NotBlank @Length(max=32)
	 */
	private String pid;
	/**
	 * @name remark
	 * @Length(max=255)
	 */
	private String remark;
	/**
	 * @name bearingCapacityMoment
	 *
	 */
	private Integer bearingCapacityMoment;
	/**
	 * @name bearingCapacityDay
	 *
	 */
	private Integer bearingCapacityDay;
	/**
	 * @name bearingCapacityMax
	 *
	 */
	private Integer bearingCapacityMax;
	/**
	 * @name 楼层数量
	 *
	 */
	private Integer floorSum;
	/**
	 * @name 总面积
	 *
	 */
	private BigDecimal totalArea;
	/**
	 * @name 可租面积
	 *
	 */
	private BigDecimal canRentArea;
	/**
	 * @name 已租面积
	 *
	 */
	private BigDecimal rentArea;
	/**
	 * @name 空置面积
	 *
	 */
	private BigDecimal vacancyArea;
	/**
	 * @name 可招商面积
	 *
	 */
	private BigDecimal invitingArea;
	/**
	 * @name 配置面积
	 *
	 */
	private BigDecimal supportingArea;
	/**
	 * @name 客户总数
	 *
	 */
	private Integer entepriseNum;
	/**
	 * @name 3d数据路径
	 * @Length(max=255)
	 */
	private String url3d;
	/**
	 * @name sort
	 * @NotNull
	 */
	private Integer sort;
	/**
	 * @name 中心点
	 * @Length(max=255)
	 */
	private String center;
	/**
	 * @name 主视角
	 * @Length(max=255)
	 */
	private String mainView;
	/**
	 * @name 漫游路线
	 * @Length(max=65535)
	 */
	private String play;
	/**
	 * @name 二维地图的范围
	 * @Length(max=65535)
	 */
	private String range;
	/**
	 * @name 获取回路状态（亮暗）
	 * @Length(max=16)
	 */
	private String hlStatus;
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
	public DimTourBasArea(){

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
	 * @name 设置 pid
	 * @param pid
	 */
	public void setPid(String value) {
		this.pid = value;
	}

	/**
	 * @name 获得 pid
	 * @return pid
	 */
	public String getPid() {
		return this.pid;
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
	 * @name 设置 bearingCapacityMoment
	 * @param bearingCapacityMoment
	 */
	public void setBearingCapacityMoment(Integer value) {
		this.bearingCapacityMoment = value;
	}

	/**
	 * @name 获得 bearingCapacityMoment
	 * @return bearingCapacityMoment
	 */
	public Integer getBearingCapacityMoment() {
		return this.bearingCapacityMoment;
	}
	/**
	 * @name 设置 bearingCapacityDay
	 * @param bearingCapacityDay
	 */
	public void setBearingCapacityDay(Integer value) {
		this.bearingCapacityDay = value;
	}

	/**
	 * @name 获得 bearingCapacityDay
	 * @return bearingCapacityDay
	 */
	public Integer getBearingCapacityDay() {
		return this.bearingCapacityDay;
	}
	/**
	 * @name 设置 bearingCapacityMax
	 * @param bearingCapacityMax
	 */
	public void setBearingCapacityMax(Integer value) {
		this.bearingCapacityMax = value;
	}

	/**
	 * @name 获得 bearingCapacityMax
	 * @return bearingCapacityMax
	 */
	public Integer getBearingCapacityMax() {
		return this.bearingCapacityMax;
	}
	/**
	 * @name 设置 楼层数量
	 * @param floorSum
	 */
	public void setFloorSum(Integer value) {
		this.floorSum = value;
	}

	/**
	 * @name 获得 楼层数量
	 * @return floorSum
	 */
	public Integer getFloorSum() {
		return this.floorSum;
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
	 * @name 设置 可租面积
	 * @param canRentArea
	 */
	public void setCanRentArea(BigDecimal value) {
		this.canRentArea = value;
	}

	/**
	 * @name 获得 可租面积
	 * @return canRentArea
	 */
	public BigDecimal getCanRentArea() {
		return this.canRentArea;
	}
	/**
	 * @name 设置 已租面积
	 * @param rentArea
	 */
	public void setRentArea(BigDecimal value) {
		this.rentArea = value;
	}

	/**
	 * @name 获得 已租面积
	 * @return rentArea
	 */
	public BigDecimal getRentArea() {
		return this.rentArea;
	}
	/**
	 * @name 设置 空置面积
	 * @param vacancyArea
	 */
	public void setVacancyArea(BigDecimal value) {
		this.vacancyArea = value;
	}

	/**
	 * @name 获得 空置面积
	 * @return vacancyArea
	 */
	public BigDecimal getVacancyArea() {
		return this.vacancyArea;
	}
	/**
	 * @name 设置 可招商面积
	 * @param invitingArea
	 */
	public void setInvitingArea(BigDecimal value) {
		this.invitingArea = value;
	}

	/**
	 * @name 获得 可招商面积
	 * @return invitingArea
	 */
	public BigDecimal getInvitingArea() {
		return this.invitingArea;
	}
	/**
	 * @name 设置 配置面积
	 * @param supportingArea
	 */
	public void setSupportingArea(BigDecimal value) {
		this.supportingArea = value;
	}

	/**
	 * @name 获得 配置面积
	 * @return supportingArea
	 */
	public BigDecimal getSupportingArea() {
		return this.supportingArea;
	}
	/**
	 * @name 设置 客户总数
	 * @param entepriseNum
	 */
	public void setEntepriseNum(Integer value) {
		this.entepriseNum = value;
	}

	/**
	 * @name 获得 客户总数
	 * @return entepriseNum
	 */
	public Integer getEntepriseNum() {
		return this.entepriseNum;
	}
	/**
	 * @name 设置 3d数据路径
	 * @param url3d
	 */
	public void setUrl3d(String value) {
		this.url3d = value;
	}

	/**
	 * @name 获得 3d数据路径
	 * @return url3d
	 */
	public String getUrl3d() {
		return this.url3d;
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
	 * @name 设置 中心点
	 * @param center
	 */
	public void setCenter(String value) {
		this.center = value;
	}

	/**
	 * @name 获得 中心点
	 * @return center
	 */
	public String getCenter() {
		return this.center;
	}
	/**
	 * @name 设置 主视角
	 * @param mainView
	 */
	public void setMainView(String value) {
		this.mainView = value;
	}

	/**
	 * @name 获得 主视角
	 * @return mainView
	 */
	public String getMainView() {
		return this.mainView;
	}
	/**
	 * @name 设置 漫游路线
	 * @param play
	 */
	public void setPlay(String value) {
		this.play = value;
	}

	/**
	 * @name 获得 漫游路线
	 * @return play
	 */
	public String getPlay() {
		return this.play;
	}
	/**
	 * @name 设置 二维地图的范围
	 * @param range
	 */
	public void setRange(String value) {
		this.range = value;
	}

	/**
	 * @name 获得 二维地图的范围
	 * @return range
	 */
	public String getRange() {
		return this.range;
	}
	/**
	 * @name 设置 获取回路状态（亮暗）
	 * @param hlStatus
	 */
	public void setHlStatus(String value) {
		this.hlStatus = value;
	}

	/**
	 * @name 获得 获取回路状态（亮暗）
	 * @return hlStatus
	 */
	public String getHlStatus() {
		return this.hlStatus;
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

