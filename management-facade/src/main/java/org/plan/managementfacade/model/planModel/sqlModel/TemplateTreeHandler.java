package org.plan.managementfacade.model.planModel.sqlModel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(TemplateTree.class)
@MappedJdbcTypes(JdbcType.LONGVARCHAR)
public class TemplateTreeHandler extends BaseTypeHandler<TemplateTree> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, TemplateTree templateTree, JdbcType jdbcType) throws SQLException {
        String jsonTree = JSON.toJSONString(templateTree);
        ps.setString(i, jsonTree);
    }

    @Override
    public TemplateTree getNullableResult(ResultSet rs, String s) throws SQLException {
        String jsonTree = rs.getString(s);
        return JSONObject.parseObject(jsonTree, TemplateTree.class);
    }

    @Override
    public TemplateTree getNullableResult(ResultSet rs, int i) throws SQLException {
        String jsonTree = rs.getString(i);
        return JSONObject.parseObject(jsonTree, TemplateTree.class);
    }

    @Override
    public TemplateTree getNullableResult(CallableStatement cs, int i) throws SQLException {
        String jsonTree = cs.getString(i);
        return JSONObject.parseObject(jsonTree, TemplateTree.class);
    }
}
