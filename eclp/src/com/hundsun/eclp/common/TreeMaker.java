/*     */ package com.hundsun.eclp.common;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class TreeMaker
/*     */ {
/*     */   private List<Tree> demoDataList;
/*     */   private Map<String, Tree> demoDataMap;
/*     */ 
/*     */   public List<Tree> getDataByPId(String pId)
/*     */   {
/*  21 */     if ((pId != null) && (this.demoDataMap.containsKey(pId)))
/*     */     {
/*  23 */       return ((Tree)this.demoDataMap.get(pId)).getNodes();
/*     */     }
/*     */ 
/*  26 */     return this.demoDataList;
/*     */   }
/*     */ 
/*     */   public TreeMaker(List<Tree> treeList, String rootId)
/*     */   {
/*  31 */     this.demoDataList = new ArrayList();
/*  32 */     this.demoDataMap = new HashMap();
/*  33 */     if (null != rootId) {
/*  34 */       for (Tree tree : treeList) {
/*  35 */         this.demoDataMap.put(tree.getId(), tree);
/*  36 */         if (tree.getpId().equals(rootId))
/*  37 */           this.demoDataList.add(tree);
/*     */       }
/*     */     }
/*     */     else {
/*  41 */       for (Tree tree : treeList) {
/*  42 */         this.demoDataMap.put(tree.getId(), tree);
/*  43 */         if (null == tree.getpId()) {
/*  44 */           this.demoDataList.add(tree);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  49 */     for (String key : this.demoDataMap.keySet()) {
/*  50 */       Tree d = (Tree)this.demoDataMap.get(key);
/*     */ 
/*  54 */       if (this.demoDataMap.containsKey(d.getpId())) {
/*  55 */         ((Tree)this.demoDataMap.get(d.getpId())).getNodes().add(d);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     for (String key : this.demoDataMap.keySet()) {
/*  61 */       Tree d = (Tree)this.demoDataMap.get(key);
/*  62 */       if (d.isIsParent())
/*  63 */         ((Tree)this.demoDataMap.get(d.getId())).resetNodeSort();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String toStringScript()
/*     */   {
/*  69 */     StringBuffer result = new StringBuffer();
/*  70 */     int count = 0;
/*  71 */     for (Tree tree : this.demoDataList) {
/*  72 */       if (count > 0) {
/*  73 */         result.append(",");
/*     */       }
/*  75 */       result.append(toStringScriptTree(tree));
/*  76 */       count++;
/*     */     }
/*  78 */     return result.toString();
/*     */   }
/*     */ 
/*     */   private String toStringScriptTree(Tree tree) {
/*  82 */     StringBuffer result = new StringBuffer();
/*  83 */     result.append("{");
/*  84 */     result.append("pId:\"" + tree.getpId() + "\",");
/*  85 */     result.append("id:\"" + tree.getId() + "\",");
/*  86 */     result.append("name:\"" + tree.getName() + "\",");
/*  87 */     result.append("type:\"" + tree.getType() + "\",");
/*     */ 
/*  94 */     if ((null != tree.getDefine()) && (!tree.getDefine().equals(""))) {
/*  95 */       result.append("define:\"" + tree.getDefine() + "\",");
/*     */     }
/*  97 */     if (tree.isChecked()) {
/*  98 */       result.append("nocheck:" + tree.getNocheck() + ",");
/*  99 */       result.append("checked:" + tree.isChecked());
/*     */     } else {
/* 101 */       result.append("nocheck:" + tree.getNocheck() + "");
/*     */     }
/* 103 */     if (tree.isIsParent()) {
/* 104 */       result.append(",isParent:\"" + tree.isIsParent() + "\",");
/*     */ 
/* 106 */       result.append("nodes:[");
/*     */ 
/* 108 */       int count = 0;
/* 109 */       for (Tree treeNode : tree.getNodes()) {
/* 110 */         if (count > 0) {
/* 111 */           result.append(",");
/*     */         }
/*     */ 
/* 114 */         result.append(toStringScriptTree(treeNode));
/* 115 */         count++;
/*     */       }
/* 117 */       result.append("]");
/*     */     }
/*     */ 
/* 120 */     result.append("}");
/*     */ 
/* 122 */     return result.toString();
/*     */   }
/*     */ 
/*     */   public List<String> getSubIdList(String parentId) {
/* 126 */     List result = new ArrayList();
/* 127 */     for (Tree tree : this.demoDataList) {
/* 128 */       List<String> resultTemp = getSubIdList(parentId, tree);
/* 129 */       for (String id : resultTemp) {
/* 130 */         result.add(id);
/*     */       }
/*     */     }
/* 133 */     return result;
/*     */   }
/*     */ 
/*     */   private List<String> getSubIdList(String parentId, Tree tree) {
/* 137 */     List result = new ArrayList();
/* 138 */     if (tree.getpId().equals(parentId)) {
/* 139 */       result.add(tree.getId());
/* 140 */       if (tree.isIsParent()) {
/* 141 */         for (Tree treeNode : tree.getNodes()) {
/* 142 */           List<String> resultTemp = getSubIdList(tree.getId(), treeNode);
/* 143 */           for (String id : resultTemp) {
/* 144 */             result.add(id);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 149 */     else if (tree.isIsParent()) {
/* 150 */       for (Tree treeNode : tree.getNodes()) {
/* 151 */         List<String> resultTemp = getSubIdList(parentId, treeNode);
/* 152 */         for (String id : resultTemp) {
/* 153 */           result.add(id);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 158 */     return result;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 163 */     testSubNodesSort();
/*     */   }
/*     */ 
/*     */   private static void testSubNodesSort() {
/* 167 */     List list = new ArrayList();
/* 168 */     Tree tree0 = new Tree("0", "-1", "0", "0", 1, true);
/* 169 */     List listSub = new ArrayList();
/* 170 */     Tree tree1 = new Tree("1", "0", "1", "1", 1, true);
/* 171 */     Tree tree2 = new Tree("2", "0", "2", "1", 2, true);
/* 172 */     Tree tree3 = new Tree("3", "0", "3", "1", 3, true);
/* 173 */     Tree tree4 = new Tree("4", "0", "4", "1", 4, true);
/* 174 */     Tree tree5 = new Tree("5", "0", "5", "1", 5, true);
/*     */ 
/* 176 */     listSub.add(tree5);
/* 177 */     listSub.add(tree4);
/* 178 */     listSub.add(tree3);
/* 179 */     listSub.add(tree2);
/* 180 */     listSub.add(tree1);
/*     */ 
/* 182 */     tree0.setNodes(listSub);
/* 183 */     list.add(tree0);
/* 184 */     TreeMaker treeMaker = new TreeMaker(list, "-1");
/* 185 */     System.out.println(treeMaker.toStringScript());
/*     */   }
/*     */ 
/*     */   private static void testGetSubIdList()
/*     */   {
/* 190 */     List list = new ArrayList();
/* 191 */     Tree tree1 = new Tree("1", "-1", "1", "1", 1, true);
/* 192 */     list.add(tree1);
/* 193 */     Tree tree2 = new Tree("2", "-1", "2", "1", 2, true);
/* 194 */     list.add(tree2);
/* 195 */     Tree tree3 = new Tree("3", "1", "3", "2", 1, true);
/* 196 */     list.add(tree3);
/* 197 */     Tree tree4 = new Tree("4", "1", "4", "2", 2, true);
/* 198 */     list.add(tree4);
/* 199 */     Tree tree5 = new Tree("5", "3", "5", "3", 1, true);
/* 200 */     list.add(tree5);
/* 201 */     Tree tree6 = new Tree("6", "3", "6", "3", 2, true);
/* 202 */     list.add(tree6);
/* 203 */     Tree tree7 = new Tree("7", "4", "7", "3", 1, true);
/* 204 */     list.add(tree7);
/* 205 */     Tree tree8 = new Tree("8", "4", "8", "3", 2, true);
/* 206 */     list.add(tree8);
/* 207 */     Tree tree9 = new Tree("9", "5", "9", "4", 1, true);
/* 208 */     list.add(tree9);
/* 209 */     Tree tree10 = new Tree("10", "7", "10", "4", 1, true);
/* 210 */     list.add(tree10);
/* 211 */     TreeMaker treeMaker = new TreeMaker(list, "-1");
/* 212 */     List<String> subIdList = treeMaker.getSubIdList("7");
/* 213 */     for (String id : subIdList)
/* 214 */       System.out.println(id);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.common.TreeMaker
 * JD-Core Version:    0.6.0
 */