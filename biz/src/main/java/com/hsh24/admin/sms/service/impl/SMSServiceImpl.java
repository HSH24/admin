package com.hsh24.admin.sms.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hsh24.admin.api.sms.ISMSService;
import com.hsh24.admin.framework.bo.BooleanResult;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 
 * @author JiakunXu
 * 
 */
@Service
public class SMSServiceImpl implements ISMSService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(SMSServiceImpl.class);

	@Value("${alidayu.server.url}")
	private String serverUrl;

	@Value("${alidayu.app.key}")
	private String appKey;

	@Value("${alidayu.app.secret}")
	private String appSecret;

	@Override
	public BooleanResult send(String signName, String templateCode, String param, String recNum, String extend) {
		BooleanResult result = new BooleanResult();
		result.setResult(false);

		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setSmsType("normal");

		if (StringUtils.isBlank(signName)) {
			result.setCode("短信签名不能为空.");
			return result;
		}
		req.setSmsFreeSignName(signName.trim());

		if (StringUtils.isBlank(templateCode)) {
			result.setCode("短信模板不能为空.");
			return result;
		}
		req.setSmsTemplateCode(templateCode.trim());

		req.setSmsParamString(param);

		if (StringUtils.isBlank(recNum)) {
			result.setCode("短信接收号码不能为空.");
			return result;
		}
		req.setRecNum(recNum);

		req.setExtend(extend);

		TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);

		AlibabaAliqinFcSmsNumSendResponse rsp = null;

		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			logger.error("signName:" + signName + "templateCode:" + templateCode + "param" + param + "recNum:" + recNum
				+ "extend:" + extend, e);

			result.setCode("接口调用失败.");
			return result;
		}

		if (StringUtils.isNotEmpty(rsp.getErrorCode())) {
			result.setCode(rsp.getSubMsg());
			return result;
		}

		result.setResult(true);
		return result;
	}

}
