package com.jal.http;

/**
 * Created by SEELE on 2017/4/17.
 */

public interface Api {

    String JUHE_WEATHER="http://op.juhe.cn/onebox/weather/query?cityname=%s&key=d2fe43f16a5e092b188f51cb01b71551";


    String STAR_INFO="http://api.avatardata.cn/Constellation/Query?key=b4908c82d1324ea5be5298101b2142f7&consName=%s&type=today";

    String LOGIN="http://192.168.1.30:8080/WeatherServer/LoginAction?username=%s&password=%s&style=%s";

    String REGIST="http://192.168.1.30:8080/WeatherServer/LoginAction?username=%s&password=%s&style=regist";

    String INSERT_CITY="http://192.168.1.30:8080/WeatherServer/LoginAction?username=%s&password=%s&style=insertCity&city=%s";

    String REMOVE="http://192.168.1.30:8080/WeatherServer/LoginAction?username=%s&password=%s&style=remove&city=%s";
}
