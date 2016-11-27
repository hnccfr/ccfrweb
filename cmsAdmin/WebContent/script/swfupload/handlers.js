/* Demo Note:  This demo uses a FileProgress class that handles the UI for displaying the file name and percent complete.
The FileProgress class is not part of SWFUpload.
*/


/* **********************
   Event Handlers
   These are my custom event handlers to make my
   web application behave the way I went when SWFUpload
   completes different tasks.  These aren't part of the SWFUpload
   package.  They are part of my application.  Without these none
   of the actions SWFUpload makes will show up in my application.
   ********************** */
function fileQueued(file) {
	try {
		var progress = new FileProgress(file, this.customSettings.progressTarget);
//		progress.setStatus("Pending...");
		progress.setStatus("请稍候...");
		progress.toggleCancel(true, this);

	} catch (ex) {
		this.debug(ex);
	}

}

function fileQueueError(file, errorCode, message) {
	try {
		if (errorCode === SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED) {
//			alert("You have attempted to queue too many files.\n" + (message === 0 ? "You have reached the upload limit." : "You may select " + (message > 1 ? "up to " + message + " files." : "one file.")));
			alert("您选择了太多的文件。\n" + (message === 0 ? "达到了最大限制。" : "您可以选择" + (message > 1 ? "最多" + message + "文件" : "一个文件")));
			return;
		}

		var progress = new FileProgress(file, this.customSettings.progressTarget);
		progress.setError();
		progress.toggleCancel(false);

		switch (errorCode) {
		case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
//			progress.setStatus("File is too big.");
			progress.setStatus("文件超过最大限制" );
			this.debug("Error Code: File too big, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			break;
		case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
//			progress.setStatus("Cannot upload Zero Byte files.");
			progress.setStatus("不能上传0字节文件");
			this.debug("Error Code: Zero byte file, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			break;
		case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
//			progress.setStatus("Invalid File Type.");
			progress.setStatus("文件类型无效");
			this.debug("Error Code: Invalid File Type, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			break;
		default:
			if (file !== null) {
//				progress.setStatus("Unhandled Error");
				progress.setStatus("未预期错误");
			}
			this.debug("Error Code: " + errorCode + ", File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			break;
		}
	} catch (ex) {
        this.debug(ex);
    }
}

function fileDialogComplete(numFilesSelected, numFilesQueued) {
	try {
		if (numFilesSelected > 0) {
			document.getElementById(this.customSettings.cancelButtonId).disabled = false;
			//增加隐藏的取消按钮的显示	sunjin	2011-11-03
			document.getElementById(this.customSettings.cancelButtonId).style.visibility = "visible";
		}
		
		/* I want auto start the upload and I can do that here */
		this.startUpload();
	} catch (ex)  {
        this.debug(ex);
	}
}

function uploadStart(file) {
	try {
		/* I don't want to do any file validation or anything,  I'll just update the UI and
		return true to indicate that the upload should start.
		It's important to update the UI here because in Linux no uploadProgress events are called. The best
		we can do is say we are uploading.
		 */
		var progress = new FileProgress(file, this.customSettings.progressTarget);
		//限制模板和资源文件上传50个字符 by liuchao
		if(file.name.length > 50)
			{
			alert("文件名不能超过50个字符!");
			progress.setStatus("文件名不能超过50个字符...");
			return false;
			}
		else{
			progress.setStatus("上传中，请稍候...");
		    progress.toggleCancel(true, this);
		}
//		progress.setStatus("Uploading...");
		
	}
	catch (ex) {}
	
	return true;
}

function uploadProgress(file, bytesLoaded, bytesTotal) {
	try {
		var percent = Math.ceil((bytesLoaded / bytesTotal) * 100);

		var progress = new FileProgress(file, this.customSettings.progressTarget);
		progress.setProgress(percent);
//		progress.setStatus("Uploading...");
		progress.setStatus("上传中，请稍候...");
	} catch (ex) {
		this.debug(ex);
	}
}

function uploadSuccess(file, serverData) {
	try {
		var progress = new FileProgress(file, this.customSettings.progressTarget);
		progress.setComplete();
//		progress.setStatus("Complete.");
		progress.setStatus("上传完成");
		progress.toggleCancel(false);

	} catch (ex) {
		this.debug(ex);
	}
}

function uploadError(file, errorCode, message) {
	try {
		var progress = new FileProgress(file, this.customSettings.progressTarget);
		progress.setError();
		progress.toggleCancel(false);
		switch (errorCode) {
		case SWFUpload.UPLOAD_ERROR.HTTP_ERROR:
//			progress.setStatus("Upload Error: " + message);
//			this.debug("Error Code: HTTP Error, File name: " + file.name + ", Message: " + message);
			progress.setStatus("上传失败 ");
			this.debug("错误编码: HTTP 错误，文件名: " + file.name + "，错误消息: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_FAILED:
//			progress.setStatus("Upload Failed.");
//			this.debug("Error Code: Upload Failed, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			progress.setStatus("上传失败");
			this.debug("错误编码: 上传失败，文件名: " + file.name + "，文件大小: " + file.size + "，错误消息: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.IO_ERROR:
//			progress.setStatus("Server (IO) Error");
//			this.debug("Error Code: IO Error, File name: " + file.name + ", Message: " + message);
			progress.setStatus("服务器文件读写错误");
			this.debug("错误编码: 输入/出错误，文件名: " + file.name + "，文件名: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.SECURITY_ERROR:
//			progress.setStatus("Security Error");
//			this.debug("Error Code: Security Error, File name: " + file.name + ", Message: " + message);
			progress.setStatus("安全错误");
			this.debug("错误编码: 安全错误，文件名: " + file.name + "，错误消息: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
//			progress.setStatus("Upload limit exceeded.");
//			this.debug("Error Code: Upload Limit Exceeded, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			progress.setStatus("超过上传限制");
			this.debug("错误编码: 超过上传限制，文件名: " + file.name + "，文件大小: " + file.size + ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED:
//			progress.setStatus("Failed Validation.  Upload skipped.");
//			this.debug("Error Code: File Validation Failed, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			progress.setStatus("验证失败，上传取消");
			this.debug("错误编码: 验证失败，上传取消，文件名: " + file.name + "，文件大小: " + file.size + "，错误消息: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
			// If there aren't any files left (they were all cancelled) disable the cancel button
			if (this.getStats().files_queued === 0) {
				document.getElementById(this.customSettings.cancelButtonId).disabled = true;
				//增加隐藏的取消按钮的	sunjin	2011-11-03
				document.getElementById(this.customSettings.cancelButtonId).style.visibility = "hidden";
			}
//			progress.setStatus("Cancelled");
			progress.setStatus("已取消");
			progress.setCancelled();
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
//			progress.setStatus("Stopped");
			progress.setStatus("已停止");
			break;
		default:
//			progress.setStatus("Unhandled Error: " + errorCode);
//			this.debug("Error Code: " + errorCode + ", File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			progress.setStatus("未预期错误: " + errorCode);
			this.debug("错误编码: " + errorCode + "，文件名: " + file.name + "，文件大小: " + file.size + "，文件名: " + message);
			break;
		}
	} catch (ex) {
        this.debug(ex);
    }
}

function uploadComplete(file) {
	if (this.getStats().files_queued === 0) {
		document.getElementById(this.customSettings.cancelButtonId).disabled = true;
		//增加隐藏的取消按钮的
		document.getElementById(this.customSettings.cancelButtonId).style.visibility = "hidden";
	}
}

// This event comes from the Queue Plugin
function queueComplete(numFilesUploaded) {
	var status = document.getElementById("divStatus");
	if(status) {
		status.innerHTML = numFilesUploaded + " file" + (numFilesUploaded === 1 ? "" : "s") + " uploaded.";
	}
}
