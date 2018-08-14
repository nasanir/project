package pers.nasanir.fountain.common.sql.service;

import org.springframework.context.ApplicationContext;
import pers.nasanir.fountain.common.common.anno.PeaceField;
import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.common.constant.CommonConstant;
import pers.nasanir.fountain.common.common.entity.*;
import pers.nasanir.fountain.common.common.mapper.FieldVOMapper;
import pers.nasanir.fountain.common.common.mapper.FuncVOMapper;
import pers.nasanir.fountain.common.common.utils.SpringUtils;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.sql.abst.AbstractSqlBuilder;
import pers.nasanir.fountain.common.sql.constant.DbConstant;
import pers.nasanir.fountain.common.sql.constant.TypeEnum;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


public class MysqlSqlBuilder extends AbstractSqlBuilder {
    private ApplicationContext applicationContext = SpringUtils.getApplicationContext();

    private FuncVOMapper funcVOMapper = applicationContext.getBean(FuncVOMapper.class);
    private FieldVOMapper fieldVOMapper = applicationContext.getBean(FieldVOMapper.class);

    private HashMap<String, Field> fieldMap;

    @Override
    public String getQuerySql(QueryVO vo) {
        String querySql = "";

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
                String whereClause = "";
                if (funcWhereVaild) {
                    funcWhere = funcVO.getFuncWhere() != null ? funcVO.getFuncWhere() : "";
                }
                if (tableName != null && tableName.length() > 0) {
                    querySql = DbConstant.SQL_SELECT.replace(DbConstant.ARG_TABLENAME, tableName);

                    if (where != null && where.length() > 0) {
                        whereClause = where;
                    }

                    if (whereClause.length() > 0 && funcWhere.length() > 0) {
                        whereClause = DbConstant.KEY_AND + funcWhere;
                    } else if (funcWhere.length() > 0) {
                        whereClause = funcWhere;
                    }

                    if (whereClause.length() > 0) {
                        whereClause = DbConstant.KEY_WHERE + whereClause;
                    }

                    querySql = querySql.replace(DbConstant.ARG_WHERE, whereClause);

                    if (groupBy != null && groupBy.length() > 0) {
                        field = groupBy;
                        querySql = querySql.replace(DbConstant.ARG_GROUPBY, DbConstant.KEY_GROUPBY + groupBy);
                    } else {
                        querySql = querySql.replace(DbConstant.ARG_GROUPBY, "");
                    }
                    querySql = querySql.replace(DbConstant.ARG_FIELD, field);

                    if (orderBy != null && orderBy.length() > 0) {
                        querySql = querySql.replace(DbConstant.ARG_ORDERBY, DbConstant.KEY_ORDERBY + orderBy);
                    } else {
                        querySql = querySql.replace(DbConstant.ARG_ORDERBY, "");
                    }
                }
            }
        }
        return querySql;
    }

    @Override
    public String getInsertSql(DataVO vo) {
        String insertSql = "";
        String funcCode = vo.getFunction();
        VOSet<AbstractVO> voSet = vo.getDataSet();
        if (funcCode != null && funcCode.length() > 0) {
            FuncVO funcVO = funcVOMapper.selectByCode(funcCode);
            List<FieldVO> fieldList = fieldVOMapper.selectByCode(funcCode);
            StringBuffer fieldBf = new StringBuffer();
            for (FieldVO fieldVO : fieldList) {
                fieldBf.append(DbConstant.SIGN_COMMA).append(DbConstant.SIGN_SIGQUOT)
                        .append(fieldVO.getFieldCode()).append(DbConstant.SIGN_SIGQUOT);
            }
            if (fieldBf.length() > 0) {
                String fieldAll = fieldBf.toString().substring(CommonConstant.STR_SUBFIRST);
                for (AbstractVO dataVo : voSet.getVoList()) {
                    for (FieldVO fieldVO : fieldList) {
                        Object value=dataVo.getValue(fieldToVo(fieldVO.getFieldCode()));
                    }
                }

            }
        }
        return null;
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

    public String typeDbToJ(Object value,String type){
        if(type.equalsIgnoreCase(TypeEnum.MYSQLBIT.getType())){
            if(String.valueOf())
        }else if(type.equalsIgnoreCase(TypeEnum.MYSQLDATETIME)){

        }else{
            return String.valueOf(value);
        }
    }
}
