package org.plan.managementfacade.model.enumModel;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(PlanType.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class PlanTypeHandler extends BaseTypeHandler<PlanType> {
    private Class<PlanType> type;

    public PlanTypeHandler (Class<PlanType> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, PlanType planType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, planType.getIndex());
    }

    @Override
    public PlanType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int index = resultSet.getInt(s);
        if (resultSet.wasNull()) {
            return null;
        } else {
            return PlanType.getPlanType(index);
        }
    }

    @Override
    public PlanType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int index = resultSet.getInt(i);
        if (resultSet.wasNull()) {
            return null;
        } else {
            return PlanType.getPlanType(index);
        }
    }

    @Override
    public PlanType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int index = callableStatement.getInt(i);
        if (callableStatement.wasNull()) {
            return null;
        } else {
            return PlanType.getPlanType(index);
        }
    }
}
