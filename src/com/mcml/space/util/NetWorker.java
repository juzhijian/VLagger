/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcml.space.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.bukkit.Bukkit;

import com.mcml.space.core.VLagger;

/**
 *
 * @author Administrator
 */
public class NetWorker implements Runnable {

	public static void DownloadPlugin() {
		if (VLagger.AutoUpdate == true) {
			try {
				DowloadFile("http://bgm.mcml.space/VLagger/VLagger.jar", VLagger.PluginFile);
				VLagger.MainThis.getLogger().info("已从云端下载了最新版本的VLagger插件，玩的愉快！");
			} catch (IOException ex) {
			}
		}
	}

	public static void DowloadFile(String urlStr, File savefile) throws IOException {
		if (savefile.exists() == true) {
			savefile.delete();
		}
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(3 * 1000); // 3秒超时，不知道这样行不行
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		InputStream inputStream = conn.getInputStream();
		byte[] getData = readInputStream(inputStream);
		File file = savefile;
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getData);
		if (fos != null) {
			fos.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}
	}

	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	@Override
	public void run() {
		DownloadPlugin();
	}
}
