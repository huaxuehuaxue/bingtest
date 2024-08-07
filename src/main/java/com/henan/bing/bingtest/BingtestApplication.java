package com.henan.bing.bingtest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class BingtestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(BingtestApplication.class, args);

		try {
			String companyName = "abc";
			String url = "https://www.qcc.com/firm/g2d0d19aae7f90554d0082486a815c4e.html";

			String cookie = "your_cookie_here";

			URL url1 = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0");

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				response.append(line);
			}
			bufferedReader.close();
			Document document = Jsoup.parse(response.toString());
			System.out.println("文档内容："+response.toString());
			System.out.println("文档内容："+document.toString());



		}catch (Exception e){
			e.printStackTrace();
		}





	}
}
