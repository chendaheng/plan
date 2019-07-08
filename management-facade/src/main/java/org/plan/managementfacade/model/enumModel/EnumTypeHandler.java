package org.plan.managementfacade.model.enumModel;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes({PlanState.class, PlanType.class})
@MappedJdbcTypes(JdbcType.INTEGER)
public class EnumTypeHandler<E extends Enum<E> & IEnum> extends BaseTypeHandler<E> {
    private Class<E> type;

    public EnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E param, JdbcType jdbcType) throws SQLException {
        int index = param.getIndex();
        preparedStatement.setInt(i, index);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int index = resultSet.getInt(s);
        return convert(index);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int index = resultSet.getInt(i);
        return convert(index);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int index = callableStatement.getInt(i);
        return convert(index);
    }

    private E convert(int index) {
        E[] enumConstants = type.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getIndex() == index) {
                return e;
            }
        }
        return null;
    }
}
