<template>
    
    <div id="dataView">
        
        <div class="dataStream">
                
                <el-button class="datavar" type="primary" icon="el-icon-top">今日出校</el-button>{{stream.LeaveSchool}}
                <el-button class="datavar" type="primary" icon="el-icon-top">今日出市</el-button>{{stream.LeaveCity}}
                <el-button class="datavar" type="primary" icon="el-icon-top">今日出省</el-button>{{stream.LeaveProvince}}
                <el-button class="datavar" type="primary" icon="el-icon-bottom">今日入校</el-button>{{stream.EnterSchool}}
        </div>
        
        
        <div id="main" style="width:900px;height:500px;"></div>
    </div>
  
</template>

<script>
import * as echarts from 'echarts';
import {request} from '@/axios/request'

export default {
    name:"LastWeek",
    data(){
        return{
            stream:{
                LeaveSchool:null,
                LeaveCity:null,
                LeaveProvince:null,
                EnterSchool:null,
            },
            // lastweek:{
            //     LeaveSchool:null,
            //     LeaveCity:null,
            //     LeaveProvince:null,
            //     EnterSchool:null,
            //     LastWeek:new Array(),
            // }
        }
    },
    created(){
        this.getStream();
       
    },

    mounted(){
        this.drawChart();
        
    },
    
    methods:{
        getStream(){
            request({
                url:'/StudentStream',
                methods:'get'
            }).then(res=>{
                this.stream.LeaveSchool=res.data.object.schoolLeave,
                this.stream.LeaveProvince=res.data.object.provinceLeave,
                this.stream.EnterSchool=res.data.object.schoolEnter,
                this.stream.LeaveCity=res.data.object.cityLeave
            })
        },
    
        drawChart(){
 
            var myChart = echarts.init(document.getElementById('main'));
            var option;

            setTimeout(function () {
            option = {
                legend: {},
                tooltip: {
                trigger: 'axis',
                showContent: false
                },
                xAxis: { type: 'category' },
                yAxis: { gridIndex: 0 },
                grid: { top: '55%' },
                series: [
                {
                    type: 'line',
                    smooth: true,
                    seriesLayoutBy: 'row',
                    emphasis: { focus: 'series' }
                },
                {
                    type: 'line',
                    smooth: true,
                    seriesLayoutBy: 'row',
                    emphasis: { focus: 'series' }
                },
                {
                    type: 'line',
                    smooth: true,
                    seriesLayoutBy: 'row',
                    emphasis: { focus: 'series' }
                },
                {
                    type: 'line',
                    smooth: true,
                    seriesLayoutBy: 'row',
                    emphasis: { focus: 'series' }
                },
                
                ]
            };
            myChart.on('updateAxisPointer', function (event) {
                const xAxisInfo = event.axesInfo[0];
                if (xAxisInfo) {
                const dimension = xAxisInfo.value + 1;
                myChart.setOption({
                    series: {
                    id: 'pie',
                    label: {
                        formatter: '{b}: {@[' + dimension + ']} ({d}%)'
                    },
                    encode: {
                        value: dimension,
                        tooltip: dimension
                    }
                    }
                });
                }
            });
            myChart.setOption(option);
            });
            option && myChart.setOption(option);

            request({
                url:'/LastWeek',
                methods:'get'
            }).then(res=>{
                myChart.setOption({
                    dataset: {
                    source: [
                        ['近一周'].concat(res.data.object.LastWeek),
                        ['今日出校'].concat(res.data.object.SchoolLeave),
                        ['今日出市'].concat(res.data.object.CityLeave),
                        ['今日出省'].concat(res.data.object.ProvinceLeave),
                        ['今日入校'].concat(res.data.object.SchoolEnter)
                    ]
                    },
                    xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: res.data.object.LastWeek
                    },
                    series:{
                        
                    type: 'pie',
                    id: 'pie',
                    radius: '30%',
                    center: ['50%', '25%'],
                    emphasis: {
                    focus: 'self'
                    },
                    label: {
                    formatter: '{b}: {@2012} ({d}%)'
                    },
                    encode: {
                    itemName: '近一周',
                    value: res.data.object.LastWeek[0],
                    tooltip: res.data.object.LastWeek[0]
                    }
                    }
                
                })
            })
        }
        
    }
}
</script>

<style scoped>
 .dataStream {
    margin-bottom: 20px;
    /* &:last-child {
      margin-bottom: 0; */
      /* background-color: #bbb; */
    }
  #dataView{
      display: flex;
      flex-wrap:wrap;
      justify-content:center;
      align-items:center
      /* justify-items: center; */
  }
  /* .dataStream{
      display: flex;
  } */
  .datavar{
      margin-right: 20px;
      margin-left: 20px;
  }
</style>