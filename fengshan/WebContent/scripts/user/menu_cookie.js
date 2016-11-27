$(function() {
			$(".menum").hide();
			// if ($.cookie('tag')) {
			if (getCookie('tag')) {
				var show_id = getCookie('tag');
				$("#" + show_id).show();// 根据模块ID显示相应模块
			} else {
				$(".default").show();// 默认显示个人管理模块
			}
			/** 绑定click事件，点击后更新cookie中的tag* */
			$(".t2").bind("click", function() {
						if (getCookie('tag')) {
							// $.cookie('tag', null);
							delCookie('tag');
						}
						$(".menum").hide();
						$(this).siblings(".menum").show();
						/*
						 * $.cookie('tag',
						 * $(this).siblings(".menum").attr("id"), { path : '/'
						 * });
						 */
						setCookie('tag', $(this).siblings(".menum").attr("id"),
								{
									path : '/'
								});
					});

		});
