package pers.nasanir.fountain.common.sql.service;


import pers.nasanir.fountain.common.common.anno.PeaceField;
import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.sql.abst.AbstractSqlBuilder;
import pers.nasanir.fountain.common.sql.constant.DbConstant;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MysqlSqlBuilder extends AbstractSqlBuilder {

    private HashMap<String, Field> fieldMap;

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
                            String fieldNameUp=fieldName.toUpperCase(Locale.ROOT);
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
                    createSqlList.add(DbConstant.CREATESQL
                            .replace(DbConstant.ARG_TABLENAME, tableName)
                            .replace(DbConstant.ARG_FIELDNAME, fieldBf.toString()));
                }

            }
        }
        return createSqlList;
    }
}
