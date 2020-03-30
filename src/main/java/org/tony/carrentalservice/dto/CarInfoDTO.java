package org.tony.carrentalservice.dto;

import java.util.Date;

public class CarInfoDTO {

    public static final short STATUS_DISABLE = 0;
    public static final short STATUS_ENABLE = 1;

    private Long id;

    private String model;

    private Short status;

    private Date gmtCreated;

    private Date gmtModified;

    public CarInfoDTO(Long id, String model, Short status, Date gmtCreated, Date gmtModified) {
        this.id = id;
        this.model = model;
        this.status = status;
        this.gmtCreated = gmtCreated;
        this.gmtModified = gmtModified;
    }

    public CarInfoDTO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
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