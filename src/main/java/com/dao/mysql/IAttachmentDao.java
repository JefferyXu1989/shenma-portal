package com.dao.mysql;


import com.po.IAttachment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IAttachmentDao extends BaseDao<IAttachment>{

	public List<IAttachment> getIAttachment() {
		String sql = "SELECT COUNT(1)  AS total_num," +
				"  t1.PA_CITY     AS city," +
				"  t1.PA_PROVINCE AS province" +
				" FROM M05_CLIENT_INSTALLMENT t" +
				" LEFT JOIN M05_DEALER_INFO t1" +
				" ON t.PA_MERCHANT_NO = t1.PA_MERCHANT_NO" +
				" GROUP BY t1.PA_PROVINCE," +
				"  t1.PA_CITY";
		return super.queryForList(sql);
	}
	
	public List<IAttachment> getRadio() {
		String sql = "SELECT COUNT(1)  AS total_num," +
				"  t1.PA_CITY     AS city," +
				"  t1.PA_PROVINCE AS province" +
				" FROM M05_CLIENT_INSTALLMENT t" +
				" LEFT JOIN M05_DEALER_INFO t1" +
				" ON t.PA_MERCHANT_NO = t1.PA_MERCHANT_NO" +
				" GROUP BY t1.PA_PROVINCE," +
				"  t1.PA_CITY";
		return super.queryForList(sql);
	}
	
}
