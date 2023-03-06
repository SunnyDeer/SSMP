package com.qin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qin.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book>{


}
