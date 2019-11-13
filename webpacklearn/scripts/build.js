const webpack = require("webpack");
const config = require("../webpack.config");
let compiler =  webpack(config);
compiler.apply(new webpack.ProgressPlugin());
compiler.run((err,stats)=>{
    if (err) {
        console.log(err);
    } 
    else {
        console.log(stats);
    }
})
