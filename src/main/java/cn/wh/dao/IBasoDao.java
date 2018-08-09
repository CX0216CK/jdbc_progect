package cn.wh.dao;

import cn.wh.util.PageUtil;

import java.io.Serializable;
import java.util.List;

public interface IBasoDao<T> {
    int add(T t);
    int deleteByCondition(Serializable id);
    int update(T t);
    T findByCondition(Serializable id);
    List<T> findAll();
    int findRownum();
    List<T>  findAllByPage(PageUtil util, Object ...params);
}
