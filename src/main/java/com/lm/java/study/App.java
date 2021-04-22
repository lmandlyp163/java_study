package com.lm.java.study;

import com.google.common.collect.Lists;
import com.sankuai.meituan.banma.biz.common.util.JsonUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String  test = "{\"mtUserToken\":\"tULIZq8aB6G8JUgNWOzMLq4e6EUAAAAAaQwAAEZPUFW6uIf0k_WIaSDkeQK3crLb3-nvSuoGw2CknqAD8LtvGRMDsZ75RIDdqxxbHw\",\"speed\":\"0.0\",\"mtUserId\":\"1476546437\",\"provider\":\"network\",\"osType\":\"1\",\"city_id\":\"653226\",\"fingerprint\":\"dfp_1.4.0.41_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\\u003d\",\"referPage\":\"\",\"appVersion\":\"7.0.2.184\",\"orderParam\":\"[{\\\"couponViewId\\\":\\\"0\\\",\\\"orderToken\\\":\\\"\\\",\\\"providerId\\\":239,\\\"productsParam\\\":[{\\\"skuId\\\":5009,\\\"spuId\\\":11016,\\\"count\\\":5,\\\"spuAttrIds\\\":[9096,9097]},{\\\"skuId\\\":8012,\\\"spuId\\\":11017,\\\"count\\\":4,\\\"spuAttrIds\\\":[8039,8040]},{\\\"skuId\\\":8013,\\\"spuId\\\":11017,\\\"count\\\":6,\\\"spuAttrIds\\\":[8039,8040]}],\\\"recipientAddress\\\":\\\"新疆维吾尔自治区 和田地区 和田 测试\\\",\\\"recipientCityId\\\":653200,\\\"recipientName\\\":\\\"章淑琴\\\",\\\"recipientPhone\\\":\\\"13823121501\\\"}]\",\"longitude\":\"104.057438\",\"latitude\":\"30.559846\",\"uuid\":\"00000000000000FB68CC09CE149D381DE1C92062825E1A159260906337221426\",\"accuracy\":\"40.0\",\"appType\":\"1\"}";
        HashMap<String,String> map = (HashMap<String,String>)JsonUtils.decode(test, HashMap.class);
//        Map<String, String> paramMap = JsonUtil.decode(test, new ParameterizedTypeReference<Map<String, Object>>() {
//        });
//        System.out.println(JacksonUtils.serialize(map));


        ArrayList<Date> lista = Lists.newArrayList(new Date());
        System.out.println(JsonUtils.encode(lista));
        ArrayList<Date> listb = (ArrayList<Date>)lista.clone();
        listb.set(0,new Date(111111111)) ;
        System.out.println(JsonUtils.encode(lista));
        System.out.println(JsonUtils.encode(listb));



    }


}
