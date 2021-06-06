package com.logicbig.example;

import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;

@Service
public class DataService {

    public Map<Integer, Double> getLineChartData(int x) {
        Map<Integer, Double> map = new HashMap<>();
		double[] values = { 5.20, 19.63, 59.01, 139.76, 300.4, 530.0, 460.5, 372. };
		
		if (x==0) {
			for (int i=0;i< values.length;i++)
				map.put(i,values[i]);
		}
		if (x==1) {
			for (int i=0;i< values.length;i++)
				map.put(i,300.);
		}
		if (x==2) {
			for (int i=0;i< values.length;i++)
				map.put(i,500.);
		}

       return map;
    }
}