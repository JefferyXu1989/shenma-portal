<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="../plugins/jquery/jquery.js"></script>
<script src="../plugins/echarts/echarts.min.js"></script>
<script src="../plugins/echarts/map/js/china.js"></script>
<html>
<head>
    <meta charset="utf-8">
    <title>地图demo</title>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="map" style="width: 1366px;height:768px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('map'));
    var data = [
        {name: '云南', value: 12},
        {name: '西藏', value: 12},
        {name: '浙江', value: 12},
        {name: '河南', value: 300},
        {name: '江苏', value: 15},
        {name: '安徽', value: 280},
        {name: '福建', value: 18},
        {name: '湖北', value: 18},
        {name: '湖南', value: 19},
        {name: '广东', value: 21},
        {name: '广西', value: 21},
        {name: '陕西', value: 21},
        {name: '甘肃', value: 22},
        {name: '青海', value: 23},
        {name: '宁夏', value: 24},
        {name: '新疆', value: 400},
        {name: '河北', value: 25},
        {name: '山西', value: 25},
        {name: '内蒙古', value: 25},
        {name: '北京', value: 25},
        {name: '上海', value: 25},
        {name: '天津', value: 25},
        {name: '重庆', value: 26},
        {name: '四川', value: 26},
        {name: '贵州', value: 200},
        {name: '江西', value: 27},
        {name: '山东', value: 27},
        {name: '辽宁', value: 27},
        {name: '吉林', value: 28},
        {name: '黑龙江', value: 100},
        {name: '台湾', value: 30},
        {name: '香港', value: 30},
        {name: '澳门', value: 31},
    ];
    var geoCoordMap = {
        '云南' :[102.52,24.35],
        '西藏':[91.11,29.97],
        '浙江':[120.06,29.32],
        '河南':[113.29,33.75],
        '江苏':[119.9,32.49],
        '安徽':[117.27,31.86],
        '福建':[119.3,26.08],
        '湖北':[114.31,30.52],
        '湖南':[112,28.21],
        '广东':[113.23,23.16],
        '广西':[109.4,24.33],
        '陕西':[108.95,34.27],
        '甘肃':[103.73,36.03],
        '青海':[101.74,36.56],
        '宁夏':[106.27,38.47],
        '新疆':[86.06,41.68],
        '河北':[115.48,38.85],
        '山西':[112.53,37.87],
        '内蒙古':[110,40.58],
        '北京':[116.46,39.92],
        '上海':[121.48,31.22],
        '天津':[117.2,39.13],
        '重庆':[106.54,29.59],
        '四川':[104.37,31.13],
        '贵州':[106.71,26.57],
        '江西':[115.89,28.68],
        '山东':[117.67,36.19],
        '辽宁':[123.73,41.3],
        '吉林':[126.57,43.87],
        '黑龙江':[126.63,45.75],
        '台湾': [114.07,22.62] ,
        '香港': [114.07,22.62] ,
        '澳门': [114.07,22.62] ,



    };

    var convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
            var geoCoord = geoCoordMap[data[i].name];
            if (geoCoord) {
                res.push({
                    name: data[i].name,
                    value: geoCoord.concat(data[i].value)
                });
            }
        }
        return res;
    };

    option = {
        backgroundColor: '#404a59',
        title: {
            text: '全国主要城市进件统计',
            subtext: '什马金融数据',
            sublink: 'http://www.shenmajr.com',
            left: 'center',
            textStyle: {
                color: '#fff'
            }
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            y: 'bottom',
            x:'right',
            data:['pm2.5'],
            textStyle: {
                color: '#fff'
            }
        },
        geo: {
            map: 'china',
            label: {
                emphasis: {
                    show: false
                }
            },
            roam: true,
            itemStyle: {
                normal: {
                    areaColor: '#323c48',
                    borderColor: '#111'
                },
                emphasis: {
                    areaColor: '#2a333d'
                }
            }
        },
        series : [
            {
                name: 'pm2.5',
                type: 'scatter',
                coordinateSystem: 'geo',
                data: convertData(data),
                symbolSize: function (val) {
                    return val[2] / 10;
                },
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#ddb926'
                    }
                }
            },
            {
                name: '最新进件',
                type: 'effectScatter',
                coordinateSystem: 'geo',
                data: convertData(data.sort(function (a, b) {
                    return b.value - a.value;
                }).slice(0, 6)),
                symbolSize: function (val) {
                    return val[2] / 10;
                },
                showEffectOn: 'render',
                rippleEffect: {
                    brushType: 'stroke'
                },
                hoverAnimation: true,
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#f4e925',
                        shadowBlur: 10,
                        shadowColor: '#333'
                    }
                },
                zlevel: 1
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.onresize = myChart.resize();
</script>
</body>
</html>