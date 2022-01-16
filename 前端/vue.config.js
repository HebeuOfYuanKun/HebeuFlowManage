module.exports = {
    lintOnSave: false,
    devServer: {
        overlay: {
            warning: false,
            errors: false
        }
    },
    configureWebpack: {
        externals: {
            "AMap": "AMap"
        }
    }
    // configureWebpack: {
    //     module: {
    //         rules: [{
    //             test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
    //             include: /src/, // 在源文件目录查询
    //             use: [{ // 图片文件小于8k时编译成dataUrl直接嵌入页面，超过8k回退使用file-loader
    //                 loader: 'url-loader',
    //                 options: {
    //                     limit: 1024 * 8, // 8k
    //                     name: '[path]/[name].[ext]', // 利用[path]路径获取文件夹名称并设置文件名
    //                     fallback: 'file-loader', // 当超过8192byte时，会回退使用file-loader
    //                     context: path.resolve(__dirname, './src'), //过滤掉[path]的相对路径
    //                     publicPath: './' //采用根路径
    //                 }
    //             }]
    //         }]
    //     }
    // },
}