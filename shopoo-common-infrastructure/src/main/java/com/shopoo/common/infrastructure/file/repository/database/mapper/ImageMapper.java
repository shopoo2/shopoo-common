package com.shopoo.common.infrastructure.file.repository.database.mapper;

import java.util.Set;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shopoo.common.infrastructure.file.repository.database.dataobject.Image;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Package com.szmengran.aliyun.mapper
 * @Description: 图片信息持久化
 * @date Feb 21, 2019 7:02:02 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Mapper
public interface ImageMapper extends BaseMapper<Image> {

    @Select("select * from image where fileid=#{fileid}")
    Image findImageById(String fileid) throws Exception;
    
    @Insert({
        "<script>",
        "insert into image(fileid, userid, orgname, suffix, filesize, validstatus, createstamp) values ",
        "<foreach collection='imageSet' item='item' index='index' separator=','>",
        "(#{item.fileid}, #{item.userid}, #{item.orgname}, #{item.suffix}, #{item.filesize}, #{item.validstatus}, #{item.createstamp})",
        "</foreach>",
        "</script>"
    })
    int insertSet(@Param(value="imageSet") Set<Image> imageSet) throws Exception;
}
