package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.OrderServiceTotalRepository;
import com.example.demo.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.*;

@Service
public class StatisticalServiceImpl implements StatisticalService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderServiceTotalRepository totalRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<DataForComputer> findAllInStartTimeToEndTime(String startTime, String endTime) {
        List<DataForComputer> list = new ArrayList<>();
        Date startDate = null;
        Date endDate = null;
        try{
            startDate = format.parse(startTime);
            endDate = format.parse(endTime);
        }catch (ParseException e){
            return null;
        }
        List<Order> listOrder = this.orderRepository.findAllInStartTimeToEndTime(startDate, endDate);
        if(listOrder.isEmpty()){
            return null;
        }
        Map<String, Integer> map = new TreeMap<>();
        for (Order order : listOrder){
            if(map.containsKey(order.getComputer().getComputerId())){
                int total = map.get(order.getComputer().getComputerId());
                map.put(order.getComputer().getComputerId(), (total+order.getUsageTime()));
            }else {
                map.put(order.getComputer().getComputerId(), order.getUsageTime());
            }
        }
        Set<String> set = map.keySet();
        for (String key : set){
            list.add(new DataForComputer(key, map.get(key)));
        }
        return list;
    }

    @Override
    public List<DataForMonth> getDataByMonth(String startTime, String endTime) {
        List<DataForMonth> listDataForMonth = new ArrayList<>();
        Date startDate = null;
        Date endDate = null;
        YearMonth yearMonth = null;
        try{
            startDate = format.parse(startTime);
            endDate = format.parse(endTime);
        }catch (ParseException e) {
            return null;
        }
        if((startDate.getMonth() == endDate.getMonth()) && (startDate.getYear() == endDate.getYear())){
            this.calculateTotalMoney(startDate, endDate);
        }else{
            while(true){
                yearMonth = YearMonth.of(startDate.getMonth()+1900, startDate.getMonth()+1);
                Date temp = (Date) startDate.clone();
                temp.setDate(yearMonth.lengthOfMonth());
                listDataForMonth.add(this.calculateTotalMoney(startDate, temp));
                startDate.setMonth(startDate.getMonth()+1);
                startDate.setDate(1);
                if((startDate.getMonth() == endDate.getMonth() && (startDate.getYear()==endDate.getYear()))){
                    listDataForMonth.add(this.calculateTotalMoney(startDate, endDate));
                    break;
                }
            }
        }
        return listDataForMonth;
    }

    @Override
    public List<DataForTopAccount> getDataByAccount(String startTime, String endTime) {
        List<DataForTopAccount> list = new ArrayList<>();
        Date startDate = null;
        Date endDate = null;
        try{
            startDate = format.parse(startTime);
            endDate = format.parse(endTime);
        }catch (ParseException e) {
            return null;
        }
        List<Customer> listCustomer = this.customerRepository.findAllInStartTimeToEndTime(startDate, endDate);
        if(listCustomer.isEmpty()){
            return null;
        }
        for(Customer customer : listCustomer){
            int totalTime = 0;
            int totalMoney = 0;
            for(Order order : customer.getOrders()){
                totalTime += order.getUsageTime();
            }
            Map<Integer, Integer> mapServiceTotal = new TreeMap<>();
            for (OrderService orderService : customer.getOrderServices()){
                int key = orderService.getOrderServiceToTal().getId();
                int value = orderService.getOrderServiceToTal().getServiceTotalMoney();
                mapServiceTotal.put(key, value);
            }
            Set<Integer> set = mapServiceTotal.keySet();
            for(Integer key : set){
                totalMoney += mapServiceTotal.get(key);
            }
            list.add(new DataForTopAccount(customer.getAccount().getUserName(), totalMoney, totalTime));
        }
        return list;
    }

    private DataForMonth calculateTotalMoney(Date startDate, Date endDate){
        SimpleDateFormat month = new SimpleDateFormat("dd/MM");
        List<OrderServiceToTal> listOrderTotal = this.totalRepository.
                findAllInStartTimeToEndTime(startDate, endDate);
        List<Order> listOrder = this.orderRepository.findAllInStartTimeToEndTime(startDate, endDate);
        int totalMoneyComputer = 0;
        int totalMoneyService = 0;
        for(Order order : listOrder){
            switch (order.getComputer().getType().getTypeId()){
                case 1:
                    totalMoneyComputer += order.getUsageTime() * 10000;
                    break;
                case 2:
                    totalMoneyComputer += order.getUsageTime() * 5000;
                    break;
            }
        }
        for(OrderServiceToTal toTal : listOrderTotal){
            totalMoneyService += toTal.getServiceTotalMoney();
        }
        return new DataForMonth(month.format(startDate)+":"+month.format(endDate),
                totalMoneyService, totalMoneyComputer);
    }


}
