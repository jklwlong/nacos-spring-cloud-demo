package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuwl
 * @since 2022-12-05
 */
@Getter
@Setter
public class Stock extends Model<Stock> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer num;

    private Date createTime;

    private Date updateTime;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
