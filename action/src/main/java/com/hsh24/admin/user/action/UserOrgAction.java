package com.hsh24.admin.user.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hsh24.admin.api.org.bo.Org;
import com.hsh24.admin.api.user.IUserOrgService;
import com.hsh24.admin.api.user.bo.User;
import com.hsh24.admin.framework.action.BaseAction;

/**
 * 
 * @author JiakunXu
 * 
 */
@Controller
@Scope("request")
public class UserOrgAction extends BaseAction {

	private static final long serialVersionUID = 7564591974795037550L;

	@Resource
	private IUserOrgService userOrgService;

	private List<Org> orgList;

	/**
	 * 
	 * @return
	 */
	public String index() {
		User user = this.getUser();

		if (user == null) {
			return "org";
		}

		// 判断是否关联多个店铺
		orgList = userOrgService.getOrgList(user.getPassport());

		if (orgList == null || orgList.isEmpty()) {
			return "org";
		}

		if (orgList.size() == 1) {
			Org org = orgList.get(0);

			HttpSession session = this.getSession();
			session.setAttribute("ACEGI_SECURITY_LAST_ORG", org);

			return SUCCESS;
		}

		return "org";
	}

	public List<Org> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<Org> orgList) {
		this.orgList = orgList;
	}

}
