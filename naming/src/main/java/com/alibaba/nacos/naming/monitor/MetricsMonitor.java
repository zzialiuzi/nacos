package com.alibaba.nacos.naming.monitor;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Metrics Monitor
 *
 * @author Nacos
 */
public class MetricsMonitor {
    private static AtomicInteger mysqlHealthCheck = new AtomicInteger();
    private static AtomicInteger httpHealthCheck = new AtomicInteger();
    private static AtomicInteger tcpHealthCheck = new AtomicInteger();
    private static AtomicInteger domCount = new AtomicInteger();
    private static AtomicInteger ipCount = new AtomicInteger();
    private static AtomicLong maxPushCost = new AtomicLong();
    private static AtomicLong avgPushCost = new AtomicLong();
    private static AtomicLong leaderStatus = new AtomicLong();
    private static AtomicInteger totalPush = new AtomicInteger();
    private static AtomicInteger failedPush = new AtomicInteger();

    static {
        List<Tag> tags = new ArrayList<>();
        tags.add(Tag.of("module", "naming"));
        tags.add(Tag.of("name", "mysqlhealthCheck"));
        Metrics.gauge("nacos_monitor", tags, mysqlHealthCheck);

        tags = new ArrayList<>();
        tags.add(Tag.of("module", "naming"));
        tags.add(Tag.of("name", "httpHealthCheck"));
        Metrics.gauge("nacos_monitor", tags, httpHealthCheck);

        tags = new ArrayList<>();
        tags.add(Tag.of("module", "naming"));
        tags.add(Tag.of("name", "tcpHealthCheck"));
        Metrics.gauge("nacos_monitor", tags, tcpHealthCheck);

        tags = new ArrayList<>();
        tags.add(Tag.of("module", "naming"));
        tags.add(Tag.of("name", "domCount"));
        Metrics.gauge("nacos_monitor", tags, domCount);

        tags = new ArrayList<>();
        tags.add(Tag.of("module", "naming"));
        tags.add(Tag.of("name", "ipCount"));
        Metrics.gauge("nacos_monitor", tags, ipCount);

        tags = new ArrayList<>();
        tags.add(Tag.of("module", "naming"));
        tags.add(Tag.of("name", "maxPushCost"));
        Metrics.gauge("nacos_monitor", tags, maxPushCost);

        tags = new ArrayList<>();
        tags.add(Tag.of("module", "naming"));
        tags.add(Tag.of("name", "avgPushCost"));
        Metrics.gauge("nacos_monitor", tags, avgPushCost);

        tags = new ArrayList<>();
        tags.add(Tag.of("module", "naming"));
        tags.add(Tag.of("name", "leaderStatus"));
        Metrics.gauge("nacos_monitor", tags, leaderStatus);

        tags = new ArrayList<>();
        tags.add(Tag.of("module", "naming"));
        tags.add(Tag.of("name", "totalPush"));
        Metrics.gauge("nacos_monitor", tags, totalPush);

        tags = new ArrayList<>();
        tags.add(Tag.of("module", "naming"));
        tags.add(Tag.of("name", "failedPush"));
        Metrics.gauge("nacos_monitor", tags, failedPush);
    }

    public static AtomicInteger getMysqlHealthCheckMonitor() {
        return mysqlHealthCheck;
    }

    public static AtomicInteger getHttpHealthCheckMonitor() {
        return httpHealthCheck;
    }

    public static AtomicInteger getTcpHealthCheckMonitor() {
        return tcpHealthCheck;
    }

    public static AtomicInteger getDomCountMonitor() {
        return domCount;
    }

    public static AtomicInteger getIpCountMonitor() {
        return ipCount;
    }

    public static AtomicLong getMaxPushCostMonitor() {
        return maxPushCost;
    }

    public static AtomicLong getAvgPushCostMonitor() {
        return avgPushCost;
    }

    public static AtomicLong getLeaderStatusMonitor() {
        return leaderStatus;
    }

    public static AtomicInteger getTotalPushMonitor() {
        return totalPush;
    }

    public static AtomicInteger getFailedPushMonitor() {
        return failedPush;
    }

    public static Counter getDiskException() {
        return Metrics.counter("nacos_exception",
            "module", "naming", "name", "disk");
    }

    public static Counter getLeaderSendBeatFailedException() {
        return Metrics.counter("nacos_exception",
            "module", "naming", "name", "leaderSendBeatFailed");
    }
}