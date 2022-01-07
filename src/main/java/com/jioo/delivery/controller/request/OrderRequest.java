package com.jioo.delivery.controller.request;

public class OrderRequest {
    private Long menuId;
    private Long ordererId;
    private Integer status;


    public OrderRequest(){

    }

    public OrderRequest(Long menuId, Long ordererId, Integer status) {
        this.menuId = menuId;
        this.ordererId = ordererId;
        this.status = status;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getOrdererId() {
        return ordererId;
    }

    public void setOrdererId(Long ordererId) {
        this.ordererId = ordererId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
