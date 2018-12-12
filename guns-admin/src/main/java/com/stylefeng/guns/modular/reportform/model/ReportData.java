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
 * @since 2018-11-02
 */
@TableName("report_data")
public class ReportData extends Model<ReportData> {

    private static final long serialVersionUID = 1L;

    /**
     * 索引
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
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
    /**
     * 对局日志详情
     */
    @TableField("log_details")
    private String logDetails;
    /**
     * 订单号
     */
    @TableField("order_number")
    private String orderNumber;
    /**
     * 订单详情
     */
    @TableField("order_details")
    private String orderDetails;
    /**
     * 账变类型
     */
    @TableField("account_type")
    private String accountType;
    /**
     * 变前金额
     */
    @TableField("amount_before_change")
    private Integer amountBeforeChange;
    /**
     * 账变金额
     */
    @TableField("account_change_amount")
    private Integer accountChangeAmount;
    /**
     * 变后金额
     */
    @TableField("amount_after_change")
    private Integer amountAfterChange;
    /**
     * 操作人
     */
    private String operator;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLogDetails() {
        return logDetails;
    }

    public void setLogDetails(String logDetails) {
        this.logDetails = logDetails;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getAmountBeforeChange() {
        return amountBeforeChange;
    }

    public void setAmountBeforeChange(Integer amountBeforeChange) {
        this.amountBeforeChange = amountBeforeChange;
    }

    public Integer getAccountChangeAmount() {
        return accountChangeAmount;
    }

    public void setAccountChangeAmount(Integer accountChangeAmount) {
        this.accountChangeAmount = accountChangeAmount;
    }

    public Integer getAmountAfterChange() {
        return amountAfterChange;
    }

    public void setAmountAfterChange(Integer amountAfterChange) {
        this.amountAfterChange = amountAfterChange;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ReportData{" +
        "id=" + id +
        ", accountChangeTime=" + accountChangeTime +
        ", userName=" + userName +
        ", gameName=" + gameName +
        ", roomType=" + roomType +
        ", tableNumber=" + tableNumber +
        ", seatNumber=" + seatNumber +
        ", leisure=" + leisure +
        ", initialAmount=" + initialAmount +
        ", totalBet=" + totalBet +
        ", validBet=" + validBet +
        ", winLoseAmount=" + winLoseAmount +
        ", boardNumber=" + boardNumber +
        ", gameResult=" + gameResult +
        ", gameStartTime=" + gameStartTime +
        ", gameEndTime=" + gameEndTime +
        ", logDetails=" + logDetails +
        ", orderNumber=" + orderNumber +
        ", orderDetails=" + orderDetails +
        ", accountType=" + accountType +
        ", amountBeforeChange=" + amountBeforeChange +
        ", accountChangeAmount=" + accountChangeAmount +
        ", amountAfterChange=" + amountAfterChange +
        ", operator=" + operator +
        "}";
    }
}
