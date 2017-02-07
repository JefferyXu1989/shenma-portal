package com.service.impl;

import com.po.IAttachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mysql.IAttachmentDao;
import com.service.IAttachmentService;

import java.util.List;

@Service("iAttachmentService")
public class IAttachmentServiceImpl implements IAttachmentService {
	
	@Autowired
	private IAttachmentDao iAttachmentDao;
	
	@Override
	public List<IAttachment> getIAttachment()
			throws Exception {
		List<IAttachment> list = iAttachmentDao.getIAttachment();
		return list;
	}
	
	@Override
	public IAttachment getRadio()
			throws Exception {
		IAttachment iAttachment = iAttachmentDao.getRadio().get(0);
		return iAttachment;
	}

}
