$(function() {
			if (getCookie('tag')) {
				if ("tag1" != getCookie('tag')) {
					setCookie('tag', 'tag1', {
								path : '/'
							});
					window.location.reload();
				}
			}
		});
