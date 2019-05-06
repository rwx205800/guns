package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Test;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-30
 */
public interface TestMapper extends BaseMapper<Test> {


    @Select("select * from test limit 1")
    List<Test> getTest();


}
