package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.Test;
import cn.stylefeng.guns.modular.system.dao.TestMapper;
import cn.stylefeng.guns.modular.system.service.ITestService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-30
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<Test> getTest() {
        return testMapper.getTest();
    }
}
