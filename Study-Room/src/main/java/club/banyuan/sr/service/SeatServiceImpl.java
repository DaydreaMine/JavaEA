package club.banyuan.sr.service;

import club.banyuan.sr.bo.*;
import club.banyuan.sr.dao.SeatDao;
import club.banyuan.sr.dao.SeatRecordDao;
import club.banyuan.sr.dao.UserFuckDao;
import club.banyuan.sr.dto.CancelSeatParam;
import club.banyuan.sr.dto.SeatPosition;
import club.banyuan.sr.dto.SeatStatusParam;
import club.banyuan.sr.mapper.SeatMapper;
import club.banyuan.sr.mapper.SeatRecordMapper;
import club.banyuan.sr.mapper.UserMapper;
import club.banyuan.sr.model.*;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    //设置预约时间48小时以内
    public final Integer HOUR_NUMBER = 48;
    @Autowired
    SeatRecordDao seatRecordDao;
    @Autowired
    SeatDao seatDao;
    @Autowired
    UserFuckDao userFuckDao;
    @Autowired
    SeatMapper seatMapper;
    @Autowired
    SeatRecordMapper seatRecordMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    //获取status为1的seat
    public List<SeatPosition> findSeat() {
        SeatExample seatExample = new SeatExample();
        seatExample.createCriteria().andStatusEqualTo(1);
        List<Seat> tempSeat = seatMapper.selectByExample(seatExample);
        List<SeatPosition> seatPositions = new ArrayList<>();
        for (Seat seat:tempSeat){
        SeatPosition seatPosition= new SeatPosition();
        seatPosition.setId(seat.getId());
        seatPosition.setStatus(seat.getStatus());
        seatPosition.setName(seat.getName());
        seatPositions.add(seatPosition);
        }
        return seatPositions;
    }

    @Override
    //用id获取的seat
    public Seat findSeatById(int id) {
        SeatExample seatExample = new SeatExample();
        seatExample.createCriteria().andIdEqualTo(id);
        List<Seat> tempSeat = seatMapper.selectByExample(seatExample);
        return tempSeat.get(0);
    }

    //通过sercurityContext获取当前用户
    public User select() {
        //找到当前登陆用户
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userFuckDao.findByUserName(username);
        return user;
    }

    @Override
    public SeatOrderResp order(int id) {
        Seat seat = seatMapper.selectByPrimaryKey(id);
        User user = select();
        SeatRecordExample seatRecordExample = new SeatRecordExample();
        //找到当前用户对选择座位的具体情况
        seatRecordExample.createCriteria().andUserIdEqualTo(user.getId())
                .andSeatNameEqualTo(seat.getName());
        List<SeatRecord> tempSR = seatRecordMapper.selectByExample(seatRecordExample);
        String data = DateUtil.today();
        int nowHour = DateUtil.thisHour(true);
        List<BookHours> bookHours = new ArrayList<>();
        //生成预约时间（48）
        for (int i = 0; i < HOUR_NUMBER; i++) {
            bookHours.get(i).setData(data);
            bookHours.get(i).setHour(nowHour);
            bookHours.get(i).setHasBooked(true);
            if (nowHour + 1 > 24) {
                nowHour = 0;
                Date date1 = DateUtil.parse(data);
                date1 = DateUtil.offsetDay(date1, 1);
                data = DateUtil.formatDate(date1);
            } else {
                nowHour++;
            }
        }
        //已预约的 true->false
        for (int i = 0; i < HOUR_NUMBER; i++) {
            for (int j = 0; j < tempSR.size(); j++) {
                if (tempSR.get(j).getData().equals(data)) {
                    if (tempSR.get(j).getHour() == nowHour) {
                        bookHours.get(i).setHasBooked(false);
                    }
                }
            }
        }
        Position position = new Position();
        position.setName(seat.getName());
        position.setStatus(seat.getStatus());
        SeatOrderResp resp = new SeatOrderResp();
        resp.setBookHours(bookHours);
        resp.setPosition(position);
        return resp;
    }

    //预约post
    @Override
    public void orderSeat(int id, List<BookHours> bookHours) {
        Seat seat = seatMapper.selectByPrimaryKey(id);
        User user = select();
        SeatRecord seatRecord = new SeatRecord();
        for (BookHours bookHours1 : bookHours) {
            seatRecord.setData(bookHours1.getData());
            seatRecord.setHour(bookHours1.getHour());
            seatRecord.setHasbooked(bookHours1.isHasBooked());
            seatRecord.setUserId(user.getId());
            seatRecord.setSeatName(seat.getName());
            seatRecordMapper.insert(seatRecord);
        }
    }

    //通过名字获取座位座位
    public Seat selectBySeatName(String name) {
        SeatExample example = new SeatExample();
        example.createCriteria().andNameEqualTo(name);
        List<Seat> seat = seatMapper.selectByExample(example);
        return seat.get(0);
    }

    //查看预约历史
    @Override
    public List<UserBookHistory> orderHistory() {
        User user = select();
        SeatRecordExample example = new SeatRecordExample();
        example.createCriteria().andUserIdEqualTo(user.getId());
        List<SeatRecord> seatRecords = seatRecordMapper.selectByExample(example);
        List<UserBookHistory> bookHistories = new ArrayList<>();
        for (SeatRecord seatRecord : seatRecords) {
            UserBookHistory bookHistory = new UserBookHistory();
            bookHistory.setCreatedAt(DateUtil.formatDate(seatRecord.getCreatedAt()));
            bookHistory.setUpdatedAt(DateUtil.formatDate(seatRecord.getUpdatedAt()));
            bookHistory.setCancelFlag(seatRecord.getHasbooked());
            bookHistory.setData(seatRecord.getData());
            bookHistory.setUserId(seatRecord.getUserId());
            bookHistory.setHour(seatRecord.getHour());
            bookHistory.setPositionId(selectBySeatName(seatRecord.getSeatName()).getId());
            Position position = new Position();
            position.setName(seatRecord.getSeatName());
            position.setStatus(selectBySeatName(seatRecord.getSeatName()).getStatus());
            bookHistory.setPostion(position);
            bookHistories.add(bookHistory);
        }
        return bookHistories;
    }

    @Override
    public void cancelOrder(int id) {
        SeatRecordExample example = new SeatRecordExample();
        example.createCriteria().andIdEqualTo(id);
        SeatRecord seatRecord = seatRecordMapper.selectByExample(example).get(0);
        seatRecord.setHasbooked(true);
        seatRecordMapper.updateByPrimaryKey(seatRecord);
    }

    @Override
    public List<SeatPosition> getSeat() {
        List<SeatPosition> positions = new ArrayList<>();
        List<Seat> seats=seatDao.getSeat();
        for (Seat seat:seats){
            SeatPosition position = new SeatPosition();
            position.setStatus(seat.getStatus());
            position.setName(seat.getName());
            position.setId(seat.getId());
            positions.add(position);
        }
        return positions;
    }

    @Override
    public void changeStatus(SeatStatusParam param) {
        Seat seat = findSeatById(param.getId());
        seat.setStatus(param.getStatus());
        seatMapper.updateByPrimaryKey(seat);
    }

    @Override
    public void addSeat(Seat seat){
        seatMapper.insert(seat);
    }

    @Override
    public List<AdminRecord> getRecords() {
//        List<Seat> seats = getSeat();
//        List<User> users = userFuckDao.getUser();
        List<SeatRecord> seatRecords = seatRecordDao.getSeatRecord();
        List<AdminRecord> adminRecords = new ArrayList<>();
        for (int i=0;i<seatRecords.size();i++) {
            Position position = new Position();
            SeatRecord seatRecord = seatRecords.get(i);
            Seat seat = seatDao.getSeatByName(seatRecord.getSeatName());
            User user = userMapper.selectByPrimaryKey(seatRecord.getUserId());
            position.setName(seat.getName());
            position.setStatus(seat.getStatus());
            AdminRecord adminRecord = new AdminRecord();
            adminRecord.setCancelFlag(seatRecord.getHasbooked());
            adminRecord.setCreatedAt(DateUtil.formatDate(seatRecord.getCreatedAt()));
            adminRecord.setDate(seatRecord.getData());
            adminRecord.setHour(seatRecord.getHour());
            adminRecord.setId(i+1);
            adminRecord.setPosition(position);
            adminRecord.setPositionId(seat.getId());
            adminRecord.setUser(user);
            adminRecord.setUserId(user.getId());
            adminRecord.setUpdatedAt(DateUtil.formatDate(seatRecord.getUpdatedAt()));
            adminRecords.add(adminRecord);
        }
        return adminRecords;
    }

    @Override
    public void cancelRecords(CancelSeatParam param){
        SeatRecordExample example = new SeatRecordExample();
        example.createCriteria().andIdEqualTo(param.getUserId())
                .andSeatNameEqualTo(param.getSeatName())
                .andDataEqualTo(param.getData())
                .andHourEqualTo(param.getHour());
        SeatRecord seatRecord= seatRecordMapper.selectByExample(example).get(0);
        seatRecord.setHasbooked(param.isHasBook());
        seatRecordMapper.updateByPrimaryKey(seatRecord);
    }
}