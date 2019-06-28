package org.plan.managementservice.general;

import org.plan.managementfacade.model.baseInfoModel.sqlModel.SerialNoRegular;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoUpdateMapper;
import org.plan.managementservice.mapper.infoManagement.InfoObtainMapper;
import org.plan.managementservice.mapper.planManagement.PlanObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public static String generateSerialNumber(SerialNoRegular serialNoRegular, String lastNumber){
        String dateStr = SerialNumberGenerate.getDateStr();
        int numberCount = 0;
        String numberPrefix = serialNoRegular.getNumberPrefix();
        int numberLength = serialNoRegular.getNumberLength();
        int lastNumberLength = serialNoRegular.getLastNumberLength();
        Boolean afterChangeGenerate = serialNoRegular.getAfterChangeGenerate();
        if (lastNumber != null){ // 数据库里有数据了
            if (lastNumber.length() > (numberPrefix.length() + 8 + numberLength)){ // 超限情况处理
                numberLength = numberLength + lastNumber.length() - (numberPrefix.length() + 8 + numberLength);
                lastNumberLength = lastNumberLength + lastNumber.length() - (numberPrefix.length() + 8 + lastNumberLength);
            }
            if (afterChangeGenerate == true){ // 修改以后已经生成过单号,按照之前的进行
                String lastDateStr = lastNumber.substring(lastNumber.length() - numberLength - 8 ,lastNumber.length() - numberLength);
//                System.out.println("已生成过单号情况下lastDateStr: " + lastDateStr);
                if (dateStr.equals(lastDateStr)){ // 说明是同一天的单号,count接上一条
                    int lastCount = Integer.parseInt(lastNumber.substring(lastNumber.length() - numberLength, lastNumber.length()));
                    numberCount = lastCount + 1;
                }
                else { // 新的一天的单号,count从1开始
                    numberCount = 1;
                }
            }
            else if (afterChangeGenerate == false){// 修改以后未生成过单号,count接上一条
                String lastDateStr = lastNumber.substring(lastNumber.length() - lastNumberLength - 8 ,lastNumber.length() - lastNumberLength);
//                System.out.println("修改以后未生成过单号lastDateStr: " + lastDateStr);
                if (dateStr.equals(lastDateStr)){ // 说明是同一天的单号,count接上一条
                    int lastCount = Integer.parseInt(lastNumber.substring(lastNumber.length() - lastNumberLength, lastNumber.length())); // 获取旧单号的count
                    numberCount = lastCount + 1;
                }
                else { // 新的一天的单号,count从1开始
                    numberCount = 1;
                }
            }
        }
        else { // 数据库里没数据
            numberCount = 1;
        }
        // 按照新的规则生成单号
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
        serialNoRegular.setNumberObject("款式组");
        serialNoRegular.setNumberPrefix("KSZ");
        serialNoRegular.setNumberLength(5);
        serialNoRegular.setLastNumberLength(3);
        serialNoRegular.setAfterChangeGenerate(false);
        SerialNumberGenerate serialNumberGenerate = new SerialNumberGenerate();
        System.out.println(serialNumberGenerate.generateSerialNumber(serialNoRegular,"KSZ20190627001"));

    }
}
