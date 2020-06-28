package club.banyuan.sr.bo;

import club.banyuan.sr.bo.BookHours;
import club.banyuan.sr.bo.Position;

import java.util.List;

public class SeatOrderResp {
    private Position position;
    private List<BookHours> bookHours;

    public List<BookHours> getBookHours() {
        return bookHours;
    }

    public void setBookHours(List<BookHours> bookHours) {
        this.bookHours = bookHours;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
