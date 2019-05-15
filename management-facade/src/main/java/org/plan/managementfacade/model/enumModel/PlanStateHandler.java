package org.plan.managementfacade.model.enumModel;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(PlanState.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class PlanStateHandler extends BaseTypeHandler<PlanState> {
    private Class<PlanState> state;

    public PlanStateHandler (Class<PlanState> state) {
        if (state == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.state = state;
    }


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, PlanState planState, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, planState.getIndex());
    }

    @Override
    public PlanState getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int index = resultSet.getInt(s);
        if (resultSet.wasNull()) {
            return null;
        } else {
            return PlanState.getPlanState(index);
        }
    }

    @Override
    public PlanState getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int index = resultSet.getInt(i);
        if (resultSet.wasNull()) {
            return null;
        } else {
            return PlanState.getPlanState(index);
        }
    }

    @Override
    public PlanState getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int index = callableStatement.getInt(i);
        if (callableStatement.wasNull()) {
            return null;
        } else {
            return PlanState.getPlanState(index);
        }
    }
}
