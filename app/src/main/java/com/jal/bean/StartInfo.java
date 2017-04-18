package com.jal.bean;

/**
 * Created by SEELE on 2017/4/18.
 */

public class StartInfo {

    /**
     * result1 : {"resultcode":"200","error_code":"0","name":"狮子座","datetime":"2017年04月18日","date":"20170418","all":"20%","color":"白色","health":"40%","love":"20%","money":"20%","number":"4","QFriend":"双鱼座","summary":"身体注意，容易呼吸道出问题，炎症等。外出游玩注意安全。另外，不要挑战领导上司的权威，服从工作安排。","work":"20%"}
     * result2 : null
     * error_code : 0
     * reason : Succes
     */

    private Result1Bean result1;
    private Object result2;
    private int error_code;
    private String reason;

    @Override
    public String toString() {
        return "StartInfo{" +
                "result1=" + result1 +
                ", result2=" + result2 +
                ", error_code=" + error_code +
                ", reason='" + reason + '\'' +
                '}';
    }

    public Result1Bean getResult1() {
        return result1;
    }

    public void setResult1(Result1Bean result1) {
        this.result1 = result1;
    }

    public Object getResult2() {
        return result2;
    }

    public void setResult2(Object result2) {
        this.result2 = result2;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class Result1Bean {
        /**
         * resultcode : 200
         * error_code : 0
         * name : 狮子座
         * datetime : 2017年04月18日
         * date : 20170418
         * all : 20%
         * color : 白色
         * health : 40%
         * love : 20%
         * money : 20%
         * number : 4
         * QFriend : 双鱼座
         * summary : 身体注意，容易呼吸道出问题，炎症等。外出游玩注意安全。另外，不要挑战领导上司的权威，服从工作安排。
         * work : 20%
         */

        private String resultcode;
        private String error_code;
        private String name;
        private String datetime;
        private String date;
        private String all;
        private String color;
        private String health;
        private String love;
        private String money;
        private String number;
        private String QFriend;
        private String summary;
        private String work;

        @Override
        public String toString() {
            return "Result1Bean{" +
                    "resultcode='" + resultcode + '\'' +
                    ", error_code='" + error_code + '\'' +
                    ", name='" + name + '\'' +
                    ", datetime='" + datetime + '\'' +
                    ", date='" + date + '\'' +
                    ", all='" + all + '\'' +
                    ", color='" + color + '\'' +
                    ", health='" + health + '\'' +
                    ", love='" + love + '\'' +
                    ", money='" + money + '\'' +
                    ", number='" + number + '\'' +
                    ", QFriend='" + QFriend + '\'' +
                    ", summary='" + summary + '\'' +
                    ", work='" + work + '\'' +
                    '}';
        }

        public String getResultcode() {
            return resultcode;
        }

        public void setResultcode(String resultcode) {
            this.resultcode = resultcode;
        }

        public String getError_code() {
            return error_code;
        }

        public void setError_code(String error_code) {
            this.error_code = error_code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = health;
        }

        public String getLove() {
            return love;
        }

        public void setLove(String love) {
            this.love = love;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getQFriend() {
            return QFriend;
        }

        public void setQFriend(String QFriend) {
            this.QFriend = QFriend;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getWork() {
            return work;
        }

        public void setWork(String work) {
            this.work = work;
        }
    }
}
