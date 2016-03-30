package com.app.sxgwma.task;

import android.content.Context;
import android.os.AsyncTask;


import com.app.sxgwma.util.FileUtils;

import java.io.File;

/**
 * 删除文件-Task
 * 
 * @author Frank
 *
 */
public class FileDeleteAsyncTask extends AsyncTask<File, Void, Boolean> {

	public FileDeleteAsyncTask(Context context) {

	}

	private OnResponseListener onResponseListener;

	@Override
	protected void onPreExecute() {
		super.onPreExecute();

	}

	@Override
	protected Boolean doInBackground(File... params) {
		return FileUtils.delete(params[0]);
	}

	@Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		if (null != onResponseListener) {
			onResponseListener.onResponse(String.valueOf(result));
		}
	}

	public OnResponseListener getResponseListener() {
		return onResponseListener;
	}

	public void setOnResponseListener(OnResponseListener onResponseListener) {
		this.onResponseListener = onResponseListener;
	}
}
