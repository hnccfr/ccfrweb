/*     */ package com.hundsun.eclp.web.action.contain;
/*     */ 
/*     */ import com.hundsun.network.common.query.QueryBase;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class PageSlider
/*     */ {
/*  35 */   public static final Log logger = LogFactory.getLog(PageSlider.class);
/*     */   private int defaultSliderWidth;
/*     */   private String defaultFormSlider;
/*     */   private String defaultSlider;
/*     */   private String defaultPageParameterName;
/*     */   private String defaultFormPageMethod;
/*     */   private Random random;
/*     */ 
/*     */   public PageSlider()
/*     */   {
/*  40 */     this.defaultSliderWidth = 5;
/*     */ 
/*  42 */     this.defaultFormSlider = "/contain/form_page_slider";
/*     */ 
/*  44 */     this.defaultSlider = "/contain/page_slider";
/*     */ 
/*  46 */     this.defaultPageParameterName = "page";
/*     */ 
/*  51 */     this.defaultFormPageMethod = "post";
/*     */ 
/*  53 */     this.random = new Random();
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/contain/form_page_slider"})
/*     */   public ModelAndView formPage(HttpServletRequest request)
/*     */     throws Exception
/*     */   {
/*  62 */     int totalPage = 0;
/*  63 */     int currentPage = 0;
/*  64 */     QueryBase query = (QueryBase)request.getAttribute("slider_query");
/*  65 */     if (query == null) {
/*  66 */       throw new IllegalArgumentException("not find parameter slider_query");
/*     */     }
/*  68 */     totalPage = query.getTotalPage();
/*  69 */     currentPage = query.getCurrentPage().intValue();
/*     */ 
/*  71 */     if (currentPage == 0) {
/*  72 */       throw new IllegalStateException("current page will be 0?");
/*     */     }
/*  74 */     Object temp = null;
/*  75 */     int width = this.defaultSliderWidth;
/*  76 */     if ((temp = request.getAttribute("slider_width")) != null) {
/*     */       try {
/*  78 */         width = Integer.parseInt(temp.toString());
/*     */       } catch (NumberFormatException e) {
/*  80 */         logger.error("error then parse slider_width", e);
/*     */       }
/*     */     }
/*  83 */     List grids = getGrids(totalPage, currentPage, width);
/*  84 */     String currentSlider = this.defaultFormSlider;
/*  85 */     if ((temp = request.getAttribute("slider_path")) != null) {
/*  86 */       currentSlider = temp.toString();
/*     */     }
/*     */ 
/*  89 */     String sliderPage = this.defaultPageParameterName;
/*  90 */     if ((temp = request.getAttribute("slider_page")) != null) {
/*  91 */       sliderPage = temp.toString();
/*     */     }
/*     */ 
/*  94 */     String sliderTarget = (String)request.getAttribute("slider_target");
/*  95 */     if (sliderTarget == null) {
/*  96 */       throw new IllegalArgumentException("not find parameter slider_target");
/*     */     }
/*     */ 
/*  99 */     String sliderMethod = (String)request.getAttribute("slider_method");
/* 100 */     if (StringUtils.isBlank(sliderMethod)) {
/* 101 */       sliderMethod = this.defaultFormPageMethod;
/*     */     }
/*     */ 
/* 104 */     ModelAndView mv = new ModelAndView(currentSlider, "grids", grids);
/* 105 */     mv.addObject("sliderTotal", Integer.valueOf(totalPage));
/* 106 */     mv.addObject("sliderCurrent", Integer.valueOf(currentPage));
/* 107 */     mv.addObject("sliderNext", Integer.valueOf(currentPage + 1));
/* 108 */     mv.addObject("sliderPrev", Integer.valueOf(currentPage - 1));
/* 109 */     mv.addObject("sliderQuery", query);
/* 110 */     mv.addObject("sliderPage", sliderPage);
/* 111 */     mv.addObject("sliderTarget", sliderTarget);
/* 112 */     mv.addObject("sliderRandom", getFormId());
/* 113 */     mv.addObject("sliderMethod", sliderMethod);
/* 114 */     return mv;
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/contain/page_slider"})
/*     */   public ModelAndView handleRequest(HttpServletRequest request)
/*     */     throws Exception
/*     */   {
/* 123 */     int totalPage = 0;
/* 124 */     int currentPage = 0;
/* 125 */     QueryBase query = (QueryBase)request.getAttribute("slider_query");
/* 126 */     if (query == null) {
/* 127 */       throw new IllegalArgumentException("not find parameter slider_query");
/*     */     }
/* 129 */     totalPage = query.getTotalPage();
/* 130 */     currentPage = query.getCurrentPage().intValue();
/*     */ 
/* 132 */     if (currentPage == 0) {
/* 133 */       throw new IllegalStateException("current page will be 0?");
/*     */     }
/* 135 */     Object temp = null;
/* 136 */     int width = this.defaultSliderWidth;
/* 137 */     if ((temp = request.getAttribute("slider_width")) != null) {
/*     */       try {
/* 139 */         width = Integer.parseInt(temp.toString());
/*     */       } catch (NumberFormatException e) {
/* 141 */         logger.error("error then parse slider_width", e);
/*     */       }
/*     */     }
/* 144 */     List grids = getGrids(totalPage, currentPage, width);
/* 145 */     String currentSlider = this.defaultSlider;
/* 146 */     if ((temp = request.getAttribute("slider_path")) != null) {
/* 147 */       currentSlider = temp.toString();
/*     */     }
/*     */ 
/* 150 */     PagingURLBuilder builder = (PagingURLBuilder)request.getAttribute("slider_builder");
/* 151 */     if (builder == null) {
/* 152 */       throw new IllegalArgumentException("not find parameter slider_builder");
/*     */     }
/*     */ 
/* 155 */     ModelAndView mv = new ModelAndView(currentSlider, "grids", grids);
/* 156 */     mv.addObject("sliderTotal", Integer.valueOf(totalPage));
/* 157 */     mv.addObject("sliderCurrent", Integer.valueOf(currentPage));
/* 158 */     mv.addObject("sliderNext", Integer.valueOf(currentPage + 1));
/* 159 */     mv.addObject("sliderPrev", Integer.valueOf(currentPage - 1));
/* 160 */     mv.addObject("sliderQuery", query);
/* 161 */     mv.addObject("sliderRandom", getFormId());
/* 162 */     mv.addObject("sliderBuilder", builder);
/* 163 */     return mv;
/*     */   }
/*     */ 
/*     */   protected static List<Integer> getGrids(int totalPage, int currentPage, int width) {
/* 167 */     int widthHalf = width / 2;
/* 168 */     List grids = new ArrayList();
/* 169 */     for (int i = 1; i <= Math.min(width, currentPage); i++) {
/* 170 */       grids.add(Integer.valueOf(i));
/*     */     }
/* 172 */     if (currentPage - grids.size() > widthHalf) {
/* 173 */       grids.add(Integer.valueOf(0));
/*     */     }
/* 175 */     for (int i = Math.max(currentPage - widthHalf, grids.size() + 1); i <= Math.min(currentPage + widthHalf, totalPage); )
/*     */     {
/* 178 */       grids.add(Integer.valueOf(i));
/*     */ 
/* 177 */       i++;
/*     */     }
/*     */ 
/* 180 */     if (totalPage - ((Integer)grids.get(grids.size() - 1)).intValue() > width) {
/* 181 */       grids.add(Integer.valueOf(0));
/*     */     }
/* 183 */     for (int i = Math.max(totalPage - width + 1, ((Integer)grids.get(grids.size() - 1)).intValue() + 1); i <= totalPage; i++) {
/* 184 */       grids.add(Integer.valueOf(i));
/*     */     }
/* 186 */     return grids;
/*     */   }
/*     */ 
/*     */   private String getFormId() {
/* 190 */     return Integer.toString(this.random.nextInt(999));
/*     */   }
/*     */ 
/*     */   public static abstract interface PagingURLBuilder
/*     */   {
/*     */     public abstract String build(QueryBase paramQueryBase, int paramInt);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.contain.PageSlider
 * JD-Core Version:    0.6.0
 */