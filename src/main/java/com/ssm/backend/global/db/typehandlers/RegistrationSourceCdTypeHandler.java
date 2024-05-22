package com.ssm.backend.global.db.typehandlers;

import com.ssm.backend.global.db.codes.RegistrationSourceCd;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@MappedTypes(RegistrationSourceCd.class)
public class RegistrationSourceCdTypeHandler extends BaseTypeHandler<RegistrationSourceCd> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, RegistrationSourceCd parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.code());
    }

    @Override
    public RegistrationSourceCd getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        return code == null ? null : RegistrationSourceCd.valueOfCode(code);
    }

    @Override
    public RegistrationSourceCd getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        return code == null ? null : RegistrationSourceCd.valueOfCode(code);
    }

    @Override
    public RegistrationSourceCd getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        return code == null ? null : RegistrationSourceCd.valueOfCode(code);
    }
}
