/*     */ package com.hundsun.eclp.web.action.role;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.auth.Authority;
/*     */ import com.hundsun.eclp.biz.domain.role.RoleAuthority;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.service.AuthorityService;
/*     */ import com.hundsun.eclp.biz.service.RoleService;
/*     */ import com.hundsun.eclp.biz.service.ToolService;
/*     */ import com.hundsun.eclp.biz.service.common.RemoteService;
/*     */ import com.hundsun.eclp.biz.service.role.RoleAuthorityService;
/*     */ import com.hundsun.eclp.biz.service.sys.WorkLogService;
/*     */ import com.hundsun.eclp.common.BaseAction;
/*     */ import com.hundsun.eclp.common.Tree;
/*     */ import com.hundsun.eclp.common.TreeMaker;
/*     */ import com.hundsun.eclp.enums.EnumAuthorityType;
/*     */ import com.hundsun.eclp.enums.EnumSubSystemStatus;
/*     */ import com.hundsun.eclp.security.AdminAccess;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/role"})
/*     */ public class AssignAuthAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   AuthorityService authorityService;
/*     */ 
/*     */   @Autowired
/*     */   RoleAuthorityService roleAuthorityService;
/*     */ 
/*     */   @Autowired
/*     */   RoleService roleService;
/*     */ 
/*     */   @Autowired
/*     */   RemoteService RemoteService;
/*     */ 
/*     */   @Autowired
/*     */   ToolService toolService;
/*     */ 
/*     */   @Autowired
/*     */   private WorkLogService workLogService;
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_AUTHORIZATION})
/*     */   @RequestMapping(value={"/assign_auth"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void index(@RequestParam(value="roleId", required=false) Long roleId, Model model)
/*     */   {
/*  56 */     model.addAttribute("roleId", roleId);
/*  57 */     model.addAttribute("role", this.roleService.getRoleById(roleId));
/*     */   }
/*  61 */   @RequestMapping({"/tree"})
/*     */   public String tree(@RequestParam(value="roleId", required=false) Long roleId, ModelMap model, UserAgent user) { List list = new ArrayList();
/*     */ 
/*  63 */     List<Authority> listAuthority = this.authorityService.getCanAssginAuthList();
/*     */ 
/*  65 */     List<RoleAuthority> roleAuthList = this.roleAuthorityService.selectRoleAuthorityByRoleId(roleId);
/*     */ 
/*  67 */     boolean isChecked = false;
/*  68 */     boolean isParent = false;
/*  69 */     for (Authority authority : listAuthority) {
/*  70 */       isParent = false;
/*  71 */       isChecked = false;
/*     */ 
/*  73 */       if ("Y".equalsIgnoreCase(authority.getIsDeleted())) {
/*     */         continue;
/*     */       }
/*  76 */       if ((roleAuthList != null) && (roleAuthList.size() > 0)) {
/*  77 */         for (RoleAuthority roleAuth : roleAuthList)
/*     */         {
/*  79 */           if (roleAuth.getAuthId().longValue() == authority.getId().longValue()) {
/*  80 */             isChecked = true;
/*  81 */             break;
/*     */           }
/*     */         }
/*     */       }
/*  85 */       for (Authority auth : listAuthority) {
/*  86 */         if (authority.getId().longValue() == auth.getParentId().longValue())
/*  87 */           isParent = true;
/*     */       }
/*  89 */       Tree tree = new Tree(authority.getId().toString(), authority.getParentId().toString(), authority.getName(), authority.getType().toString(), authority.getSort().intValue(), false, isParent);
/*     */ 
/*  97 */       tree.setChecked(isChecked);
/*  98 */       list.add(tree);
/*     */     }
/* 100 */     TreeMaker treeMaker = new TreeMaker(list, "-1");
/* 101 */     model.addAttribute("subSysList", treeMaker.toStringScript());
/*     */ 
/* 104 */     return "role/tree"; }
/*     */ 
/*     */   public void init(Model model) {
/* 107 */     List authorityList = new ArrayList();
/* 108 */     for (EnumAuthorityType enumAuthorityType : EnumAuthorityType.values()) {
/* 109 */       authorityList.add(enumAuthorityType);
/*     */     }
/* 111 */     model.addAttribute("authorityTypeList", authorityList); } 
/* 115 */   @RequestMapping({"/treeContent"})
/*     */   @ResponseBody
/*     */   public List<Tree> treeContent(String pId, String id) { this._log.info("in AssignAuthAction.treeContent!!!  pId = " + pId + "    id = " + id);
/* 116 */     List list = new ArrayList();
/* 117 */     List<Authority> listAuthority = this.authorityService.getListBySubSystemParent(Long.valueOf(Long.parseLong(pId)), Long.valueOf(Long.parseLong(id)), Short.valueOf((short)EnumSubSystemStatus.ENABLE.getCode()));
/* 118 */     for (Authority authority : listAuthority) {
/* 119 */       Tree tree = new Tree(authority.getId().toString(), authority.getParentId().longValue() != -1L ? authority.getParentId().toString() : authority.getSubSystemId(), authority.getName(), authority.getType().toString(), authority.getSort().intValue(), false);
/*     */ 
/* 125 */       list.add(tree);
/*     */     }
/* 127 */     return list; } 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_AUTHORIZATION})
/*     */   @RequestMapping({"/assign_auth_body"})
/*     */   public void queryRoleAuth(@RequestParam("roleId") Long roleId, @RequestParam(value="authId", required=false) Long authId, Model model) {
/* 133 */     if (roleId != null)
/*     */     {
/* 135 */       Authority auth = new Authority();
/* 136 */       auth.setRoleId(roleId);
/* 137 */       if (authId != null)
/* 138 */         auth.setParentId(authId);
/*     */       else {
/* 140 */         auth.setParentId(Long.valueOf("-1"));
/*     */       }
/* 142 */       List authList = this.authorityService.selectAuthority(auth);
/* 143 */       if (authList != null)
/*     */       {
/* 145 */         init(model);
/*     */ 
/* 147 */         model.addAttribute("authList", authList);
/*     */       }
/* 149 */       model.addAttribute("roleId", roleId);
/*     */     }
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_AUTHORIZATION})
/*     */   @RequestMapping({"/del_assign_auth"})
/*     */   public String delAssignAuth(@RequestParam("roleId") Long roleId, HttpServletRequest request, Model model) {
/* 157 */     String[] authIds = request.getParameterValues("authIds");
/* 158 */     if (authIds != null) {
/* 159 */       List list = new ArrayList();
/* 160 */       RoleAuthority roleAuth = new RoleAuthority();
/* 161 */       for (String authId : authIds) {
/* 162 */         roleAuth = new RoleAuthority();
/* 163 */         roleAuth.setAuthId(Long.valueOf(authId));
/* 164 */         roleAuth.setRoleId(roleId);
/* 165 */         list.add(roleAuth);
/*     */       }
/*     */ 
/* 168 */       if (list.size() > 0) {
/* 169 */         this.roleAuthorityService.deleteRoleAuthority(list);
/*     */       }
/*     */       try
/*     */       {
/* 173 */         this.toolService.synchronizeUpdateTime(null);
/*     */       } catch (Exception e) {
/* 175 */         this._log.error("toolService.synchronizeUpdateTime", e);
/*     */       }
/* 177 */       model.addAttribute("delMsg", "Y");
/*     */     }
/*     */ 
/* 180 */     return "redirect:/role/assign_auth.htm?roleId=" + roleId; } 
/* 185 */   @RequestMapping({"/isParent"})
/*     */   @ResponseBody
/*     */   public boolean isParent(String subSystemId, String id) { this._log.info("in AssignAuthAction.isParent!!!  subSystemId = " + subSystemId + "    id = " + id);
/* 186 */     if ((null == id) || (id.equals(""))) {
/* 187 */       return false;
/*     */     }
/*     */ 
/* 190 */     return this.authorityService.getCountBySubSystemParent(Long.valueOf(Long.parseLong(subSystemId)), Long.valueOf(Long.parseLong(id)), Short.valueOf((short)EnumSubSystemStatus.ENABLE.getCode())) > 0;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_AUTHORIZATION})
/*     */   @RequestMapping({"/assignAuth"})
/*     */   public String assignAuth(@RequestParam("roleId") Long roleId, @RequestParam("authIds") String authIds, Model model, UserAgent userAgent)
/*     */   {
/* 198 */     if ((StringUtil.isBlank(authIds)) || (roleId == null)) {
/* 199 */       return "error";
/*     */     }
/* 201 */     String[] auths = authIds.split(";");
/* 202 */     if ((auths != null) && (auths.length > 0)) {
/* 203 */       List list = new ArrayList();
/* 204 */       RoleAuthority roleAuth = new RoleAuthority();
/* 205 */       for (String auth : auths) {
/* 206 */         roleAuth = new RoleAuthority();
/* 207 */         roleAuth.setRoleId(roleId);
/* 208 */         roleAuth.setAuthId(Long.valueOf(auth));
/* 209 */         list.add(roleAuth);
/*     */       }
/*     */ 
/* 212 */       if (list.size() > 0) {
/* 213 */         this.roleAuthorityService.batchInsertRoleAuth(roleId, list);
/*     */       }
/*     */       try
/*     */       {
/* 217 */         this.toolService.synchronizeUpdateTime(null);
/*     */       } catch (Exception e) {
/* 219 */         this._log.error("toolService.synchronizeUpdateTime", e);
/*     */       }
/*     */ 
/* 222 */       this.workLogService.addWorkLog("分配权限", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "分配权限成功", userAgent);
/*     */     }
/* 224 */     model.addAttribute("roleId", roleId);
/* 225 */     model.addAttribute("role", this.roleService.getRoleById(roleId));
/* 226 */     model.addAttribute("addMsg", "Y");
/* 227 */     return "/role/assign_auth";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.role.AssignAuthAction
 * JD-Core Version:    0.6.0
 */