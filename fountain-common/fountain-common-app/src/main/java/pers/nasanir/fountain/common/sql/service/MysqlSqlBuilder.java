package pers.nasanir.fountain.common.sql.service;


import org.springframework.beans.factory.annotation.Autowired;
import pers.nasanir.fountain.common.common.anno.PeaceField;
import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.FuncVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.common.mapper.FuncVOMapper;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.sql.abst.AbstractSqlBuilder;
import pers.nasanir.fountain.common.sql.constant.DbConstant;
import pers.nasanir.fountain.common.sql.entity.SqlVO;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MysqlSqlBuilder extends AbstractSqlBuilder {
    @Autowired
    FuncVOMapper funcVOMapper;


    private HashMap<String, Field> fieldMap;

    @Override
    public String getQuerySql(QueryVO vo) {
        String QuerySql = "";

        if (vo != null) {
            String funcCode = vo.getFuncCode();
            String where = vo.getWhere();
            String groupBy = vo.getGroupBy();
            String orderBy = vo.getOrderBy();
            boolean funcWhereVaild = vo.getFuncWhereVaild();
            String field = "*";

            if (funcCode != null && funcCode.length() > 0) {
                FuncVO funcVO = funcVOMapper.selectByCode(funcCode);
                String tableName = funcVO.getTableName();
                String funcWhere = "";
                String whereClause="";
                if (funcWhereVaild) {
                    funcWhere = funcVO.getFuncWhere()!=null?funcVO.getFuncWhere():"";
                }
                if (tableName != null && tableName.length() > 0) {
                    QuerySql = DbConstant.SQL_SELECT.replace(DbConstant.ARG_TABLENAME, tableName);

                    if(where!=null&&where.length()>0){
                        whereClause=where;
                    }

                    if(whereClause.length()>0&&funcWhere.length()>0){
                        whereClause=DbConstant.KEY_AND+funcWhere;
                    }else if(funcWhere.length()>0){
                        whereClause=funcWhere;
                    }

                    if(whereClause.length()>0){
                        whereClause=DbConstant.KEY_WHERE+whereClause;
                    }

                    QuerySql=QuerySql.replace(DbConstant.ARG_WHERE,whereClause);

                    if (groupBy != null && groupBy.length() > 0) {
                        field = groupBy;
                        QuerySql = QuerySql.replace(DbConstant.ARG_GROUPBY, DbConstant.KEY_GROUPBY + groupBy);
                    }
                    QuerySql = QuerySql.replace(DbConstant.ARG_FIELD, field);

                    if (orderBy != null && orderBy.length() > 0) {
                        QuerySql = QuerySql.replace(DbConstant.ARG_ORDERBY, DbConstant.KEY_ORDERBY + orderBy);
                    }
                }
            }
        }
        return QuerySql;
    }

    /**
     * 创建数据库脚本
     *
     * @param classInfoMap
     * @return
     */
    @Override
    public List<String> getCreateSql(HashMap<String, ClassInfo> classInfoMap) {
        List<String> createSqlList = new ArrayList<String>();
        //遍历vomap
        for (String className : classInfoMap.keySet()) {
            ClassInfo classInfo = classInfoMap.get(className);
            PeaceTable tableAnno = (PeaceTable) classInfo.getAnnotation(PeaceTable.class);
            //如果有peacetable注解则为实体类
            if (tableAnno != null) {
                //取得实体表名
                String tableName = tableAnno.name().toUpperCase(Locale.ROOT);

                StringBuffer fieldBf = new StringBuffer();
                //取得字段map
                HashMap<String, Field> fieldMap = classInfo.getFieldMap();
                for (String fieldName : fieldMap.keySet()) {
                    Field field = fieldMap.get(fieldName);
                    Annotation peaceField = field.getAnnotation(PeaceField.class);
                    //如果有注解则为物理表字段
                    if (peaceField != null) {
                        if (((PeaceField) peaceField).isVaild()) {
                            //字段长度
                            String fieldLenght = ((PeaceField) peaceField).lenght();
                            //字段类型
                            String fieldType = ((PeaceField) peaceField).type().toUpperCase(Locale.ROOT);
                            String fieldNameUp = fieldName.toUpperCase(Locale.ROOT);
                            fieldBf.append(fieldNameUp)
                                    .append(DbConstant.SIGN_BLANK)
                                    .append(fieldType)
                                    .append(DbConstant.SIGN_LEFT_BRACKET)
                                    .append(fieldLenght)
                                    .append(DbConstant.SIGN_RIGHT_BRACKET);
                            //如果字段为主键
                            if (((PeaceField) peaceField).isPk()) {
                                fieldBf.append(DbConstant.SIGN_BLANK)
                                        .append(DbConstant.KEY_NOTNUL)
                                        .append(DbConstant.SIGN_BLANK)
                                        .append(DbConstant.KEY_PRIMARY);
                            }

                            fieldBf.append(DbConstant.SIGN_COMMA);
                        }
                    }
                }

                if (fieldBf.length() > 0) {
                    fieldBf.deleteCharAt(fieldBf.length() - 1);
                    createSqlList.add(DbConstant.SQL_CREATE
                            .replace(DbConstant.ARG_TABLENAME, tableName)
                            .replace(DbConstant.ARG_FIELDNAME, fieldBf.toString()));
                }

            }
        }
        return createSqlList;
    }
}
