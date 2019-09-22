// 简单模拟reduxStore原理
// 相当于从一个观察者模式变形而来
const creatStore = function (reducer, initState) {
    let state = initState;
    let linsters = [];
    // 订阅者
    function subscribe(linster) {
        linsters.push(linster);
    }
    // 改变状态 这个函数就相当于reducer的dispatch
    //function changeState(action) {
    function dispatch(action) {
        state = reducer(state, action)
        linsters.forEach((linster) => {
            linster();
        })
    }
    // 获取状态
    function getState() {
        return state;
    }
    return {
        subscribe,
        dispatch,
        getState
    }
}

// 计数reducer  将reducer函数修改
function reducer(state, action) {
    switch (action.type) {
        case 'INCREMENT':
            return {
                ...state,
                count: state.count + 1
            }
        case 'DECREMENT':
            return {
                ...state,
                count: state.count - 1
            }
        default:
            return state;
    }
}

let initState = {
    count: 0
}
// 创建store初始化
let store = creatStore(reducer, initState);

// 绑定订阅者
store.subscribe(
    () => {
        console.log('订阅者1 ')
        console.log(store.getState())
    }
);

// 绑定订阅者
store.subscribe(
    () => {
        console.log('订阅者2 ')
        console.log(store.getState())
    }
);

//store.changeState({ type:'INCREMENT' });
//store.changeState({ type:'DECREMENT' });
// dispatch中传入的对象就相当于action
store.dispatch({ type: 'INCREMENT' });
store.dispatch({ type: 'DECREMENT' });
