const config1 = {}
const config2 = {
    header: ['列1', '列2', '列3'],
    data: [
        ['行1列1', '行1列2', '行1列3'],
        ['行2列1', '行2列2', '行2列3'],
        ['行3列1', '行3列2', '行3列3'],
        ['行4列1', '行4列2', '行4列3'],
        ['行5列1', '行5列2', '行5列3'],
        ['行6列1', '行6列2', '行6列3'],
        ['行7列1', '行7列2', '行7列3'],
        ['行8列1', '行8列2', '行8列3'],
        ['行9列1', '行9列2', '行9列3'],
        ['行10列1', '行10列2', '行10列3']
    ],
    index: true,
    columnWidth: [50],
    align: ['center'],
    carousel: 'page'
}
const config3 = {
    data: [{
            name: '周口',
            value: 55
        },
        {
            name: '南阳',
            value: 120
        },
        {
            name: '西峡',
            value: 78
        },
        {
            name: '驻马店',
            value: 66
        },
        {
            name: '新乡',
            value: 80
        },
        {
            name: '信阳',
            value: 45
        },
        {
            name: '漯河',
            value: 29
        }
    ]
}
const config4 = {}
const config5 = {
    points: [{
            name: '郑州',
            coordinate: [0.48, 0.35],
            icon: {
                // src: require('@/assets/mapCenterPoint.png'),
                width: 30,
                height: 30
            },
            text: {
                color: '#fb7293'
            }
        },
        {
            name: '新乡',
            coordinate: [0.52, 0.23]
        },
        {
            name: '焦作',
            coordinate: [0.43, 0.29]
        },
        {
            name: '开封',
            coordinate: [0.59, 0.35]
        },
        {
            name: '许昌',
            coordinate: [0.53, 0.47]
        },
        {
            name: '平顶山',
            coordinate: [0.45, 0.54]
        },
        {
            name: '洛阳',
            coordinate: [0.36, 0.38]
        },
        {
            name: '周口',
            coordinate: [0.62, 0.55]
        },
        {
            name: '漯河',
            coordinate: [0.56, 0.56]
        },
        {
            name: '南阳',
            coordinate: [0.37, 0.66]
        },
        {
            name: '信阳',
            coordinate: [0.55, 0.81]
        },
        {
            name: '驻马店',
            coordinate: [0.55, 0.67]
        },
        {
            name: '济源',
            coordinate: [0.37, 0.29]
        },
        {
            name: '三门峡',
            coordinate: [0.20, 0.36]
        },
        {
            name: '商丘',
            coordinate: [0.76, 0.41]
        },
        {
            name: '鹤壁',
            coordinate: [0.59, 0.18]
        },
        {
            name: '濮阳',
            coordinate: [0.68, 0.17]
        },
        {
            name: '安阳',
            coordinate: [0.59, 0.10]
        }
    ],
    lines: [{
            source: '新乡',
            target: '郑州'
        },
        {
            source: '焦作',
            target: '郑州'
        },
        {
            source: '开封',
            target: '郑州'
        },
        {
            source: '许昌',
            target: '郑州'
        },
        {
            source: '平顶山',
            target: '郑州'
        },
        {
            source: '洛阳',
            target: '郑州'
        },
        {
            source: '周口',
            target: '郑州'
        },
        {
            source: '漯河',
            target: '郑州'
        },
        {
            source: '南阳',
            target: '郑州'
        },
        {
            source: '信阳',
            target: '郑州'
        },
        {
            source: '驻马店',
            target: '郑州'
        },
        {
            source: '济源',
            target: '郑州'
        },
        {
            source: '三门峡',
            target: '郑州'
        },
        {
            source: '商丘',
            target: '郑州'
        },
        {
            source: '鹤壁',
            target: '郑州'
        },
        {
            source: '濮阳',
            target: '郑州'
        },
        {
            source: '安阳',
            target: '郑州'
        }
    ],
    icon: {
        show: true,
        // src: require('@/assets/mapPoint.png')
    },
    text: {
        show: true,
    },
    // bgImgSrc: require('@/assets/map.jpg')
}

const config6 = {
    data: [{
            name: '周口',
            value: 55
        },
        {
            name: '南阳',
            value: 120
        },
        {
            name: '西峡',
            value: 71
        },
        {
            name: '驻马店',
            value: 66
        },
        {
            name: '新乡',
            value: 80
        },
        {
            name: '信阳',
            value: 35
        },
        {
            name: '漯河',
            value: 15
        }
    ],
    img: [
        // require('@/assets/mapPoint.png'),
        // require('@/assets/mapPoint.png'),
        // require('@/assets/mapPoint.png'),
        // require('@/assets/mapPoint.png'),
        // require('@/assets/mapPoint.png'),
        // require('@/assets/mapPoint.png'),
        // require('@/assets/mapPoint.png')
    ],
    showValue: true
}

const config7 = {
    data: [{
            name: '南阳',
            value: 167
        },
        {
            name: '周口',
            value: 67
        },
        {
            name: '漯河',
            value: 123
        },
        {
            name: '郑州',
            value: 55
        },
        {
            name: '西峡',
            value: 98
        },
    ],
    unit: 'ml'
}

export { config1, config2, config3, config4, config5, config6, config7 }