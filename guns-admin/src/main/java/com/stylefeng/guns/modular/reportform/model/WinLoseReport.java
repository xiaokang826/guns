package com.stylefeng.guns.modular.reportform.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author panghu
 * @since 2018-10-25
 */
@TableName("report_data")
public class WinLoseReport extends Model<WinLoseReport> {

    private static final long serialVersionUID = 1L;

    /**
     * 账变时间
     */
    @TableField("account_change_time")
    private Date accountChangeTime;
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
     * 桌子号
     */
    @TableField("table_number")
    private Integer tableNumber;
    /**
     * 座位号
     */
    @TableField("seat_number")
    private Integer seatNumber;
    /**
     * 庄闲
     */
    private String leisure;
    /**
     * 初始金额
     */
    @TableField("initial_amount")
    private Integer initialAmount;
    /**
     * 总投注
     */
    @TableField("total_bet")
    private Integer totalBet;
    /**
     * 有效投注额
     */
    @TableField("valid_bet")
    private Integer validBet;
    /**
     * 输赢金额
     */
    @TableField("win_lose_amount")
    private Integer winLoseAmount;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getAccountChangeTime() {
        return accountChangeTime;
    }

    public void setAccountChangeTime(Date accountChangeTime) {
        this.accountChangeTime = accountChangeTime;
    }

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

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getLeisure() {
        return leisure;
    }

    public void setLeisure(String leisure) {
        this.leisure = leisure;
    }

    public Integer getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(Integer initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Integer getTotalBet() {
        return totalBet;
    }

    public void setTotalBet(Integer totalBet) {
        this.totalBet = totalBet;
    }

    public Integer getValidBet() {
        return validBet;
    }

    public void setValidBet(Integer validBet) {
        this.validBet = validBet;
    }

    public Integer getWinLoseAmount() {
        return winLoseAmount;
    }

    public void setWinLoseAmount(Integer winLoseAmount) {
        this.winLoseAmount = winLoseAmount;
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

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
