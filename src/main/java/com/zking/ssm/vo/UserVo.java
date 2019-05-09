package com.zking.ssm.vo;

import com.zking.ssm.model.User;
import lombok.ToString;

@ToString
public class UserVo {

    private Integer start;

    private Integer end;

    private User user;

    public UserVo(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
