$(function() {
			$(".menum").hide();
			// if ($.cookie('tag')) {
			if (getCookie('tag')) {
				var show_id = getCookie('tag');
				$("#" + show_id).show();// ����ģ��ID��ʾ��Ӧģ��
			} else {
				$(".default").show();// Ĭ����ʾ���˹���ģ��
			}
			/** ��click�¼�����������cookie�е�tag* */
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
