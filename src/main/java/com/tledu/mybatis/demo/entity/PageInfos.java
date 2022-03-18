package com.tledu.mybatis.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PageInfos<T> {
    @Getter
    @Setter
    private Integer pageSize;
    @Getter
    @Setter
    private Integer currentPage;
    @Getter
    @Setter
    private Integer total;
    @Getter
    @Setter
    private List<T> list;
    private Integer start;

    public Integer getStart() {
        if(this.currentPage==null||this.pageSize==null){
            return null;
        }
        return (currentPage-1)*pageSize;
    }

    public PageInfos() {
        this.pageSize = 3;
        this.currentPage = 1;
    }

    public PageInfos(int pageSize, int currentPage) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }
}
