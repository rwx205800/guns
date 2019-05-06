package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Test;
import cn.stylefeng.guns.modular.system.service.ITestService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * renfei控制器
 *
 * @author fengshuonan
 * @Date 2019-04-30 14:09:58
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    private String PREFIX = "/system/test/";

    @Autowired
    private ITestService testService;

    /**
     * 跳转到renfei首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "test.html";
    }

    /**
     * 跳转到添加renfei
     */
    @RequestMapping("/test_add")
    public String testAdd() {
        return PREFIX + "test_add.html";
    }

    /**
     * 跳转到修改renfei
     */
    @RequestMapping("/test_update/{testId}")
    public String testUpdate(@PathVariable Integer testId, Model model) {
        Test test = testService.selectById(testId);
        model.addAttribute("item",test);
        LogObjectHolder.me().set(test);
        return PREFIX + "test_edit.html";
    }

    /**
     * 获取renfei列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        if (StringUtils.isNullOrEmpty(condition)){
            return testService.selectList(null);
        }
        List<Test>  testList = testService.getTest();
        LogObjectHolder.me().set(testList);
        return testService.selectList(new EntityWrapper<Test>().eq("aaa", condition));
    }

    /**
     * 获取列
     */
    @RequestMapping(value = "/columns")
    @ResponseBody
    public Object columns() {
        List<Map> list = new ArrayList<>();
        HashMap<String,Object> map = new HashMap<>();
        map.put("colalias","税1");
        map.put("colname","aaa");

        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("colalias","税2");
        map1.put("colname","bbb");
        list.add(map);
        list.add(map1);
        return list;
    }

    /**
     * 新增renfei
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Test test) {
        testService.insert(test);
        return SUCCESS_TIP;
    }

    /**
     * 删除renfei
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer testId) {
        testService.deleteById(testId);
        return SUCCESS_TIP;
    }

    /**
     * 修改renfei
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Test test) {
        testService.updateById(test);
        return SUCCESS_TIP;
    }

    /**
     * renfei详情
     */
    @RequestMapping(value = "/detail/{testId}")
    @ResponseBody
    public Object detail(@PathVariable("testId") Integer testId) {
        return testService.selectById(testId);
    }
}
