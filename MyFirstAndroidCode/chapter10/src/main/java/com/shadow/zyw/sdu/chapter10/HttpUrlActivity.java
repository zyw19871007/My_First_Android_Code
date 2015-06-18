package com.shadow.zyw.sdu.chapter10;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class HttpUrlActivity extends ActionBarActivity {
    private final static int SHOW_RESPONSE  = 0;
    private Button send;
    private TextView response;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == SHOW_RESPONSE) {
                response.setText((CharSequence) msg.obj);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_url);
        send = (Button) findViewById(R.id.send_request);
        response = (TextView) findViewById(R.id.response);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sendWithHttpUrl();
//                sendWithHttpClient();
                String address = "http://172.20.32.95:8090/ytjyc/get_data.json";
                HttpUtil.sendHttpRequest(address, new HttpCallBackListener() {
                    @Override
                    public void onFinish(String repo) {
                        Log.d("test", "callback on finish" + repo);
                        Message msg = new Message();
                        msg.what = SHOW_RESPONSE;
                        msg.obj = repo;
                        handler.sendMessage(msg);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
            }
        });
    }

    private void sendWithHttpClient() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet("http://www.baidu.com");
                HttpResponse httpResponse = null;
                try {
                    httpResponse = httpClient.execute(httpGet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    HttpEntity httpEntity = httpResponse.getEntity();
                    try {
                        String response = EntityUtils.toString(httpEntity, "utf-8");
                        Message msg = new Message();
                        msg.what = SHOW_RESPONSE;
                        msg.obj = response.toString();
                        handler.sendMessage(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();
    }

    private void sendWithHttpUrl() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                try {
                    URL url = new URL("http://172.20.32.95:8090/ytjyc/get_data.json");
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(8000);
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    parseJsonWithJsonObject(stringBuilder.toString());
                    parseJsonWithGson(stringBuilder.toString());
                    Message msg = new Message();
                    msg.what = SHOW_RESPONSE;
                    msg.obj=stringBuilder.toString();
                    handler.sendMessage(msg);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }

            }
        }).start();
    }

    private void parseJsonWithGson(String s) {
        Gson gson = new Gson();
        List<JsonOb> list = gson.fromJson(s, new TypeToken<List<JsonOb>>() {
        }.getType());
        for (JsonOb jsonOb : list) {
            Log.d("test", jsonOb.getId());
            Log.d("test", jsonOb.getName());
            Log.d("test", jsonOb.getVersion());
        }


    }

    private void parseJsonWithJsonObject(String stringBuilder) {
        try {
            JSONArray jsonArray = new JSONArray(stringBuilder);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                Log.d("test", id);
            }
            
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_http_url, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
