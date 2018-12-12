package com.stylefeng.guns.modular.reportform.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author panghu
 * @since 2018-10-25
 */
@TableName("report_data")
public class GameResults extends Model<GameResults> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 游戏类型
     */
    @TableField("game_name")
    private String gameName;
    /**
     * 房间类型
     */
    @TableField("room_type")
    private String roomType;
    /**
     * 座位号
     */
    @TableField("seat_number")
    private Integer seatNumber;
    /**
     * 局号
     */
    @TableField("board_number")
    private String boardNumber;
    /**
     * 游戏结果
     */
    @TableField("game_result")
    private String gameResult;
    /**
     * 游戏开始时间
     */
    @TableField("game_start_time")
    private Date gameStartTime;
    /**
     * 游戏结束时间
     */
    @TableField("game_end_time")
    private Date gameEndTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getBoardNumber() {
        return boardNumber;
    }

    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public Date getGameStartTime() {
        return gameStartTime;
    }

    public void setGameStartTime(Date gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    public Date getGameEndTime() {
        return gameEndTime;
    }

    public void setGameEndTime(Date gameEndTime) {
        this.gameEndTime = gameEndTime;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
