package club.banyuan.sr.dto;

import io.swagger.annotations.ApiModelProperty;

public class SeatStatusParam {
    @ApiModelProperty(value = "座位状态", required = true)
    private int status;
    @ApiModelProperty(value = "座位id", required = true)
    private int id;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
