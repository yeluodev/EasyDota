package com.yeluodev.easydota.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/4 15:50
 * 修改人  yeluodev1226
 * 修改时间 2018/1/4 15:50
 * 备注
 */
public class EasyDota {

	public static final String BASE_URL = "https://api.steampowered.com/";
	public static final String KEY = "896C5BE855FD71215D783D05DB7C7878";
	public static final String ACCOUNT_ID = "76561198070192227";

	private SteamService steamService;

	private static class EasyDotaHolder{
		private static final EasyDota instance = new EasyDota();
	}

	public static EasyDota getInstance(){
		return EasyDotaHolder.instance;
	}

	private EasyDota(){
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

		OkHttpClient okHttpClient = new OkHttpClient.Builder()
				.connectTimeout(10, TimeUnit.SECONDS)//设置连接超时时间
				.readTimeout(10, TimeUnit.SECONDS)//设置读取超时时间
				.writeTimeout(10, TimeUnit.SECONDS)//设置写入超时时间
				.addInterceptor(logging)//添加其他拦截器
				.build();

		Retrofit retrofit = new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.baseUrl(BASE_URL)
				.client(okHttpClient)
				.build();

		steamService = retrofit.create(SteamService.class);
	}

	public SteamService getSteamService(){
		return steamService;
	}
}
