package cn.xhjc.model.bo;

import cn.xhjc.model.User;

import java.util.Set;

/**
 * 扩展用户类
 * @author xhjc
 * @date 2018/8/30
 * @since 1.0.0
 */
public class UserBo extends User{
    /**
     * 用户所属的角色信息
     */
    private Set<RoleBo> roles;

    public Set<RoleBo> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleBo> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserBo{" +
                "roles=" + roles +
                '}';
    }
}
