package club.banyuan.sr.dto;

public class CancelSeatParam {
   private String seatName;
    private int userId;
    private String data;
    private int hour;
    private boolean hasBook;

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public boolean isHasBook() {
        return hasBook;
    }

    public void setHasBook(boolean hasBook) {
        this.hasBook = hasBook;
    }
}
