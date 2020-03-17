package learning.com.mybatis.typehandler;

import learning.com.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

/**
 * Create by HuQiuYue on 2019-08-12
 */
public class SexEnumTypeHandler extends BaseTypeHandler<SexEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getId());
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return SexEnum.getSexById(resultSet.getInt(columnName));
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return SexEnum.getSexById(resultSet.getInt(columnIndex));
    }

    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return SexEnum.getSexById(callableStatement.getInt(columnIndex));
    }
}
