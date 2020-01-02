package com.xd.oauth.security;

import com.xd.user.api.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;


/**
 * @author huboxin
 * @title: SecurityUserDetails
 * @projectName bk
 * @description:
 * @date 2019/12/3114:50
 */
@Data
public class SecurityUserDetails extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = -4447489769581735155L;

    private User user;

    public SecurityUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, User user) {
        super(username, password, authorities);
        this.user=user;
    }



    public static void main(String[] args) {
            BCryptPasswordEncoder Encoder = new BCryptPasswordEncoder();
        String app = Encoder.encode("123456");
        System.out.println(app);
    }
}
