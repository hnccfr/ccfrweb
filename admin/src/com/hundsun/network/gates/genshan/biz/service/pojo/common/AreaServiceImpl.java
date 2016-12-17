/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.common;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.common.AreaDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.common.Area;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.common.AreaBO;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.common.AreaService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("areaService")
/*     */ public class AreaServiceImpl extends BaseService
/*     */   implements AreaService
/*     */ {
/*  23 */   private static Map<String, Map<String, List<AreaBO>>> areaMap = null;
/*  24 */   private static Map<String, Area> AreaKeyMap = new HashMap();
/*     */   private static AreaService instance;
/*     */ 
/*     */   @Autowired
/*     */   private AreaDAO areaDAO;
/*     */ 
/*     */   public AreaServiceImpl()
/*     */   {
/*  30 */     instance = this;
/*     */   }
/*     */ 
/*     */   public static AreaService getInstance() {
/*  34 */     return instance;
/*     */   }
/*     */ 
/*     */   public synchronized void init() {
/*  38 */     List<Area> areaList = this.areaDAO.queryAll();
/*     */ 
/*  40 */     for (Area area : areaList) {
/*  41 */       AreaKeyMap.put(area.getValue(), area);
/*     */     }
/*     */ 
/*  44 */     areaMap = new HashMap();
/*  45 */     for (Area area : areaList) {
/*  46 */       String key = area.getParentPath();
/*  47 */       if (key == null) {
/*  48 */         key = "";
/*     */       }
/*  50 */       List list = null;
/*  51 */       String[] _keys = key.split("\\|");
/*  52 */       for (int i = 0; i < _keys.length; i++) {
/*  53 */         Map map = (Map)areaMap.get(_keys[i]);
/*  54 */         if (map == null) {
/*  55 */           map = new HashMap();
/*     */         }
/*  57 */         if (map.containsKey(String.valueOf(_keys.length - i))) {
/*  58 */           list = (List)map.get(String.valueOf(_keys.length - i));
/*     */         } else {
/*  60 */           list = new ArrayList();
/*  61 */           map.put(String.valueOf(_keys.length - i), list);
/*     */         }
/*  63 */         AreaBO areaBO = new AreaBO();
/*  64 */         areaBO.setName(area.getName());
/*  65 */         areaBO.setValue(area.getValue());
/*  66 */         areaBO.setRanking(area.getRanking());
/*  67 */         list.add(areaBO);
/*  68 */         areaMap.put(_keys[i], map);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  73 */     for (String key : areaMap.keySet()) {
/*  74 */       if (areaMap.get(key) == null) {
/*     */         continue;
/*     */       }
/*  77 */       Map map = (Map)areaMap.get(key);
/*  78 */       for (String childKey : ((Map<String, List<AreaBO>>)areaMap.get(key)).keySet())
/*     */       {
/*  80 */         List list = (List)map.get(childKey);
/*  81 */         if (list == null) {
/*     */           continue;
/*     */         }
/*  84 */         Collections.sort(list);
/*  85 */         map.put(childKey, list);
/*     */       }
/*  87 */       areaMap.put(key, map);
/*     */     }
/*     */   }
/*     */ 
/*     */   private List<AreaBO> queryLevelData(String level, String value)
/*     */   {
/*  93 */     if (areaMap == null) {
/*  94 */       init();
/*     */     }
/*  96 */     Map map = (Map)areaMap.get(value);
/*  97 */     if (map == null) {
/*  98 */       return null;
/*     */     }
/* 100 */     return (List)map.get(level);
/*     */   }
/*     */ 
/*     */   public List<AreaBO> queryCity(String provinceValue)
/*     */   {
/* 105 */     return queryLevelData("1", provinceValue);
/*     */   }
/*     */ 
/*     */   public List<AreaBO> queryLocalArea(String cityValue)
/*     */   {
/* 110 */     return queryLevelData("1", cityValue);
/*     */   }
/*     */ 
/*     */   public List<AreaBO> queryProvince()
/*     */   {
/* 115 */     return queryLevelData("1", "");
/*     */   }
/*     */ 
/*     */   public Map<String, Area> getAllAreasMap()
/*     */   {
/* 120 */     if (AreaKeyMap.isEmpty()) {
/* 121 */       init();
/*     */     }
/* 123 */     return AreaKeyMap;
/*     */   }
/*     */ 
/*     */   public String getAreaFullName(String area)
/*     */   {
/* 128 */     if (AreaKeyMap.isEmpty()) {
/* 129 */       init();
/*     */     }
/* 131 */     Area _area = (Area)AreaKeyMap.get(area);
/* 132 */     if (null == _area) {
/* 133 */       return area;
/*     */     }
/* 135 */     StringBuffer buffer = new StringBuffer();
/* 136 */     String parentPath = _area.getParentPath();
/* 137 */     if (StringUtil.isNotEmpty(parentPath)) {
/* 138 */       String[] paths = parentPath.split("\\|");
/* 139 */       for (String path : paths) {
/* 140 */         Area item = (Area)AreaKeyMap.get(path);
/* 141 */         if (null != item) {
/* 142 */           buffer.append(item.getName());
/*     */         }
/*     */       }
/*     */     }
/* 146 */     buffer.append(_area.getName());
/* 147 */     return buffer.toString();
/*     */   }
/*     */ 
/*     */   public String getCityId(String area)
/*     */   {
/* 152 */     Map map = getAllAreasMap();
/* 153 */     Area _area = (Area)map.get(area);
/* 154 */     if (null == _area) {
/* 155 */       return area;
/*     */     }
/* 157 */     String parentId = _area.getParentPath();
/* 158 */     if (StringUtil.isNotEmpty(parentId)) {
/* 159 */       String[] parentIds = parentId.split("\\|");
/* 160 */       if (parentIds.length >= 2)
/* 161 */         return parentIds[1];
/* 162 */       if (parentIds.length >= 1) {
/* 163 */         return area;
/*     */       }
/*     */     }
/*     */ 
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */   public String getProvinceId(String area)
/*     */   {
/* 172 */     if (null == area) {
/* 173 */       return null;
/*     */     }
/* 175 */     Map map = getAllAreasMap();
/* 176 */     Area _area = (Area)map.get(area);
/* 177 */     if (null == _area) {
/* 178 */       return area;
/*     */     }
/* 180 */     String parentId = _area.getParentPath();
/* 181 */     if (StringUtil.isNotEmpty(parentId)) {
/* 182 */       String[] parentIds = parentId.split("\\|");
/* 183 */       if (parentIds.length >= 1) {
/* 184 */         return parentIds[0];
/*     */       }
/* 186 */       return area;
/*     */     }
/*     */ 
/* 189 */     return area;
/*     */   }
/*     */ 
/*     */   public List<AreaBO> queryAllLocalArea(String province)
/*     */   {
/* 195 */     List list = new ArrayList();
/* 196 */     if (StringUtil.isEmpty(province)) {
/* 197 */       return list;
/*     */     }
/* 199 */     if (AreaKeyMap.isEmpty()) {
/* 200 */       init();
/*     */     }
/* 202 */     Area _province = (Area)AreaKeyMap.get(province);
/* 203 */     if (_province != null) {
/* 204 */       AreaBO bo = new AreaBO();
/* 205 */       bo.setName(_province.getName());
/* 206 */       bo.setRanking(_province.getRanking());
/* 207 */       bo.setValue(_province.getValue());
/* 208 */       list.add(bo);
/*     */     }
/* 210 */     List<AreaBO> cityList = null;
/* 211 */     if (province.equals(getProvinceId(province))) {
/* 212 */       cityList = queryCity(province);
/* 213 */     } else if (province.equals(getCityId(province))) {
/* 214 */       cityList = new ArrayList();
/* 215 */       cityList.addAll(list);
/*     */     }
/*     */ 
/* 218 */     if (null != cityList) {
/* 219 */       for (AreaBO bo : cityList) {
/* 220 */         list.add(bo);
/* 221 */         List areaList = queryLocalArea(bo.getValue());
/* 222 */         if (null != areaList) {
/* 223 */           list.addAll(areaList);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 228 */     return list;
/*     */   }
/*     */ 
/*     */   public String getAreaName(String areaId)
/*     */   {
/* 233 */     if (AreaKeyMap.isEmpty()) {
/* 234 */       init();
/*     */     }
/* 236 */     Area _area = (Area)AreaKeyMap.get(areaId);
/* 237 */     if (null == _area) {
/* 238 */       return areaId;
/*     */     }
/* 240 */     return _area.getName();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.common.AreaServiceImpl
 * JD-Core Version:    0.6.0
 */