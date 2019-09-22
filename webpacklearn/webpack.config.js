// webpack配置文件，默认找webpack.config.js
const path = require('path');
//单文件编译
/*module.exports = {
    entry: './src/index.js', // 编译入口文件
    output: {
        path: path.resolve(__dirname, 'dist'),  // 输出目录参数
        filename: "app.bundle.js" // 输出文件名
    },
    mode:'production'
}*/

// 多入口文件编译
module.exports = {
    entry: {// 编译入口文件
       app: './src/index.js', 
       hello: './src/index.js', 
    },
    output: {
        path: path.resolve(__dirname, 'dist'),  // 输出目录参数
        filename: "[name].bundle.js" // 输出文件名
    },
    mode:'production'
}