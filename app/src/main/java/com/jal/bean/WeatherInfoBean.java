package com.jal.bean;

import java.util.List;

/**
 * Created by SEELE on 2017/4/17.
 */

public class WeatherInfoBean {


    /**
     * reason : 查询成功!
     * result : {"data":{"realtime":{"city_code":"101210701","city_name":"温州","date":"2017-04-17","time":"16:00:00","week":1,"moon":"三月廿一","dataUptime":1492416971,"weather":{"temperature":"23","humidity":"89","info":"阵雨","img":"3"},"wind":{"direct":"东北风","power":"1级","offset":null,"windspeed":null}},"life":{"date":"2017-4-17","info":{"chuanyi":["较舒适","建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"],"ganmao":["较易发","相对今天出现了较大幅度降温，较易发生感冒，体质较弱的朋友请注意适当防护。"],"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"]}},"weather":[{"date":"2017-04-17","info":{"day":["3","阵雨","24","西南风","微风","05:31","出门记得带伞，行走驾驶做好防滑准备"],"night":["2","阴","18","西南风","微风","18:24","出门记得带伞，行走驾驶做好防滑准备"]},"week":"一","nongli":"三月廿一"},{"date":"2017-04-18","info":{"dawn":["2","阴","18","西南风","微风","18:24"],"day":["1","多云","29","西南风","微风","05:30"],"night":["1","多云","17","西南风","微风","18:25"]},"week":"二","nongli":"三月廿二"},{"date":"2017-04-19","info":{"dawn":["1","多云","17","西南风","微风","18:25"],"day":["7","小雨","23","东北风","微风","05:29"],"night":["3","阵雨","18","东北风","微风","18:25"]},"week":"三","nongli":"三月廿三"},{"date":"2017-04-20","info":{"dawn":["3","阵雨","18","东北风","微风","18:25"],"day":["7","小雨","25","东北风","微风","05:28"],"night":["3","阵雨","16","东北风","微风","18:26"]},"week":"四","nongli":"三月廿四"},{"date":"2017-04-21","info":{"dawn":["3","阵雨","16","东北风","微风","18:26"],"day":["1","多云","22","东北风","微风","05:27"],"night":["1","多云","15","东北风","微风","18:27"]},"week":"五","nongli":"三月廿五"}],"f3h":{"temperature":[{"jg":"20170417140000","jb":"23"},{"jg":"20170417170000","jb":"21"},{"jg":"20170417200000","jb":"20"},{"jg":"20170417230000","jb":"19"},{"jg":"20170418020000","jb":"19"},{"jg":"20170418050000","jb":"18"},{"jg":"20170418080000","jb":"19"},{"jg":"20170418110000","jb":"29"},{"jg":"20170418140000","jb":"25"}],"precipitation":[{"jg":"20170417140000","jf":"14.2"},{"jg":"20170417170000","jf":"4.1"},{"jg":"20170417200000","jf":"1.9"},{"jg":"20170417230000","jf":"0"},{"jg":"20170418020000","jf":"0"},{"jg":"20170418050000","jf":"0"},{"jg":"20170418080000","jf":"0"},{"jg":"20170418110000","jf":"0"},{"jg":"20170418140000","jf":"0"}]},"pm25":{"key":"Wenzhou","show_desc":0,"pm25":{"curPm":"147","pm25":"111","pm10":"168","level":3,"quality":"轻度污染","des":"敏感人群应避免高强度户外锻炼，外出时做好防护措施"},"dateTime":"2017年04月17日15时","cityName":"温州"},"jingqu":"","jingqutq":"","date":"","isForeign":"0"}}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    @Override
    public String toString() {
        return "WeatherInfoBean{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * data : {"realtime":{"city_code":"101210701","city_name":"温州","date":"2017-04-17","time":"16:00:00","week":1,"moon":"三月廿一","dataUptime":1492416971,"weather":{"temperature":"23","humidity":"89","info":"阵雨","img":"3"},"wind":{"direct":"东北风","power":"1级","offset":null,"windspeed":null}},"life":{"date":"2017-4-17","info":{"chuanyi":["较舒适","建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"],"ganmao":["较易发","相对今天出现了较大幅度降温，较易发生感冒，体质较弱的朋友请注意适当防护。"],"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"]}},"weather":[{"date":"2017-04-17","info":{"day":["3","阵雨","24","西南风","微风","05:31","出门记得带伞，行走驾驶做好防滑准备"],"night":["2","阴","18","西南风","微风","18:24","出门记得带伞，行走驾驶做好防滑准备"]},"week":"一","nongli":"三月廿一"},{"date":"2017-04-18","info":{"dawn":["2","阴","18","西南风","微风","18:24"],"day":["1","多云","29","西南风","微风","05:30"],"night":["1","多云","17","西南风","微风","18:25"]},"week":"二","nongli":"三月廿二"},{"date":"2017-04-19","info":{"dawn":["1","多云","17","西南风","微风","18:25"],"day":["7","小雨","23","东北风","微风","05:29"],"night":["3","阵雨","18","东北风","微风","18:25"]},"week":"三","nongli":"三月廿三"},{"date":"2017-04-20","info":{"dawn":["3","阵雨","18","东北风","微风","18:25"],"day":["7","小雨","25","东北风","微风","05:28"],"night":["3","阵雨","16","东北风","微风","18:26"]},"week":"四","nongli":"三月廿四"},{"date":"2017-04-21","info":{"dawn":["3","阵雨","16","东北风","微风","18:26"],"day":["1","多云","22","东北风","微风","05:27"],"night":["1","多云","15","东北风","微风","18:27"]},"week":"五","nongli":"三月廿五"}],"f3h":{"temperature":[{"jg":"20170417140000","jb":"23"},{"jg":"20170417170000","jb":"21"},{"jg":"20170417200000","jb":"20"},{"jg":"20170417230000","jb":"19"},{"jg":"20170418020000","jb":"19"},{"jg":"20170418050000","jb":"18"},{"jg":"20170418080000","jb":"19"},{"jg":"20170418110000","jb":"29"},{"jg":"20170418140000","jb":"25"}],"precipitation":[{"jg":"20170417140000","jf":"14.2"},{"jg":"20170417170000","jf":"4.1"},{"jg":"20170417200000","jf":"1.9"},{"jg":"20170417230000","jf":"0"},{"jg":"20170418020000","jf":"0"},{"jg":"20170418050000","jf":"0"},{"jg":"20170418080000","jf":"0"},{"jg":"20170418110000","jf":"0"},{"jg":"20170418140000","jf":"0"}]},"pm25":{"key":"Wenzhou","show_desc":0,"pm25":{"curPm":"147","pm25":"111","pm10":"168","level":3,"quality":"轻度污染","des":"敏感人群应避免高强度户外锻炼，外出时做好防护措施"},"dateTime":"2017年04月17日15时","cityName":"温州"},"jingqu":"","jingqutq":"","date":"","isForeign":"0"}
         */

        private DataBean data;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "data=" + data +
                    '}';
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * realtime : {"city_code":"101210701","city_name":"温州","date":"2017-04-17","time":"16:00:00","week":1,"moon":"三月廿一","dataUptime":1492416971,"weather":{"temperature":"23","humidity":"89","info":"阵雨","img":"3"},"wind":{"direct":"东北风","power":"1级","offset":null,"windspeed":null}}
             * life : {"date":"2017-4-17","info":{"chuanyi":["较舒适","建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"],"ganmao":["较易发","相对今天出现了较大幅度降温，较易发生感冒，体质较弱的朋友请注意适当防护。"],"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"]}}
             * weather : [{"date":"2017-04-17","info":{"day":["3","阵雨","24","西南风","微风","05:31","出门记得带伞，行走驾驶做好防滑准备"],"night":["2","阴","18","西南风","微风","18:24","出门记得带伞，行走驾驶做好防滑准备"]},"week":"一","nongli":"三月廿一"},{"date":"2017-04-18","info":{"dawn":["2","阴","18","西南风","微风","18:24"],"day":["1","多云","29","西南风","微风","05:30"],"night":["1","多云","17","西南风","微风","18:25"]},"week":"二","nongli":"三月廿二"},{"date":"2017-04-19","info":{"dawn":["1","多云","17","西南风","微风","18:25"],"day":["7","小雨","23","东北风","微风","05:29"],"night":["3","阵雨","18","东北风","微风","18:25"]},"week":"三","nongli":"三月廿三"},{"date":"2017-04-20","info":{"dawn":["3","阵雨","18","东北风","微风","18:25"],"day":["7","小雨","25","东北风","微风","05:28"],"night":["3","阵雨","16","东北风","微风","18:26"]},"week":"四","nongli":"三月廿四"},{"date":"2017-04-21","info":{"dawn":["3","阵雨","16","东北风","微风","18:26"],"day":["1","多云","22","东北风","微风","05:27"],"night":["1","多云","15","东北风","微风","18:27"]},"week":"五","nongli":"三月廿五"}]
             * f3h : {"temperature":[{"jg":"20170417140000","jb":"23"},{"jg":"20170417170000","jb":"21"},{"jg":"20170417200000","jb":"20"},{"jg":"20170417230000","jb":"19"},{"jg":"20170418020000","jb":"19"},{"jg":"20170418050000","jb":"18"},{"jg":"20170418080000","jb":"19"},{"jg":"20170418110000","jb":"29"},{"jg":"20170418140000","jb":"25"}],"precipitation":[{"jg":"20170417140000","jf":"14.2"},{"jg":"20170417170000","jf":"4.1"},{"jg":"20170417200000","jf":"1.9"},{"jg":"20170417230000","jf":"0"},{"jg":"20170418020000","jf":"0"},{"jg":"20170418050000","jf":"0"},{"jg":"20170418080000","jf":"0"},{"jg":"20170418110000","jf":"0"},{"jg":"20170418140000","jf":"0"}]}
             * pm25 : {"key":"Wenzhou","show_desc":0,"pm25":{"curPm":"147","pm25":"111","pm10":"168","level":3,"quality":"轻度污染","des":"敏感人群应避免高强度户外锻炼，外出时做好防护措施"},"dateTime":"2017年04月17日15时","cityName":"温州"}
             * jingqu :
             * jingqutq :
             * date :
             * isForeign : 0
             */

            private RealtimeBean realtime;
            private LifeBean life;
            private F3hBean f3h;
            private Pm25BeanX pm25;
            private String jingqu;
            private String jingqutq;
            private String date;
            private String isForeign;
            private List<WeatherBeanX> weather;

            @Override
            public String toString() {
                return "DataBean{" +
                        "realtime=" + realtime +
                        ", life=" + life +
                        ", f3h=" + f3h +
                        ", pm25=" + pm25 +
                        ", jingqu='" + jingqu + '\'' +
                        ", jingqutq='" + jingqutq + '\'' +
                        ", date='" + date + '\'' +
                        ", isForeign='" + isForeign + '\'' +
                        ", weather=" + weather +
                        '}';
            }

            public RealtimeBean getRealtime() {
                return realtime;
            }

            public void setRealtime(RealtimeBean realtime) {
                this.realtime = realtime;
            }

            public LifeBean getLife() {
                return life;
            }

            public void setLife(LifeBean life) {
                this.life = life;
            }

            public F3hBean getF3h() {
                return f3h;
            }

            public void setF3h(F3hBean f3h) {
                this.f3h = f3h;
            }

            public Pm25BeanX getPm25() {
                return pm25;
            }

            public void setPm25(Pm25BeanX pm25) {
                this.pm25 = pm25;
            }

            public String getJingqu() {
                return jingqu;
            }

            public void setJingqu(String jingqu) {
                this.jingqu = jingqu;
            }

            public String getJingqutq() {
                return jingqutq;
            }

            public void setJingqutq(String jingqutq) {
                this.jingqutq = jingqutq;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getIsForeign() {
                return isForeign;
            }

            public void setIsForeign(String isForeign) {
                this.isForeign = isForeign;
            }

            public List<WeatherBeanX> getWeather() {
                return weather;
            }

            public void setWeather(List<WeatherBeanX> weather) {
                this.weather = weather;
            }

            public static class RealtimeBean {
                /**
                 * city_code : 101210701
                 * city_name : 温州
                 * date : 2017-04-17
                 * time : 16:00:00
                 * week : 1
                 * moon : 三月廿一
                 * dataUptime : 1492416971
                 * weather : {"temperature":"23","humidity":"89","info":"阵雨","img":"3"}
                 * wind : {"direct":"东北风","power":"1级","offset":null,"windspeed":null}
                 */

                private String city_code;
                private String city_name;
                private String date;
                private String time;
                private int week;
                private String moon;
                private int dataUptime;
                private WeatherBean weather;
                private WindBean wind;

                @Override
                public String toString() {
                    return "RealtimeBean{" +
                            "city_code='" + city_code + '\'' +
                            ", city_name='" + city_name + '\'' +
                            ", date='" + date + '\'' +
                            ", time='" + time + '\'' +
                            ", week=" + week +
                            ", moon='" + moon + '\'' +
                            ", dataUptime=" + dataUptime +
                            ", weather=" + weather +
                            ", wind=" + wind +
                            '}';
                }

                public String getCity_code() {
                    return city_code;
                }

                public void setCity_code(String city_code) {
                    this.city_code = city_code;
                }

                public String getCity_name() {
                    return city_name;
                }

                public void setCity_name(String city_name) {
                    this.city_name = city_name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public int getWeek() {
                    return week;
                }

                public void setWeek(int week) {
                    this.week = week;
                }

                public String getMoon() {
                    return moon;
                }

                public void setMoon(String moon) {
                    this.moon = moon;
                }

                public int getDataUptime() {
                    return dataUptime;
                }

                public void setDataUptime(int dataUptime) {
                    this.dataUptime = dataUptime;
                }

                public WeatherBean getWeather() {
                    return weather;
                }

                public void setWeather(WeatherBean weather) {
                    this.weather = weather;
                }

                public WindBean getWind() {
                    return wind;
                }

                public void setWind(WindBean wind) {
                    this.wind = wind;
                }

                public static class WeatherBean {
                    /**
                     * temperature : 23
                     * humidity : 89
                     * info : 阵雨
                     * img : 3
                     */

                    private String temperature;
                    private String humidity;
                    private String info;
                    private String img;

                    @Override
                    public String toString() {
                        return "WeatherBean{" +
                                "temperature='" + temperature + '\'' +
                                ", humidity='" + humidity + '\'' +
                                ", info='" + info + '\'' +
                                ", img='" + img + '\'' +
                                '}';
                    }

                    public String getTemperature() {
                        return temperature;
                    }

                    public void setTemperature(String temperature) {
                        this.temperature = temperature;
                    }

                    public String getHumidity() {
                        return humidity;
                    }

                    public void setHumidity(String humidity) {
                        this.humidity = humidity;
                    }

                    public String getInfo() {
                        return info;
                    }

                    public void setInfo(String info) {
                        this.info = info;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }
                }

                public static class WindBean {
                    /**
                     * direct : 东北风
                     * power : 1级
                     * offset : null
                     * windspeed : null
                     */

                    private String direct;
                    private String power;
                    private Object offset;
                    private Object windspeed;

                    @Override
                    public String toString() {
                        return "WindBean{" +
                                "direct='" + direct + '\'' +
                                ", power='" + power + '\'' +
                                ", offset=" + offset +
                                ", windspeed=" + windspeed +
                                '}';
                    }

                    public String getDirect() {
                        return direct;
                    }

                    public void setDirect(String direct) {
                        this.direct = direct;
                    }

                    public String getPower() {
                        return power;
                    }

                    public void setPower(String power) {
                        this.power = power;
                    }

                    public Object getOffset() {
                        return offset;
                    }

                    public void setOffset(Object offset) {
                        this.offset = offset;
                    }

                    public Object getWindspeed() {
                        return windspeed;
                    }

                    public void setWindspeed(Object windspeed) {
                        this.windspeed = windspeed;
                    }
                }
            }

            public static class LifeBean {
                /**
                 * date : 2017-4-17
                 * info : {"chuanyi":["较舒适","建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"],"ganmao":["较易发","相对今天出现了较大幅度降温，较易发生感冒，体质较弱的朋友请注意适当防护。"],"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"]}
                 */

                private String date;
                private InfoBean info;


                @Override
                public String toString() {
                    return "LifeBean{" +
                            "date='" + date + '\'' +
                            ", info=" + info +
                            '}';
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public static class InfoBean {
                    private List<String> chuanyi;
                    private List<String> ganmao;
                    private List<String> kongtiao;
                    private List<String> xiche;
                    private List<String> yundong;
                    private List<String> ziwaixian;

                    @Override
                    public String toString() {
                        return "InfoBean{" +
                                "chuanyi=" + chuanyi +
                                ", ganmao=" + ganmao +
                                ", kongtiao=" + kongtiao +
                                ", xiche=" + xiche +
                                ", yundong=" + yundong +
                                ", ziwaixian=" + ziwaixian +
                                '}';
                    }

                    public List<String> getChuanyi() {
                        return chuanyi;
                    }

                    public void setChuanyi(List<String> chuanyi) {
                        this.chuanyi = chuanyi;
                    }

                    public List<String> getGanmao() {
                        return ganmao;
                    }

                    public void setGanmao(List<String> ganmao) {
                        this.ganmao = ganmao;
                    }

                    public List<String> getKongtiao() {
                        return kongtiao;
                    }

                    public void setKongtiao(List<String> kongtiao) {
                        this.kongtiao = kongtiao;
                    }

                    public List<String> getXiche() {
                        return xiche;
                    }

                    public void setXiche(List<String> xiche) {
                        this.xiche = xiche;
                    }

                    public List<String> getYundong() {
                        return yundong;
                    }

                    public void setYundong(List<String> yundong) {
                        this.yundong = yundong;
                    }

                    public List<String> getZiwaixian() {
                        return ziwaixian;
                    }

                    public void setZiwaixian(List<String> ziwaixian) {
                        this.ziwaixian = ziwaixian;
                    }
                }
            }

            public static class F3hBean {
                private List<TemperatureBean> temperature;
                private List<PrecipitationBean> precipitation;

                @Override
                public String toString() {
                    return "F3hBean{" +
                            "temperature=" + temperature +
                            ", precipitation=" + precipitation +
                            '}';
                }

                public List<TemperatureBean> getTemperature() {
                    return temperature;
                }

                public void setTemperature(List<TemperatureBean> temperature) {
                    this.temperature = temperature;
                }

                public List<PrecipitationBean> getPrecipitation() {
                    return precipitation;
                }

                public void setPrecipitation(List<PrecipitationBean> precipitation) {
                    this.precipitation = precipitation;
                }

                public static class TemperatureBean {
                    /**
                     * jg : 20170417140000
                     * jb : 23
                     */

                    private String jg;
                    private String jb;

                    @Override
                    public String toString() {
                        return "TemperatureBean{" +
                                "jg='" + jg + '\'' +
                                ", jb='" + jb + '\'' +
                                '}';
                    }

                    public String getJg() {
                        return jg;
                    }

                    public void setJg(String jg) {
                        this.jg = jg;
                    }

                    public String getJb() {
                        return jb;
                    }

                    public void setJb(String jb) {
                        this.jb = jb;
                    }
                }

                public static class PrecipitationBean {
                    /**
                     * jg : 20170417140000
                     * jf : 14.2
                     */

                    private String jg;
                    private String jf;

                    @Override
                    public String toString() {
                        return "PrecipitationBean{" +
                                "jg='" + jg + '\'' +
                                ", jf='" + jf + '\'' +
                                '}';
                    }

                    public String getJg() {
                        return jg;
                    }

                    public void setJg(String jg) {
                        this.jg = jg;
                    }

                    public String getJf() {
                        return jf;
                    }

                    public void setJf(String jf) {
                        this.jf = jf;
                    }
                }
            }

            public static class Pm25BeanX {
                /**
                 * key : Wenzhou
                 * show_desc : 0
                 * pm25 : {"curPm":"147","pm25":"111","pm10":"168","level":3,"quality":"轻度污染","des":"敏感人群应避免高强度户外锻炼，外出时做好防护措施"}
                 * dateTime : 2017年04月17日15时
                 * cityName : 温州
                 */

                private String key;
                private int show_desc;
                private Pm25Bean pm25;
                private String dateTime;
                private String cityName;

                @Override
                public String toString() {
                    return "Pm25BeanX{" +
                            "key='" + key + '\'' +
                            ", show_desc=" + show_desc +
                            ", pm25=" + pm25 +
                            ", dateTime='" + dateTime + '\'' +
                            ", cityName='" + cityName + '\'' +
                            '}';
                }

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public int getShow_desc() {
                    return show_desc;
                }

                public void setShow_desc(int show_desc) {
                    this.show_desc = show_desc;
                }

                public Pm25Bean getPm25() {
                    return pm25;
                }

                public void setPm25(Pm25Bean pm25) {
                    this.pm25 = pm25;
                }

                public String getDateTime() {
                    return dateTime;
                }

                public void setDateTime(String dateTime) {
                    this.dateTime = dateTime;
                }

                public String getCityName() {
                    return cityName;
                }

                public void setCityName(String cityName) {
                    this.cityName = cityName;
                }

                public static class Pm25Bean {
                    /**
                     * curPm : 147
                     * pm25 : 111
                     * pm10 : 168
                     * level : 3
                     * quality : 轻度污染
                     * des : 敏感人群应避免高强度户外锻炼，外出时做好防护措施
                     */

                    private String curPm;
                    private String pm25;
                    private String pm10;
                    private int level;
                    private String quality;
                    private String des;

                    @Override
                    public String toString() {
                        return "Pm25Bean{" +
                                "curPm='" + curPm + '\'' +
                                ", pm25='" + pm25 + '\'' +
                                ", pm10='" + pm10 + '\'' +
                                ", level=" + level +
                                ", quality='" + quality + '\'' +
                                ", des='" + des + '\'' +
                                '}';
                    }

                    public String getCurPm() {
                        return curPm;
                    }

                    public void setCurPm(String curPm) {
                        this.curPm = curPm;
                    }

                    public String getPm25() {
                        return pm25;
                    }

                    public void setPm25(String pm25) {
                        this.pm25 = pm25;
                    }

                    public String getPm10() {
                        return pm10;
                    }

                    public void setPm10(String pm10) {
                        this.pm10 = pm10;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getQuality() {
                        return quality;
                    }

                    public void setQuality(String quality) {
                        this.quality = quality;
                    }

                    public String getDes() {
                        return des;
                    }

                    public void setDes(String des) {
                        this.des = des;
                    }
                }
            }

            public static class WeatherBeanX {
                /**
                 * date : 2017-04-17
                 * info : {"day":["3","阵雨","24","西南风","微风","05:31","出门记得带伞，行走驾驶做好防滑准备"],"night":["2","阴","18","西南风","微风","18:24","出门记得带伞，行走驾驶做好防滑准备"]}
                 * week : 一
                 * nongli : 三月廿一
                 */

                private String date;
                private InfoBeanX info;
                private String week;
                private String nongli;

                @Override
                public String toString() {
                    return "WeatherBeanX{" +
                            "date='" + date + '\'' +
                            ", info=" + info +
                            ", week='" + week + '\'' +
                            ", nongli='" + nongli + '\'' +
                            '}';
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBeanX getInfo() {
                    return info;
                }

                public void setInfo(InfoBeanX info) {
                    this.info = info;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getNongli() {
                    return nongli;
                }

                public void setNongli(String nongli) {
                    this.nongli = nongli;
                }

                public static class InfoBeanX {
                    private List<String> day;
                    private List<String> night;

                    @Override
                    public String toString() {
                        return "InfoBeanX{" +
                                "day=" + day +
                                ", night=" + night +
                                '}';
                    }

                    public List<String> getDay() {
                        return day;
                    }

                    public void setDay(List<String> day) {
                        this.day = day;
                    }

                    public List<String> getNight() {
                        return night;
                    }

                    public void setNight(List<String> night) {
                        this.night = night;
                    }
                }
            }
        }
    }
}
