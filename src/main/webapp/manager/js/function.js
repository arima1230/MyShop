function FocusItem(obj) {
	$(obj).next('span').html('').removeClass('error');
}

function CheckItem(obj) {
	var msgBox = $(obj).next('span');
	switch ($(obj).attr('name')) {
		case "className":
			if (obj.value == "") {
				msgBox.html('空になっている');
				msgBox.addClass('error');
			} 
			break;
	}
}