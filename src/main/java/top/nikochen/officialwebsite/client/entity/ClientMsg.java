package top.nikochen.officialwebsite.client.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author niko
 * @since 2018-12-26
 */
@TableName("ClientMsg")
public class ClientMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户真实姓名
     */
    @NotEmpty(message="姓名不能为空")
    private String name;

    /**
     * 手机号
     */
    @Size(min = 11, max=11,message="电话号码必须11位")
    private String phone;

    private String title;

    /**
     * 消息
     */
    @NotEmpty(message="消息不能为空")
    private String message;

    private String ip;

    private String device;

    @TableField("createTime")
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ClientMsg{" +
        "id=" + id +
        ", name=" + name +
        ", phone=" + phone +
        ", title=" + title +
        ", message=" + message +
        ", ip=" + ip +
        ", device=" + device +
        ", createTime=" + createTime +
        "}";
    }
}
