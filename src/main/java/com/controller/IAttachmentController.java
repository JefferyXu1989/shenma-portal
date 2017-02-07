package com.controller;


import com.po.IAttachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.common.constant.ResultModel;
import com.service.IAttachmentService;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller("iAttachmentController")
@RequestMapping(value = "/login")
public class IAttachmentController extends BaseController {
	
	@Autowired
	private IAttachmentService iAttachmentService;

	/*@RequestMapping(value = "/getIAttachment",method = RequestMethod.POST)
	public String getIAttachment() throws Exception {
		ResultModel resultModel = new ResultModel();

		resultModel.setResultCode("0000");
		resultModel.setMessage("操作成功");
		List<IAttachment> list = iAttachmentService.getIAttachment();
		resultModel.setData(list);
		return "iattachment";
		return new ResponseEntity<String>(JSON.toJSONString(resultModel),
				headers, HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/getIAttachment",method = RequestMethod.GET)
	public String getIAttachment(Model model) throws Exception {
		List<IAttachment> list = iAttachmentService.getIAttachment();
		JSONArray jsonArray = new JSONArray();
        for(IAttachment a : list){
            JSONObject jo = new JSONObject();
            jo.put("total_num", a.getTotal_num());
            jo.put("province", a.getProvince());
            jo.put("city", a.getCity());
            jsonArray.add(jo);
        }
		
		model.addAttribute("list", jsonArray);
//		return "iattachment";
		return "radio";
		/*return new ResponseEntity<String>(JSON.toJSONString(resultModel),
				headers, HttpStatus.OK);*/
	}
	
	@RequestMapping(value = "/getRadio",method = RequestMethod.GET)
	public String getRadio(Model model) throws Exception {
		IAttachment iAttachment = iAttachmentService.getRadio();
		model.addAttribute("iAttachment", iAttachment);
//		model.put("abc", "abc");
		return "map";
		/*return new ResponseEntity<String>(JSON.toJSONString(resultModel),
				headers, HttpStatus.OK);*/
	}

	@RequestMapping(value = "/demo",method = RequestMethod.GET)
	public String toDemo(Model model) throws Exception {
		return "demo";
	}
	
	@RequestMapping(value = "/getNewMap",method = RequestMethod.GET)
	public String getNewMap(Model model) throws Exception {
		List<IAttachment> list = iAttachmentService.getIAttachment();
		JSONArray jsonArray = new JSONArray();
        for(IAttachment a : list){
            JSONObject jo = new JSONObject();
            jo.put("total_num", a.getTotal_num());
            jo.put("province", a.getProvince());
            jo.put("city", a.getCity());
            jsonArray.add(jo);
        }
		
		model.addAttribute("list", jsonArray);
//		return "iattachment";
		return "newMap";
		/*return new ResponseEntity<String>(JSON.toJSONString(resultModel),
				headers, HttpStatus.OK);*/
	}
	
}
