package com.ssm.backend.global.db.typehandlers;

import com.ssm.backend.global.db.codes.StudentStatusCd;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@MappedTypes(StudentStatusCd.class)
public class StudentStatusCdTypeHandler extends BaseTypeHandler<StudentStatusCd> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, StudentStatusCd parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.code());
    }

    @Override
    public StudentStatusCd getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        return code == null ? null : StudentStatusCd.valueOfCode(code);
    }

    @Override
    public StudentStatusCd getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        return code == null ? null : StudentStatusCd.valueOfCode(code);
    }

    @Override
    public StudentStatusCd getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        return code == null ? null : StudentStatusCd.valueOfCode(code);
    }
}
