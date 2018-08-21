package pers.nasanir.fountain.common.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppServiceHelper{
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(AppServiceHelper.applicationContext==null){
            AppServiceHelper.applicationContext=applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object findBean(String name){
        return applicationContext.getBean(name);
    }
}
