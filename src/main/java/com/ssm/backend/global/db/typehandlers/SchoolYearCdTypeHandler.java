package com.ssm.backend.global.db.typehandlers;

import com.ssm.backend.global.db.codes.SchoolYearCd;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@MappedTypes(SchoolYearCd.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class SchoolYearCdTypeHandler extends BaseTypeHandler<SchoolYearCd> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SchoolYearCd parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.code());
    }

    @Override
    public SchoolYearCd getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        return code == null ? null : SchoolYearCd.valueOfCode(code);
    }

    @Override
    public SchoolYearCd getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        return code == null ? null : SchoolYearCd.valueOfCode(code);
    }

    @Override
    public SchoolYearCd getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        return code == null ? null : SchoolYearCd.valueOfCode(code);
    }
}
