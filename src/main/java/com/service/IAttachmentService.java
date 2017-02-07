package com.service;

import com.po.IAttachment;

import java.util.List;

public interface IAttachmentService {
	public List<IAttachment> getIAttachment()throws Exception;
	
	public IAttachment getRadio()throws Exception;
}
