package pers.nasanir.fountain.common.db.util;

import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.reflect.ClassUtils;

import java.io.IOException;
import java.util.HashMap;

public class TableVoUtils {
    private static HashMap<String, ClassInfo> tableVoMap;

    public static HashMap<String, ClassInfo> getTableVoClass() throws IOException {
        if (tableVoMap==null) {
            tableVoMap=new HashMap<String,ClassInfo>();
            ClassUtils.getClassSet();
            HashMap<String, Class<?>> classMap = ClassUtils.getClassMap();
            for (String className : classMap.keySet()) {
                Class<?> clz = classMap.get(className);
                ClassInfo clasInfo = ClassInfo.forClass(clz);
                PeaceTable tableAnno = (PeaceTable) clasInfo.getAnnotation(PeaceTable.class);
                if (tableAnno != null) {
                    tableVoMap.put(className,clasInfo);
                }
            }
        }
        return tableVoMap;
    }
}
