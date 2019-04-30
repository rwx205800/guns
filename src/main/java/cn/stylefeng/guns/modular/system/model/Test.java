package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-30
 */
public class Test extends Model<Test> {

    private static final long serialVersionUID = 1L;

    /**
     * aaa
     */
    @TableId(value = "aaa", type = IdType.AUTO)
    private Integer aaa;
    /**
     * bbb
     */
    private String bbb;


    public Integer getAaa() {
        return aaa;
    }

    public void setAaa(Integer aaa) {
        this.aaa = aaa;
    }

    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }

    @Override
    protected Serializable pkVal() {
        return this.aaa;
    }

    @Override
    public String toString() {
        return "Test{" +
        ", aaa=" + aaa +
        ", bbb=" + bbb +
        "}";
    }
}
