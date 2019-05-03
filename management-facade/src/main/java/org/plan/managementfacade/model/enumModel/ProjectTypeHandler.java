package org.plan.managementfacade.model.enumModel;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(ProjectType.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class ProjectTypeHandler extends BaseTypeHandler<ProjectType> {
    private Class<ProjectType> type;

    public ProjectTypeHandler (Class<ProjectType> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        } else {
            this.type = type;
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, ProjectType projectType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, projectType.getIndex());
    }

    @Override
    public ProjectType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int index = resultSet.getInt(s);
        if (resultSet.wasNull()) {
            return null;
        } else {
            return ProjectType.getProjectType(index);
        }
    }

    @Override
    public ProjectType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int index = resultSet.getInt(i);
        if (resultSet.wasNull()) {
            return null;
        } else {
            return ProjectType.getProjectType(index);
        }
    }

    @Override
    public ProjectType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int index = callableStatement.getInt(i);
        if (callableStatement.wasNull()) {
            return null;
        } else {
            return ProjectType.getProjectType(index);
        }
    }
}
