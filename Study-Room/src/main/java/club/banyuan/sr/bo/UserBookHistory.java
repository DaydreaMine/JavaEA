package club.banyuan.sr.bo;

import club.banyuan.sr.bo.Position;
import io.swagger.annotations.ApiModelProperty;

public class UserBookHistory {
    @ApiModelProperty(value = "记录id", required = true)
    private int id;
    @ApiModelProperty(value = "用户id", required = true)
    private int userId;
    @ApiModelProperty(value = "座位id", required = true)
    private int positionId;
    @ApiModelProperty(value = "座位信息", required = true)
    private Position postion;
    @ApiModelProperty(value = "日期", required = true)
    private String data;
    @ApiModelProperty(value = "时间", required = true)
    private int hour;
    @ApiModelProperty(value = "状态", required = true)
    private boolean cancelFlag;
    @ApiModelProperty(value = "创建时间", required = true)
    private String createdAt;
    @ApiModelProperty(value = "更新时间", required = true)
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public Position getPostion() {
        return postion;
    }

    public void setPostion(Position postion) {
        this.postion = postion;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(boolean cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
