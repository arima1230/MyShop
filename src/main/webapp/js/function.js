function FocusItem(obj) {
	$(obj).next('span').html('').removeClass('error');
}

function CheckItem(obj) {
	var msgBox = $(obj).next('span');
	switch ($(obj).attr('name')) {
		case "userId":
			if (obj.value == "") {
				msgBox.html('空になっている');
				msgBox.addClass('error');
			} else {
				var url = "useridcheck?name=" + encodeURI($(obj).val()) + "&" + new Date().getTime();
				//false true
				$.get(url, function(data) {

					if (data == "false") {
						msgBox.html('ID既に存在している');
						msgBox.addClass('error');
					}
					msgBox.html().removeClass('error');
				});


			}
			break;
		case "passWord":
			if (obj.value == "") {
				msgBox.html('空になっている');
				msgBox.addClass('error');
			}
			break;
		case "rePassWord":
			if (obj.value == "") {
				msgBox.html('空になっている');
				msgBox.addClass('error');
			} else if ($(obj).val() != $('input[name="passWord"]').val()) {
				msgBox.html('パスワードが間違っている');
				msgBox.addClass('error');
			}
			break;
	}
}