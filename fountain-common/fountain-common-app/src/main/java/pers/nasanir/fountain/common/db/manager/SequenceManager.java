package pers.nasanir.fountain.common.db.manager;

import pers.nasanir.fountain.common.common.utils.AppServiceHelper;
import pers.nasanir.fountain.common.db.impl.ISequenceService;

public class SequenceManager {
    public static Long generator(String code){
        ISequenceService sequenceService=(ISequenceService) AppServiceHelper.findBean("sequenceService");
        if(code!=null&&code.length()>0){
            return sequenceService.generator(code);
        }else{
            return sequenceService.generator();
        }
    }

    public static Long generator(){
        ISequenceService sequenceService=(ISequenceService) AppServiceHelper.findBean("sequenceService");
        return sequenceService.generator();
    }
}
