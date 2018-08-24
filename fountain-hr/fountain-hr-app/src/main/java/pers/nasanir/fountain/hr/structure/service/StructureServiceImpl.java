package pers.nasanir.fountain.hr.structure.service;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.common.entity.*;
import pers.nasanir.fountain.common.common.utils.CommonUtils;
import pers.nasanir.fountain.common.db.manager.SequenceManager;
import pers.nasanir.fountain.hr.structure.entity.StructureVO;
import pers.nasanir.fountain.hr.structure.itf.IStructureService;
import pers.nasanir.fountain.hr.structure.mapper.StructureVOMapper;

import java.util.ArrayList;
import java.util.List;
@Service("structureService")
public class StructureServiceImpl implements IStructureService {
    @Autowired
    private StructureVOMapper structureVOMapper;

    public ResultVO showList(ParamterVO vo){
        String jsonArrayStr=vo.getDataBody();

        int pageNum=vo.getPageNo();
        int pageSize=vo.getLimit();
        Page page = PageHelper.startPage(pageNum, pageSize, true);
        List<StructureVO> resultList= structureVOMapper.selectAll();

        ResultVO resultVO=new ResultVO();
        CommonUtils.transParamToResult(vo,resultVO);
        resultVO.setDataList(resultList);
        resultVO.setStatus("ok");
        resultVO.setMessage("success");
        return resultVO;
    }

    public ResultVO add(ParamterVO vo){
        int pageNum=vo.getPageNo();
        int pageSize=vo.getLimit();
        Page page = PageHelper.startPage(pageNum, pageSize, true);

        List<StructureVO> ResultList= structureVOMapper.selectAll();
        List<StructureVO> addResultList=new ArrayList<StructureVO>();

        StructureVO newVo=new StructureVO();
        newVo.setStructureId(SequenceManager.generator());
        addResultList.add(newVo);
        addResultList.addAll(ResultList);

        ResultVO resultVO=new ResultVO();
        CommonUtils.transParamToResult(vo,resultVO);
        resultVO.setDataList(addResultList);
        resultVO.setStatus("ok");
        resultVO.setMessage("success");
        return resultVO;
    }

    public ResultVO save(ParamterVO vo) {

        String jsonArrayStr=vo.getDataBody();

        List<StructureVO> studentList = JSONArray.parseArray(jsonArrayStr, StructureVO.class);
        for(StructureVO structureVO:studentList){
            Long structureId=structureVO.getStructureId();
            if(structureVOMapper.selectByPrimaryKey(structureId)!=null){
                structureVOMapper.updateByPrimaryKey(structureVO);
            }else{
                structureVOMapper.insert(structureVO);
            }
        }

        int pageNum=vo.getPageNo();
        int pageSize=vo.getLimit();
        Page page = PageHelper.startPage(pageNum, pageSize, true);

        List<StructureVO> resultList= structureVOMapper.selectAll();

        ResultVO<StructureVO> resultVO=new ResultVO();
        CommonUtils.transParamToResult(vo,resultVO);
        resultVO.setDataList(resultList);
        resultVO.setStatus("ok");
        resultVO.setMessage("success");
        return resultVO;
    }


}
