package learning.com.pojo;

import com.sun.tools.corba.se.idl.constExpr.Times;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Create by HuQiuYue on 2019-11-18
 */
@Data
public class UserRedPacket implements Serializable {
    private Long id;
    private Long redPacketId;
    private Long userId;
    private Double amount;
    private Timestamp grabTime;
    private String note;

    private static final long serialVersionUID = - 5617482065991830143L;
}
