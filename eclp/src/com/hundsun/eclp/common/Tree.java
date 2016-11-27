/*     */ package com.hundsun.eclp.common;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Tree
/*     */ {
/*     */   private String id;
/*     */   private String pId;
/*     */   private String name;
/*     */   private String type;
/*     */   private int sort;
/*  24 */   private List<Tree> nodes = new ArrayList();
/*     */   private boolean nocheck;
/*  29 */   private boolean isChecked = false;
/*     */ 
/*  31 */   private boolean isParent = true;
/*     */   private String define;
/*     */ 
/*     */   public Tree()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Tree(String id, String pId, String name, String type, int sort, boolean nocheck)
/*     */   {
/*  40 */     this.id = id;
/*  41 */     this.pId = pId;
/*  42 */     this.name = name;
/*  43 */     this.type = type;
/*  44 */     this.sort = sort;
/*  45 */     this.nocheck = nocheck;
/*     */   }
/*     */ 
/*     */   public Tree(String id, String pId, String name, String type, int sort, boolean nocheck, boolean isParent) {
/*  49 */     this.id = id;
/*  50 */     this.pId = pId;
/*  51 */     this.name = name;
/*  52 */     this.type = type;
/*  53 */     this.sort = sort;
/*  54 */     this.nocheck = nocheck;
/*  55 */     this.isParent = isParent;
/*     */   }
/*     */ 
/*     */   public Tree(Tree tree) {
/*  59 */     this.id = tree.getId();
/*  60 */     this.pId = tree.getpId();
/*  61 */     this.name = tree.getName();
/*  62 */     this.type = tree.getType();
/*  63 */     this.sort = tree.getSort();
/*  64 */     this.nodes = tree.getNodes();
/*  65 */     this.nocheck = tree.getNocheck();
/*  66 */     this.isChecked = tree.isChecked;
/*  67 */     this.isParent = tree.isIsParent();
/*  68 */     this.define = tree.getDefine();
/*     */   }
/*     */ 
/*     */   public void reset(Tree tree) {
/*  72 */     this.id = tree.getId();
/*  73 */     this.pId = tree.getpId();
/*  74 */     this.name = tree.getName();
/*  75 */     this.type = tree.getType();
/*  76 */     this.sort = tree.getSort();
/*  77 */     this.nodes = tree.getNodes();
/*  78 */     this.nocheck = tree.getNocheck();
/*  79 */     this.isChecked = tree.isChecked;
/*  80 */     this.isParent = tree.isIsParent();
/*  81 */     this.define = tree.getDefine();
/*     */   }
/*     */ 
/*     */   public String getId() {
/*  85 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id) {
/*  89 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getpId() {
/*  93 */     return this.pId;
/*     */   }
/*     */ 
/*     */   public void setpId(String pId) {
/*  97 */     this.pId = pId;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 101 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 105 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getType() {
/* 109 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/* 113 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public int getSort() {
/* 117 */     return this.sort;
/*     */   }
/*     */ 
/*     */   public void setSort(int sort) {
/* 121 */     this.sort = sort;
/*     */   }
/*     */ 
/*     */   public List<Tree> getNodes() {
/* 125 */     return this.nodes;
/*     */   }
/*     */ 
/*     */   public void setNodes(List<Tree> nodes) {
/* 129 */     this.nodes = nodes;
/*     */   }
/*     */ 
/*     */   public void resetNodeSort() {
/* 133 */     if ((null != this.nodes) && (this.nodes.size() > 0))
/*     */     {
/* 135 */       List nodes = new ArrayList();
/* 136 */       for (Tree tree : this.nodes) {
/* 137 */         nodes.add(tree);
/*     */       }
/*     */ 
/* 145 */       this.nodes.clear();
/* 146 */       HashMap map = new HashMap();
/* 147 */       for (int i = 0; i < nodes.size(); i++) {
/* 148 */         Tree min = null;
/* 149 */         for (int j = 0; j < nodes.size(); j++) {
/* 150 */           Tree tree = (Tree)nodes.get(j);
/* 151 */           Boolean exist = (Boolean)map.get(tree.getId());
/* 152 */           if ((null == exist) || (!exist.booleanValue())) {
/* 153 */             if (null != min) {
/* 154 */               if ((min.getId().equals(tree.getId())) || 
/* 155 */                 (min.getSort() <= tree.getSort())) continue;
/* 156 */               min.reset(tree);
/*     */             }
/*     */             else
/*     */             {
/* 160 */               min = new Tree(tree);
/*     */             }
/*     */           }
/*     */         }
/* 164 */         map.put(min.getId(), Boolean.valueOf(true));
/* 165 */         this.nodes.add(min);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 177 */     StringBuffer result = new StringBuffer();
/* 178 */     result.append("pId:" + this.pId + "  ");
/* 179 */     result.append("id:" + this.id + "  ");
/* 180 */     result.append("name:" + this.name + "  ");
/* 181 */     result.append("type:" + this.type + "  ");
/* 182 */     result.append("nocheck:" + this.nocheck + "  ");
/* 183 */     result.append("nodes.size():" + this.nodes.size() + "  ");
/* 184 */     return result.toString();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 188 */     List list = new ArrayList();
/* 189 */     Tree tree1 = new Tree("1", "-1", "1", "1", 1, true);
/* 190 */     Tree tree2 = new Tree("2", "-1", "2", "1", 2, true);
/* 191 */     Tree tree3 = new Tree("3", "-1", "3", "1", 3, true);
/* 192 */     Tree tree4 = new Tree("4", "-1", "4", "1", 4, true);
/* 193 */     Tree tree5 = new Tree("5", "-1", "5", "1", 5, true);
/*     */ 
/* 195 */     list.add(tree5);
/* 196 */     list.add(tree4);
/* 197 */     list.add(tree3);
/* 198 */     list.add(tree2);
/* 199 */     list.add(tree1);
/*     */ 
/* 201 */     Tree tree = new Tree();
/* 202 */     tree.setNodes(list);
/*     */ 
/* 204 */     int i = 1;
/* 205 */     for (Tree temp : tree.getNodes()) {
/* 206 */       System.out.println(i + "   " + temp.getId() + "  " + temp.getSort());
/* 207 */       i++;
/*     */     }
/* 209 */     tree.resetNodeSort();
/* 210 */     i = 1;
/* 211 */     for (Tree temp : tree.getNodes()) {
/* 212 */       System.out.println(i + "   " + temp.getId() + "  " + temp.getSort());
/* 213 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean getNocheck() {
/* 218 */     return this.nocheck;
/*     */   }
/*     */ 
/*     */   public void setNocheck(boolean nocheck) {
/* 222 */     this.nocheck = nocheck;
/*     */   }
/*     */ 
/*     */   public boolean isChecked()
/*     */   {
/* 227 */     return this.isChecked;
/*     */   }
/*     */ 
/*     */   public void setChecked(boolean isChecked) {
/* 231 */     this.isChecked = isChecked;
/*     */   }
/*     */ 
/*     */   public boolean isIsParent() {
/* 235 */     if (this.isParent) {
/* 236 */       return true;
/*     */     }
/*     */ 
/* 239 */     return (null != this.nodes) && (this.nodes.size() != 0);
/*     */   }
/*     */ 
/*     */   public void setParent(boolean isParent)
/*     */   {
/* 245 */     this.isParent = isParent;
/*     */   }
/*     */ 
/*     */   public String getDefine() {
/* 249 */     return this.define;
/*     */   }
/*     */ 
/*     */   public void setDefine(String define) {
/* 253 */     this.define = define;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.common.Tree
 * JD-Core Version:    0.6.0
 */