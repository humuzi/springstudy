package learning.com.pojo;

import learning.com.enumeration.SexEnum;
import lombok.Data;

import java.io.Serializable;


/**
 * Create by HuQiuYue on 2019-08-09
 */
@Data
public class Role implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private SexEnum sex;
    private String mobile;
    private String tel;
    private String email;
    private String note;

    public Role(){}

    public Role( String username, String password, SexEnum sex, String mobile, String email, String note) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.mobile = mobile;
        this.email = email;
        this.note = note;
    }
}
