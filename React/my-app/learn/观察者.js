
// 数据源
let state = {
    count: 0
}

// 监听者集合
let linsters = [];

// 订阅
function sub(linster) {
    linsters.push(linster)
}
// 数据源改变事件,并通知订阅者
function countChange(count){
    state.count = count;
    linsters.forEach(function(lis){
        lis();
    })
}

// 手动增加订阅者,
sub(()=>{
    console.log("1 "+ state.count);
})
// 手动增加订阅者,
sub(()=>{
    console.log("2 "+ state.count);
})

// 改变数据源
countChange(100222);
