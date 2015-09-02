package com.eitan.recall.rest.yahoo.shopping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.LogMF;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.eitan.recall.util.RecallUtils;

import net.sf.json.JSONArray;

//import org.apache.log4j.LogMF;
//
//import com.mcdonalds.bdh.CRMApiClient;
//import com.mcdonalds.bdh.CRMUtils;
//import com.mcdonalds.bdh.CRMApiClient.RequierdProperty;
//import com.mcdonalds.bdh.CRMApiClient.VMobAPIProperties;

public class ItemSearchApiClient {
	private static final Logger logger = LogManager.getLogger(ItemSearchApiClient.class);

	private ItemSearchApiClient(){
		
	}
	
	public static String invoke (String appid,String query) throws Exception{
		try {
			ItemSearchApiClient client = new ItemSearchApiClient();
			StringBuffer sb = new StringBuffer ();
			sb.append("http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch");
			sb.append("?");
			sb.append("appid=");
			sb.append(appid);
			sb.append("&");
			sb.append("query=");
			sb.append(URLEncoder.encode(query,"utf-8"));
			sb.append("&");
			sb.append("hits=1");
			System.out.println(sb.toString());
			String resp = client.perform(sb.toString(), 30000);
			return resp;
//			return RecallUtils.toJson(resp);
//			if (!client.validate(RequierdProperty.values(), System.getProperties())){
//				throw new IllegalArgumentException();
//			}
			// connection phase
//			List<byte []> binaryList = client.retrieveConsumers(
//			createURLAsString(vmob.getAzureEndpoint(), vmob.getAzureSV(), vmob.getAzureTN(),
//					vmob.getAzureSIG(), vmob.getAzureSE(), vmob.getAzureSP(), vmob.getAzureFilter(),
//					vmob.getAzureTop()), Integer.valueOf(vmob.getTimeout()));
//			
//			JSONArray value = (JSONArray)CRMUtils.uncompress(binaryList.get(0));
//			if (value.size() <= 0) {
//				logger.warn("no data found");
//			}
//
//			logger.info( "HTTPS connection phase has been successfully.");
//			// output phase
//			int wc = client.createTSVFile(binaryList, tsv);
//			LogMF.info(logger, "TSV output phase has been successfully.<<wc: {0}>>", String.valueOf(wc));
		} catch (Exception e) {
//			logger.error( "critical error occurred.", e);
			throw e;
		}
		
	}
	/**
	 * 新CRM連携APL主処理
	 * 
	 * @param args 使用しない
	 * @throws Exception 通信処理、TSV出力処理で例外が発生した場合。
	 */
	public static void main(String[] args) throws Exception {
//		final VMobAPIProperties vmob = createVMobAPIProperties(System.getProperty("AZURE_ENDPOINT"),
//				System.getProperty("AZURE_SV"), System.getProperty("AZURE_TN"), System.getProperty("AZURE_SIG"),
//				System.getProperty("AZURE_SE"), System.getProperty("AZURE_SP"), System.getProperty("AZURE_FILTER"),
//				System.getProperty("AZURE_TOP"), System.getProperty("TIMEOUT"));
//		final String tsv = System.getProperty("TSV_PATH");

		try {
			ItemSearchApiClient client = new ItemSearchApiClient();
			StringBuffer sb = new StringBuffer ();
			sb.append("http://auctions.yahooapis.jp/AuctionWebService/V2/search");
			sb.append("?");
			sb.append("appid=dj0zaiZpPWlwa2VqOGRqQVFmbSZzPWNvbnN1bWVyc2VjcmV0Jng9Yjc-");
			sb.append("&");
			sb.append("output=json");
			sb.append("&");
			sb.append("category=23336");
			sb.append("&");
			sb.append("query=lenovo");
			sb.append("&");
			sb.append("sort=end");
			System.out.println(sb.toString());
			String resp = client.perform(sb.toString(), 500);
//			if (!client.validate(RequierdProperty.values(), System.getProperties())){
//				throw new IllegalArgumentException();
//			}
			// connection phase
//			List<byte []> binaryList = client.retrieveConsumers(
//			createURLAsString(vmob.getAzureEndpoint(), vmob.getAzureSV(), vmob.getAzureTN(),
//					vmob.getAzureSIG(), vmob.getAzureSE(), vmob.getAzureSP(), vmob.getAzureFilter(),
//					vmob.getAzureTop()), Integer.valueOf(vmob.getTimeout()));
//			
//			JSONArray value = (JSONArray)CRMUtils.uncompress(binaryList.get(0));
//			if (value.size() <= 0) {
//				logger.warn("no data found");
//			}
//
//			logger.info( "HTTPS connection phase has been successfully.");
//			// output phase
//			int wc = client.createTSVFile(binaryList, tsv);
//			LogMF.info(logger, "TSV output phase has been successfully.<<wc: {0}>>", String.valueOf(wc));
		} catch (Exception e) {
//			logger.error( "critical error occurred.", e);
			throw e;
		}
	}
	private String perform(String urlAsString, int timeout) throws IOException {
		HttpURLConnection con = null;
		BufferedReader br = null;
		try {
			URL url = new URL(urlAsString);
			con = (HttpURLConnection) url.openConnection();
			con.setDoInput(true);
			// con.setDoOutput(true); POST
			con.setConnectTimeout(timeout);
			con.setReadTimeout(timeout);
			con.setRequestMethod("GET");
			con.setUseCaches(false);
//			con.setRequestProperty("Accept", "application/json;odata=fullmetadata");
//			con.setRequestProperty("Accept", "application/json;odata=nometadata");
//			con.setRequestProperty("DataServiceVersion", "3.0;NetFx");
//			con.setRequestProperty("MaxDataServiceVersion", "3.0;NetFx");
//			con.setRequestProperty("User-Agent", "");
//			SimpleDateFormat fmt = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.US);
//			fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
//			String date = fmt.format(Calendar.getInstance().getTime()) + " GMT";
//			con.setRequestProperty("x-ms-date", date);
			try {
				br = new BufferedReader(new InputStreamReader(this.retrieveInputStream(con)));

			} catch (IOException ioe) {
				// handshake failed,timeout
				logger.error( "HTTPS connection failed", ioe);
				throw ioe;
			}

			final int responseCode = con.getResponseCode();
			StringBuffer json = new StringBuffer();
			for (;;) {
	            String line = br.readLine();
				if (line == null) {
					break;
				}
				json.append(line);
			}
			if (responseCode != HttpURLConnection.HTTP_OK) {
				System.err.println(json);
				throw new IOException("HTTPS response code failed: " + String.valueOf(responseCode));
			} else {
				// no error found
//				String nextPartitionKeyToken = con.getHeaderField("x-ms-continuation-NextPartitionKey");
//				String nextRowKeyToken = con.getHeaderField("x-ms-continuation-NextRowKey");
				System.out.println(json.toString());
//				LogMF.info(logger, "json: {0}",json.toString());
//				return createAzureStorageResponse(nextPartitionKeyToken, nextRowKeyToken, json.toString());
				return json.toString();
			}
		} catch (IOException e) {
			logger.error( "IOException occurred: " ,e);
			throw e;
		} 
		finally {
			if (br != null) {
				try{
					br.close();
				}
				catch(IOException e){
					logger.error( "IOException occurred: " ,e);
					throw e;
				}
			}
			if (con != null) {
				con.disconnect();
			}
		}
	}
	private InputStream retrieveInputStream(HttpURLConnection con) throws IOException {
		try {
			return con.getInputStream();
		} catch (IOException ioe) {
			InputStream is = con.getErrorStream();// dead lock avoidance
			if (is != null) {
				return is;
			}
			throw ioe;
		}
	}

}
