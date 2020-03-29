package org.tony.carrentalservice.model;

import java.util.Date;

public class OrderInfo {
    private Long id;

    private String userName;

    private Long carId;

    private Date startTime;

    private Date endTime;

    private Short status;

    private Date gmtCreated;

    private Date gmtModified;

    public OrderInfo(Long id, String userName, Long carId, Date startTime, Date endTime, Short status, Date gmtCreated, Date gmtModified) {
        this.id = id;
        this.userName = userName;
        this.carId = carId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.gmtCreated = gmtCreated;
        this.gmtModified = gmtModified;
    }

    public OrderInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}