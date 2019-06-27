package org.plan.managementservice.general;

import org.plan.managementfacade.model.baseInfoModel.sqlModel.SerialNoRegular;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoUpdateMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;

public class SerialNumberGenerate {

    @Autowired
    private BaseInfoUpdateMapper baseInfoUpdateMapper;

    public static String getDateStr(){
        Calendar dateNow = Calendar.getInstance();
        int yearNow = dateNow.get(Calendar.YEAR);
        int monthNow = dateNow.get(Calendar.MONTH) + 1;
        int dayNow = dateNow.get(Calendar.DAY_OF_MONTH);
        String monthStr = String.format("%02d", monthNow);
        String dayStr =  String.format("%02d", dayNow);
        String dateStr = yearNow + monthStr + dayStr;
        return dateStr;
    }

    public static String generateSerialNumber(SerialNoRegular serialNoRegular){
        String dateStr = SerialNumberGenerate.getDateStr();
        int numberCount = 0;
        String numberObject = serialNoRegular.getNumberObject();
        String numberPrefix = serialNoRegular.getNumberPrefix();
        int numberLength = serialNoRegular.getNumberLength();
        switch (numberObject){
            case "系列":
                numberCount = 0;
                break;
            case "款式组":
                numberCount = 1;
                break;
            case "计划":
                numberCount = 2;
                break;
        }
        String numberString = String.format("%0" + numberLength + "d", numberCount);
        String generateNumber = numberPrefix + dateStr + numberString;
        return generateNumber;
    }

    public static String generateNumber(String numberHead, String number){
        int numberCount = 0;
        int headLength = numberHead.length();
        Calendar dateNow = Calendar.getInstance();
        int yearNow = dateNow.get(Calendar.YEAR);
        int monthNow = dateNow.get(Calendar.MONTH) + 1;
        int dayNow = dateNow.get(Calendar.DAY_OF_MONTH);
        String monthString = String.format("%02d", monthNow);
        String dayString =  String.format("%02d", dayNow);
        String timeNow = yearNow + monthString + dayString;
        if (number != null && number != ""){
            String timeGet = number.substring(headLength, headLength + 8);
            if (timeNow.equals(timeGet)){ // 如果是同一天创建的编号 计数从上一条开始
                int lastCount = Integer.parseInt(number.substring(headLength + 8));  //获得之前的编号
                numberCount = lastCount + 1;
            }
            else { // 新的一天新增编号 计数从1开始
                numberCount = 1;
            }
        }
        else { // 数据库为空 计数从1开始
            numberCount = 1;
        }
        String numberString = String.format("%03d", numberCount); // 计数小于100 补齐三位
        String generateNumber = numberHead + yearNow + monthString + dayString + numberString;
//        System.out.println(generateNumber);
        return generateNumber;
    }

    public static void main(String[] args) {
//        SerialNumberGenerate serialNumberGenerate = new SerialNumberGenerate();
//        System.out.println(serialNumberGenerate.generateNumber("KS","KS201904281111"));
        SerialNoRegular serialNoRegular = new SerialNoRegular();
        serialNoRegular.setId(1);
        serialNoRegular.setNumberPrefix("KSZ");
        serialNoRegular.setNumberLength(5);
        serialNoRegular.setNumberObject("款式组");
        System.out.println(SerialNumberGenerate.generateSerialNumber(serialNoRegular));
    }
}
