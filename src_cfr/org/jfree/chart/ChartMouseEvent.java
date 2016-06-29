/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.EventObject;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;

public class ChartMouseEvent
extends EventObject
implements Serializable {
    private static final long serialVersionUID = -682393837314562149L;
    private JFreeChart chart;
    private MouseEvent trigger;
    private ChartEntity entity;

    public ChartMouseEvent(JFreeChart jFreeChart, MouseEvent mouseEvent, ChartEntity chartEntity) {
        super(jFreeChart);
        this.chart = jFreeChart;
        this.trigger = mouseEvent;
        this.entity = chartEntity;
    }

    public JFreeChart getChart() {
        return this.chart;
    }

    public MouseEvent getTrigger() {
        return this.trigger;
    }

    public ChartEntity getEntity() {
        return this.entity;
    }
}

