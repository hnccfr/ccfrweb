/*     */ package com.hundsun.eclp.web.action;
/*     */ 
/*     */ import com.hundsun.eclp.common.BaseAction;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.servlet.ServletOutputStream;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import oracle.sql.TIMESTAMP;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ public class ExportSQL extends BaseAction
/*     */ {
/*     */ 
/*     */   @Value("${jdbc.driverClassName}")
/*     */   String driver;
/*     */ 
/*     */   @Value("${jdbc.url}")
/*     */   String url;
/*     */ 
/*     */   @Value("${jdbc.username}")
/*     */   String user;
/*     */ 
/*     */   @Value("${jdbc.password}")
/*     */   String password;
/*  42 */   private static Log logger = LogFactory.getLog(ExportSQL.class);
/*     */ 
/*  45 */   private static List<TableInfo> tableInfos = new ArrayList();
/*     */   static Connection conn;
/*     */ 
/*     */   private Connection getConnection()
/*     */   {
/*     */     try
/*     */     {
/*  72 */       if ((conn == null) || (conn.isClosed())) {
/*  73 */         Class.forName(this.driver);
/*  74 */         conn = DriverManager.getConnection(this.url, this.user, this.password);
/*     */       }
/*  76 */       return conn;
/*     */     } catch (Exception e) {
/*  78 */       logger.error(e);
/*     */     }
/*  80 */     return null;
/*     */   }
/*     */   private void closeConnection() {
/*  83 */     if (conn != null)
/*     */       try {
/*  85 */         conn.close();
/*     */       } catch (SQLException e) {
/*  87 */         logger.error(e);
/*     */       }
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/exportInitSQL"})
/*     */   public String exportInitData(HttpServletResponse response) throws SQLException, ClassNotFoundException {
/*  93 */     StringBuffer initSQL = new StringBuffer();
/*  94 */     String split = getSplitByOs();
/*     */ 
/*  96 */     getConnection();
/*  97 */     for (TableInfo info : tableInfos) {
/*  98 */       String tableName = info.getTableName();
/*  99 */       initSQL.append("DELETE FROM " + tableName + ";");
/* 100 */       initSQL.append(split);
/* 101 */       String temp = getInitSQL(tableName, info.getSeq(), info.getWhereStr(), split);
/* 102 */       initSQL.append(temp);
/* 103 */       initSQL.append("commit;");
/* 104 */       initSQL.append(split);
/*     */     }
/*     */ 
/* 107 */     closeConnection();
/*     */     try {
/* 109 */       exportExcelReport(response, initSQL.toString(), "initData");
/*     */     } catch (IOException e) {
/* 111 */       logger.error(e);
/*     */     }
/* 113 */     return null;
/*     */   }
/*     */   private String getSplitByOs() {
/* 116 */     return "\r\n";
/*     */   }
/*     */   private String getInitSQL(String tableName, String seq, String whereStr, String split) throws SQLException {
/* 119 */     StringBuffer initSQL = new StringBuffer();
/* 120 */     String querySql = getQuerySql(tableName, whereStr);
/* 121 */     List rows = excuteSQL(querySql);
/* 122 */     if (rows.size() > 0) {
/* 123 */       for (int i = 0; i < rows.size(); i++) {
/* 124 */         LinkedHashMap row = (LinkedHashMap)rows.get(i);
/* 125 */         initSQL.append("INSERT INTO " + tableName + " VALUES (");
/* 126 */         for (Iterator it = row.keySet().iterator(); it.hasNext(); ) {
/* 127 */           String key = (String)it.next();
/* 128 */           Object value = row.get(key);
/* 129 */           if ("id".equalsIgnoreCase(key)) {
/* 130 */             initSQL.append(seq + ".Nextval");
/* 131 */           } else if (("GMT_CREATE".equalsIgnoreCase(key)) || ("GMT_MODIFY".equalsIgnoreCase(key))) {
/* 132 */             initSQL.append("sysdate");
/* 133 */           } else if (("LAST_LOGIN_TIME".equalsIgnoreCase(key)) || ("LAST_LOGIN_IP".equalsIgnoreCase(key)) || ("LOGIN_NUM".equalsIgnoreCase(key))) {
/* 134 */             initSQL.append("null");
/* 135 */           } else if ("USER_ID".equalsIgnoreCase(key)) {
/* 136 */             if ((value != null) && (StringUtil.isNotBlank(value.toString()))) {
/* 137 */               Long userId = Long.valueOf(value.toString());
/* 138 */               String userName = getUserName(userId, "ECLP_USERS");
/* 139 */               initSQL.append("(SELECT ID FROM ECLP_USERS WHERE ACCOUNT='" + userName + "')");
/*     */             } else {
/* 141 */               initSQL.append("null");
/*     */             }
/* 143 */           } else if ("AUTH_ID".equalsIgnoreCase(key)) {
/* 144 */             if ((value != null) && (StringUtil.isNotBlank(value.toString()))) {
/* 145 */               Long authId = Long.valueOf(value.toString());
/* 146 */               String authName = getAuthName(authId, "ECLP_AUTHORITY");
/* 147 */               initSQL.append("(SELECT ID FROM ECLP_AUTHORITY WHERE NAME='" + authName + "')");
/*     */             } else {
/* 149 */               initSQL.append("null");
/*     */             }
/* 151 */           } else if ("ROLE_ID".equalsIgnoreCase(key)) {
/* 152 */             if ((value != null) && (StringUtil.isNotBlank(value.toString()))) {
/* 153 */               Long roleId = Long.valueOf(value.toString());
/* 154 */               String roleCode = getRoleCode(roleId, "ECLP_ROLE");
/* 155 */               initSQL.append("(SELECT ID FROM ECLP_ROLE WHERE CODE='" + roleCode + "')");
/*     */             } else {
/* 157 */               initSQL.append("null");
/*     */             }
/* 159 */           } else if (("SUB_SYSTEM_ID".equalsIgnoreCase(key)) || ("SYS_ID".equalsIgnoreCase(key))) {
/* 160 */             if (value != null) {
/* 161 */               Long subSystemId = Long.valueOf(value.toString());
/* 162 */               String systemName = getSubSystemName(subSystemId, "eclp_sub_system");
/* 163 */               if (StringUtil.isNotBlank(systemName)) {
/* 164 */                 initSQL.append("(");
/* 165 */                 initSQL.append("select id from eclp_sub_system where Name='" + systemName + "'");
/* 166 */                 initSQL.append(")");
/*     */               }
/*     */             } else {
/* 169 */               initSQL.append("null");
/*     */             }
/* 171 */           } else if ("PARENT_ID".equalsIgnoreCase(key)) {
/* 172 */             if (value != null) {
/* 173 */               Long parentId = Long.valueOf(value.toString());
/* 174 */               if (parentId.longValue() != -1L) {
/* 175 */                 String parentName = getAuthName(parentId, tableName);
/* 176 */                 if (StringUtil.isNotBlank(parentName)) {
/* 177 */                   initSQL.append("(");
/* 178 */                   initSQL.append("select id from " + tableName + " where Name='" + parentName + "'");
/* 179 */                   initSQL.append(")");
/*     */                 }
/*     */               } else {
/* 182 */                 initSQL.append(value);
/*     */               }
/*     */             } else {
/* 185 */               initSQL.append("null");
/*     */             }
/*     */           } else {
/* 188 */             if ((value != null) && ((value instanceof String))) {
/* 189 */               if (StringUtil.isNotBlank(value.toString()))
/* 190 */                 value = "'" + value + "'";
/*     */               else
/* 192 */                 value = "null";
/*     */             }
/* 194 */             else if ((value != null) && ((value instanceof TIMESTAMP))) {
/* 195 */               Date date = ((TIMESTAMP)value).dateValue();
/* 196 */               value = "to_date('" + date + "','yyyy-mm-dd hh24:mi:ss')";
/*     */             }
/* 198 */             initSQL.append(value);
/*     */           }
/* 200 */           initSQL.append(",");
/*     */         }
/* 202 */         initSQL.deleteCharAt(initSQL.lastIndexOf(","));
/* 203 */         initSQL.append(" );");
/* 204 */         initSQL.append(split);
/*     */       }
/*     */     }
/*     */ 
/* 208 */     return initSQL.toString();
/*     */   }
/*     */ 
/*     */   private String getQuerySql(String tableName, String whereStr)
/*     */   {
/* 213 */     StringBuffer sbf = new StringBuffer();
/* 214 */     sbf.append("SELECT * FROM " + tableName);
/* 215 */     if (StringUtil.isNotBlank(whereStr)) {
/* 216 */       sbf.append(" WHERE " + whereStr);
/*     */     }
/* 218 */     sbf.append(" ORDER BY ID ASC");
/* 219 */     return sbf.toString();
/*     */   }
/*     */   private List<LinkedHashMap<String, Object>> excuteSQL(String sql) {
/* 222 */     logger.info(sql);
/* 223 */     if (conn == null) {
/* 224 */       conn = getConnection();
/*     */     }
/*     */ 
/* 227 */     List rows = new ArrayList();
/*     */     try
/*     */     {
/* 230 */       PreparedStatement preparedStatement = conn.prepareStatement(sql);
/*     */ 
/* 232 */       ResultSet resultSet = preparedStatement.executeQuery();
/*     */ 
/* 234 */       ResultSetMetaData metaData = resultSet.getMetaData();
/*     */ 
/* 236 */       while (resultSet.next()) {
/* 237 */         LinkedHashMap row = new LinkedHashMap();
/* 238 */         for (int i = 1; i <= metaData.getColumnCount(); i++) {
/* 239 */           row.put(metaData.getColumnName(i), resultSet.getObject(i) != null ? resultSet.getObject(i) : "");
/*     */         }
/* 241 */         rows.add(row);
/*     */       }
/* 243 */       resultSet.close();
/* 244 */       preparedStatement.close();
/*     */     }
/*     */     catch (Exception e) {
/* 247 */       logger.error(e);
/*     */     }
/* 249 */     return rows;
/*     */   }
/*     */ 
/*     */   private String getRoleCode(Long roleId, String tableName) {
/* 253 */     String sql = "SELECT * FROM " + tableName + " WHERE ID=" + roleId;
/* 254 */     List rows = excuteSQL(sql);
/* 255 */     if ((rows != null) && (rows.size() > 0)) {
/* 256 */       LinkedHashMap map = (LinkedHashMap)rows.get(0);
/* 257 */       if (!map.isEmpty()) {
/* 258 */         return (String)map.get("CODE");
/*     */       }
/*     */     }
/* 261 */     return null;
/*     */   }
/*     */   private String getUserName(Long userId, String tableName) {
/* 264 */     String sql = "SELECT * FROM " + tableName + " WHERE ID=" + userId;
/* 265 */     List rows = excuteSQL(sql);
/* 266 */     if ((rows != null) && (rows.size() > 0)) {
/* 267 */       LinkedHashMap map = (LinkedHashMap)rows.get(0);
/* 268 */       if (!map.isEmpty()) {
/* 269 */         return (String)map.get("ACCOUNT");
/*     */       }
/*     */     }
/* 272 */     return null;
/*     */   }
/*     */   private String getAuthName(Long parentId, String tableName) {
/* 275 */     String sql = "SELECT * FROM " + tableName + " WHERE ID=" + parentId;
/* 276 */     List rows = excuteSQL(sql);
/* 277 */     if ((rows != null) && (rows.size() > 0)) {
/* 278 */       LinkedHashMap map = (LinkedHashMap)rows.get(0);
/* 279 */       if (!map.isEmpty()) {
/* 280 */         return (String)map.get("NAME");
/*     */       }
/*     */     }
/* 283 */     return null;
/*     */   }
/*     */   private String getSubSystemName(Long subSystemId, String tableName) {
/* 286 */     String sql = "SELECT * FROM " + tableName + " WHERE ID=" + subSystemId;
/* 287 */     List rows = excuteSQL(sql);
/* 288 */     if ((rows != null) && (rows.size() > 0)) {
/* 289 */       LinkedHashMap map = (LinkedHashMap)rows.get(0);
/* 290 */       if (!map.isEmpty()) {
/* 291 */         return (String)map.get("NAME");
/*     */       }
/*     */     }
/* 294 */     return null;
/*     */   }
/*     */   public void exportExcelReport(HttpServletResponse response, String fileContent, String fileName) throws IOException {
/*     */     try {
/* 298 */       response.setContentType("application/x-msdownload");
/* 299 */       response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("GBK"), "iso8859-1") + ".txt" + "\"");
/* 300 */       ServletOutputStream sos = response.getOutputStream();
/* 301 */       sos.write(fileContent.getBytes());
/* 302 */       sos.close();
/*     */     } catch (Exception e) {
/* 304 */       logger.error(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws ClassNotFoundException, SQLException
/*     */   {
/* 315 */     String driver = "oracle.jdbc.OracleDriver";
/*     */ 
/* 317 */     String url = "jdbc:oracle:thin:@172.23.11.174:1521:hundsun";
/*     */ 
/* 319 */     String user = "suse_test";
/*     */ 
/* 321 */     String password = "suse123456";
/*     */ 
/* 324 */     Class.forName(driver);
/*     */ 
/* 326 */     Connection connection = DriverManager.getConnection(url, user, password);
/*     */ 
/* 328 */     PreparedStatement preparedStatement = connection.prepareStatement("select * from eclp_authority");
/*     */ 
/* 330 */     ResultSet resultSet = preparedStatement.executeQuery();
/*     */ 
/* 332 */     ResultSetMetaData metaData = resultSet.getMetaData();
/*     */ 
/* 334 */     List rows = new ArrayList();
/* 335 */     while (resultSet.next()) {
/* 336 */       LinkedHashMap row = new LinkedHashMap();
/* 337 */       for (int i = 1; i <= metaData.getColumnCount(); i++) {
/* 338 */         row.put(metaData.getColumnName(i), resultSet.getObject(i) != null ? resultSet.getObject(i) : "");
/*     */       }
/* 340 */       rows.add(row);
/*     */     }
/* 342 */     resultSet.close();
/* 343 */     preparedStatement.close();
/* 344 */     connection.close();
/* 345 */     if (rows.size() > 0) {
/* 346 */       LinkedHashMap keys = (LinkedHashMap)rows.get(0);
/* 347 */       StringBuffer initSQL = new StringBuffer();
/* 348 */       for (int i = 0; i < rows.size(); i++) {
/* 349 */         LinkedHashMap row = (LinkedHashMap)rows.get(i);
/* 350 */         initSQL = new StringBuffer();
/* 351 */         initSQL.append("INSERT INTO eclp_authority VALUES (");
/* 352 */         for (Iterator it = keys.keySet().iterator(); it.hasNext(); ) {
/* 353 */           String key = (String)it.next();
/* 354 */           Object value = row.get(key);
/* 355 */           if ("id".equalsIgnoreCase(key)) {
/* 356 */             initSQL.append("seq_users.nextval");
/* 357 */           } else if (("GMT_CREATE".equalsIgnoreCase(key)) || ("GMT_MODIFY".equalsIgnoreCase(key))) {
/* 358 */             initSQL.append("sysdate");
/* 359 */           } else if (("LAST_LOGIN_TIME".equalsIgnoreCase(key)) || ("LAST_LOGIN_IP".equalsIgnoreCase(key)) || ("LOGIN_NUM".equalsIgnoreCase(key))) {
/* 360 */             initSQL.append("");
/* 361 */           } else if ("USER_ID".equalsIgnoreCase(key)) {
/* 362 */             if ((value != null) && (StringUtil.isNotBlank(value.toString())))
/* 363 */               initSQL.append("select id from eclp_users where id=" + value);
/*     */             else
/* 365 */               initSQL.append("null");
/*     */           }
/*     */           else {
/* 368 */             if ((value != null) && ((value instanceof String))) {
/* 369 */               if (StringUtil.isNotBlank(value.toString()))
/* 370 */                 value = "'" + value + "'";
/*     */               else
/* 372 */                 value = null;
/*     */             }
/* 374 */             else if ((value != null) && ((value instanceof TIMESTAMP))) {
/* 375 */               Date date = ((TIMESTAMP)value).dateValue();
/* 376 */               value = "to_date('" + date + "','yyyy-mm-dd hh24:mi:ss')";
/*     */             }
/* 378 */             initSQL.append(value);
/*     */           }
/* 380 */           initSQL.append(",");
/*     */         }
/* 382 */         initSQL.deleteCharAt(initSQL.lastIndexOf(","));
/* 383 */         initSQL.append(" );");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  49 */     TableInfo info = new TableInfo("eclp_users", "SEQ_USERS", "STATUS=1");
/*  50 */     tableInfos.add(info);
/*  51 */     info = new TableInfo("eclp_sub_system", "seq_sub_system", "IS_DELETED='N'");
/*  52 */     tableInfos.add(info);
/*  53 */     info = new TableInfo("eclp_role", "seq_role", "IS_DELETED='N'");
/*  54 */     tableInfos.add(info);
/*  55 */     info = new TableInfo("eclp_sys_config", "seq_sys_config", "");
/*  56 */     tableInfos.add(info);
/*  57 */     info = new TableInfo("eclp_authority", "SEQ_AUTHORITY", "IS_DELETED='N'");
/*  58 */     tableInfos.add(info);
/*  59 */     info = new TableInfo("eclp_user_role", "seq_user_role", "IS_DELETED='N'");
/*  60 */     tableInfos.add(info);
/*  61 */     info = new TableInfo("eclp_role_authority", "seq_role_auth", "IS_DELETED='N'");
/*  62 */     tableInfos.add(info);
/*  63 */     info = new TableInfo("eclp_role_system", "seq_role_system_id", "");
/*  64 */     tableInfos.add(info);
/*  65 */     info = new TableInfo("eclp_role_system", "seq_role_system_id", "");
/*  66 */     tableInfos.add(info);
/*     */ 
/*  68 */     conn = null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.ExportSQL
 * JD-Core Version:    0.6.0
 */