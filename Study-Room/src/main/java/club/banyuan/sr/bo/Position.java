package club.banyuan.sr.bo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class Position {
    @ApiModelProperty(value = "座位名称", required = true)
    private String name;
    @ApiModelProperty(value = "状态", required = true)
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
