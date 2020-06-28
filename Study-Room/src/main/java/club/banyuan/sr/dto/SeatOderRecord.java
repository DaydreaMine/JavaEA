package club.banyuan.sr.dto;

public class SeatOderRecord {
    private int userId;
    private String seatName;
    private String data;
    private Integer hour;
    private Boolean hasbooked;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Boolean getHasbooked() {
        return hasbooked;
    }

    public void setHasbooked(Boolean hasbooked) {
        this.hasbooked = hasbooked;
    }
}
