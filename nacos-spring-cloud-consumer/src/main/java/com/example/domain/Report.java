package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

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
public class Report extends Model<Report> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String type;

    private String day;

    private String startTime;

    private String endTime;

    private String useTime;

    private Date createTime;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
