package club.banyuan.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import javax.validation.constraints.NotEmpty;

public class UmsAdminCreateParam {
    @ApiModelProperty(value = "用户名",required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;
    @ApiModelProperty(value = "头像",required = true)
    private String icon;
    @ApiModelProperty(value = "邮箱",required = true)
    private String email;
    @ApiModelProperty(value = "昵称",required = true)
    private String nickName;
    @ApiModelProperty(value = "备注",required = true)
    private String note;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
