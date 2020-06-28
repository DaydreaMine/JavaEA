package club.banyuan.sr.dao;

import club.banyuan.sr.model.Seat;

import java.util.List;

public interface SeatDao {
    List<Seat> getSeat();
    Seat getSeatByName(String name);
}
