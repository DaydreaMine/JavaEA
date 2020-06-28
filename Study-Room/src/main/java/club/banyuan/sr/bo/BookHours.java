package club.banyuan.sr.bo;

import io.swagger.annotations.ApiModelProperty;

public class BookHours {
    @ApiModelProperty(value = "日期", required = true)
    private String data;
    @ApiModelProperty(value = "时间", required = true)
    private int hour;
    @ApiModelProperty(value = "占用情况", required = true)
    private boolean hasBooked;

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

    public boolean isHasBooked() {
        return hasBooked;
    }

    public void setHasBooked(boolean hasBooked) {
        this.hasBooked = hasBooked;
    }

}
