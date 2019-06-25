package com.xtaller.party.doc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Party on 2019/03/14
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@ApiModel(value = "课程、会议安排修改")
public class ScheduleUpdate {
    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "摘要")
    private String summary;
    @ApiModelProperty(value = "主题")
    private String topic;
    @ApiModelProperty(value = "地点")
    private String place;
    @ApiModelProperty(value = "地理位置")
    private String position;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "总分值")
    private String score;
    @ApiModelProperty(value = "类型")
    private Integer type;
    @ApiModelProperty(value = "主讲人姓名")
    private String speaker;
    @ApiModelProperty(value = "开始时间")
    private Integer startTime;
    @ApiModelProperty(value = "结束时间")
    private Integer endTime;
    @ApiModelProperty(value = "发布范围")
    private String range;
    @ApiModelProperty(value = "是否发短信通知")
    private Integer isNote;
    @ApiModelProperty(value = "是否推送")
    private Integer isPush;
    @ApiModelProperty(value = "考核形式")
    private Integer checkType;
    @ApiModelProperty(value = "联系人学号/工号")
    private String linkmanNumber;
    @ApiModelProperty(value = "联系电话")
    private String linkmanPhone;
    @ApiModelProperty(value = "备注，备用字段")
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Integer getIsNote() {
        return isNote;
    }

    public void setIsNote(Integer isNote) {
        this.isNote = isNote;
    }

    public Integer getIsPush() {
        return isPush;
    }

    public void setIsPush(Integer isPush) {
        this.isPush = isPush;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    public String getLinkmanNumber() {
        return linkmanNumber;
    }

    public void setLinkmanNumber(String linkmanNumber) {
        this.linkmanNumber = linkmanNumber;
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
