package com.example.codoceanbmongo.statistic.service;

import com.example.codoceanbmongo.statistic.dto.StatisticDTO;

public interface StatisticService {
    StatisticDTO getStatistic(String authHeader);
}