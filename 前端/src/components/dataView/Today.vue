<template>
    <div id="DayTime">
        <div class="operate">
            <el-button type="primary" icon="el-icon-refresh" @click="getDayData()">刷新数据</el-button>
             <!-- <el-button type="primary" icon="el-icon-refresh">刷新数据</el-button> -->
        </div>
        <div id="main" style="width:900px;height:500px;"></div>
    </div>
</template>

<script>
import * as echarts from 'echarts';
import {request} from '../../axios/request.js'

export default {
    name:'Today',
    mounted(){
        this.getChangeChart()
    },
    methods:{
        
        getChangeChart(){
            var chartDom = document.getElementById('main');
            var myChart = echarts.init(chartDom);
            var option;
            myChart.showLoading();
            

            request({
                url:'/DayTime',
                methods:'get'
            }).then(res=>{
                myChart.hideLoading();
                option = {
                    title: {
                        text: '今日流动情况'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {},
                    toolbox: {
                        show: true,
                        feature: {
                        dataZoom: {
                            yAxisIndex: 'none'
                        },
                        dataView: { readOnly: false },
                        magicType: { type: ['line', 'bar'] },
                        restore: {},
                        saveAsImage: {}
                        }
                    },
                    xAxis: {
                        type: 'category',
                        // boundaryGap: false,
                        data: ['00:00-03:00', '03:00-06:00', '06:00-09:00', '09:00-12:00', '12:00-15:00', '15:00-18:00', '18:00-21:00','21:00-24:00']
                    },
                    yAxis: {
                        type: 'value',
                        axisLabel: {
                        formatter: '{value}'
                        }
                    },
                    series: [
                        {
                        name: '今日出校',
                        type: 'line',
                        data: res.data.object.in,
                        markPoint: {
                            data: [
                            { type: 'max', name: 'Max' },
                            { type: 'min', name: 'Min' }
                            ]
                        },
                        markLine: {
                            data: [{ type: 'average', name: 'Avg' }]
                        }
                        },
                        {
                        name: '今日入校',
                        type: 'line',
                        data: res.data.object.out,
                        markPoint: {
                            data: [{ name: '周最低', value: -2, xAxis: 1, yAxis: -1.5 }]
                        },
                        markLine: {
                            data: [
                            { type: 'average', name: 'Avg' },
                            [
                                {
                                symbol: 'none',
                                x: '90%',
                                yAxis: 'max'
                                },
                                {
                                symbol: 'circle',
                                label: {
                                    position: 'start',
                                    formatter: 'Max'
                                },
                                type: 'max',
                                name: '最高点'
                                }
                            ]
                            ]
                        }
                        }
                    ]
                    };

                    option && myChart.setOption(option);
            })
            
        },
        getDayData(){
            myChart.showLoading();
            request({
                url:'/DayTime',
                methods:'get'
            }).then(res=>{
                myChart.hideLoading();
                myChart.setOption({
                    series: [
                        {
                        name: '今日出校',
                        type: 'line',
                        data: res.data.object.in,
                        markPoint: {
                            data: [
                            { type: 'max', name: 'Max' },
                            { type: 'min', name: 'Min' }
                            ]
                        },
                        markLine: {
                            data: [{ type: 'average', name: 'Avg' }]
                        }
                        },
                        {
                        name: '今日入校',
                        type: 'line',
                        data: res.data.object.out,
                        markPoint: {
                            data: [{ name: '周最低', value: -2, xAxis: 1, yAxis: -1.5 }]
                        }
                        }
                    ]
                })
            })
        }
    }
}
</script>

<style scoped>
#DayTime{
    display: flex;
    flex-wrap:wrap;
    justify-content:center;
    align-items:center;
    flex-direction: column;
}
.operate{
    margin-bottom: 20px;
}

</style>