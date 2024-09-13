package com.it.study.domain.request;

import lombok.Data;


public class JiaoHaoRequest {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JiaoHaoRequest{" +
                "id=" + id +
                '}';
    }
}
