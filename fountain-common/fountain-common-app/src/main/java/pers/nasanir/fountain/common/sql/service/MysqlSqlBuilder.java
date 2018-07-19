package pers.nasanir.fountain.common.sql.service;


import pers.nasanir.fountain.common.common.anno.PeaceField;
import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.sql.abst.AbstractSqlBuilder;
import pers.nasanir.fountain.common.sql.constant.DbConstant;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

public class MysqlSqlBuilder extends AbstractSqlBuilder {

    private HashMap<String, Field> fieldMap;

    /**
     * 创建数据库脚本
     * @param classInfoMap
     * @return
     */
    @Override
    public List<String> getCreateSql(HashMap<String, ClassInfo> classInfoMap) {
        StringBuffer fieldBf=new StringBuffer();

        //遍历vomap
        for (String className:classInfoMap.keySet()){
            ClassInfo classInfo=classInfoMap.get(className);
            PeaceTable tableAnno = (PeaceTable) classInfo.getAnnotation(PeaceTable.class);
            //如果有peacetable注解则为实体类
            if(tableAnno!=null){
                //取得实体表名
                String tableName=tableAnno.name();
                //取得字段map
                HashMap<String,Field> fieldMap=classInfo.getFieldMap();
                for(String fieldName:fieldMap.keySet()){
                    Field field=fieldMap.get(fieldName);
                    Annotation peaceField=field.getAnnotation(PeaceField.class);
                    //如果有注解则为物理表字段
                    if(peaceField!=null){
                        if(((PeaceField) peaceField).isVaild()){
                            fieldBf.append(field.getName());

                        }
                    }
                }
                StringBuffer createSqlBf=new StringBuffer();
                createSqlBf.append(DbConstant.CREATESQL.replace(DbConstant.ARGTABLENAME,tableName));

            }
        }
        return null;
    }
}
