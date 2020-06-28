package club.banyuan.sr.service;

import club.banyuan.sr.bo.AdminRecord;
import club.banyuan.sr.bo.BookHours;
import club.banyuan.sr.bo.SeatOrderResp;
import club.banyuan.sr.bo.UserBookHistory;
import club.banyuan.sr.dto.CancelSeatParam;
import club.banyuan.sr.dto.SeatPosition;
import club.banyuan.sr.dto.SeatStatusParam;
import club.banyuan.sr.model.Seat;
import club.banyuan.sr.model.SeatRecord;

import java.util.List;

public interface SeatService {
    List<SeatPosition> findSeat();

    Seat findSeatById(int id);

    SeatOrderResp order(int id);

    void orderSeat(int id, List<BookHours> bookHours);

    List<UserBookHistory> orderHistory();

    void cancelOrder(int id);

    List<SeatPosition> getSeat();

    void changeStatus(SeatStatusParam param);

    List<AdminRecord> getRecords();

    void addSeat(Seat seat);

    void cancelRecords(CancelSeatParam param);
}
