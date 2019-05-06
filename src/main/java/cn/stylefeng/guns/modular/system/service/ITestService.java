package cn.stylefeng.guns.modular.system.service;

import cn.stylefeng.guns.modular.system.model.Test;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-30
 */
public interface ITestService extends IService<Test> {
    List<Test> getTest();
}
