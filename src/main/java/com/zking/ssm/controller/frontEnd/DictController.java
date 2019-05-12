package com.zking.ssm.controller.frontEnd;

import com.zking.ssm.model.Dict;
import com.zking.ssm.service.IDictService;
import com.zking.ssm.utils.PageBean;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/dict")
public class DictController {

    @Autowired
    private IDictService iDictService;


    //拿到所有数据字典
    @RequestMapping("/dictList")
    public ModelAndView dictLists(Dict dict,ModelAndView modelAndView,HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        pageBean.setRows(5);
        dict.setDictValue("groupby");
        List<Dict> dictList = iDictService.listDict(dict, pageBean);
        modelAndView.addObject("dictList",dictList);
        modelAndView.addObject("pageBean",pageBean);

        modelAndView.setViewName("/admin/dict_list");

        return modelAndView;
    }

    @RequestMapping("/dictItem")
    @ResponseBody
    public List<Dict> dictItemList(Dict dict){
        dict = iDictService.selectByPrimaryKey(dict.getTid());
        dict.setDictType(dict.getDictItem());
        dict.setDictItem(null);
        List<Dict> dictList = iDictService.listDict(dict,null);
        return dictList;
    }

    @RequestMapping("/dictStatus")
    public void updateKey(String id,String status,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Dict user = new Dict();
        user.setTid(Integer.parseInt(id));
        user.setDictIsEditable( Integer.parseInt(status));
        boolean b = iDictService.updateByPrimaryKeySelective(user)>0?true:false;
        if(b) out.print("1");else out.print("0");
    }

    @RequestMapping("/updateDict")
    public void updateDict(Dict dict,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Dict d = iDictService.selectByPrimaryKey(dict.getTid());
        boolean b = iDictService.updateByPrimaryKeySelective(dict)>0?true:false;
        if (b) {
            dict.setDictType(d.getDictItem());
            System.out.println(dict);
            iDictService.updatedictItem(dict);
            out.print("1");
        }else{
            out.print("0");
        }
    }

    @RequestMapping("/addDict")
    @ResponseBody
    public List<Dict> addDict(String dictItem,String tid){
        Dict d = iDictService.selectByPrimaryKey(Integer.parseInt(tid));
        d.setDictType(d.getDictItem());
        d.setDictItem(dictItem);
        int countDict = iDictService.countDict(d);
        d.setDictValue(countDict+1+"");
        d.setTid(null);
        boolean b = iDictService.insertSelective(d)>0?true:false;
        if(b){
            List<Dict> list = new ArrayList<Dict>();
            d = iDictService.selectByPrimaryKey(d.getTid());
            list.add(d);
            return list;
        }else{
            return null;
        }
    }

    @RequestMapping("/dictDel")
    public void dictDel(String id,HttpServletResponse response)throws IOException{
        PrintWriter out = response.getWriter();
        int toid = 0;
        boolean b = false;
        try {
            toid = Integer.parseInt(id);
            b = iDictService.deleteByPrimaryKey(toid)>0?true:false;
            if(b) out.print("1");else out.print("0");
        }catch (Exception e){
            //System.out.println("转型异常----执行以下方法");
            String[] split = id.split(",");
            for (int i=0;i<split.length;i++){
                b = iDictService.deleteByPrimaryKey(Integer.parseInt(split[i]))>0?true:false;
            }
            if(b) out.print("1");else out.print("0");
        }

    }

    @RequestMapping("/updateValue")
    public void updateValue(Dict dict,HttpServletResponse response) throws IOException {
        System.out.println("dict"+dict);
        PrintWriter out = response.getWriter();
        boolean b = iDictService.updateByPrimaryKeySelective(dict)>0?true:false;
        if (b) {
            out.print("1");
        }else{
            out.print("0");
        }
    }

    @RequestMapping("/addDictType")
    public void addDictType(String  item,HttpServletResponse response) throws IOException{
        Dict dict = new Dict();
        dict.setDictItem(item);
        PrintWriter out = response.getWriter();
        dict.setDictType("字典类别");
        int countDict = iDictService.countDict(dict);
        dict.setDictValue(countDict+1+"");
        boolean b = iDictService.insertSelective(dict)>0?true:false;

        if(b) out.print("1");else out.print("0");

    }

}
